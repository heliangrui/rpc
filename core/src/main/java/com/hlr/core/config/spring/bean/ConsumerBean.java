package com.hlr.core.config.spring.bean;

import com.alibaba.fastjson.JSON;
import com.hlr.core.config.ConsumerConfig;
import com.hlr.core.domain.RpcProviderConfig;
import com.hlr.core.network.client.ClientSocket;
import com.hlr.core.network.msg.Request;
import com.hlr.core.reflect.JDKProxy;
import com.hlr.core.registry.RedisRegistryCenter;
import com.hlr.core.util.ClassLoaderUtils;
import io.netty.channel.ChannelFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.Assert;

/**
 * ConsumerBean
 * Description:
 * date: 2023/9/21 11:02
 *
 * @author hlr
 */
public class ConsumerBean<T> extends ConsumerConfig<T> implements FactoryBean<T> {

    private Logger logger = LoggerFactory.getLogger(ConsumerBean.class);

    private ChannelFuture channelFuture;

    private RpcProviderConfig rpcProviderConfig;

    @Override
    public T getObject() throws Exception {
        //从redis获取链接
        if (null == rpcProviderConfig) {
            String infoStr = RedisRegistryCenter.obtainProvider(getNozzle(), getAlias());
            rpcProviderConfig = JSON.parseObject(infoStr, RpcProviderConfig.class);
        }
        Assert.isTrue(null != rpcProviderConfig);

        //获取通信channel
        if (null == channelFuture) {
            ClientSocket clientSocket = new ClientSocket(rpcProviderConfig.getHost(), rpcProviderConfig.getPort());
            new Thread(clientSocket).start();
            for (int i = 0; i < 100; i++) {
                if (null != channelFuture) break;
                Thread.sleep(500);
                channelFuture = clientSocket.getFuture();
            }
        }
        Assert.isTrue(null != channelFuture);

        Request request = new Request();
        request.setChannel(channelFuture.channel());
        request.setNozzle(getNozzle());
        request.setRef(rpcProviderConfig.getRef());
        request.setAlias(getAlias());


        return (T) JDKProxy.getProxy(ClassLoaderUtils.forName(getNozzle()), request);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
