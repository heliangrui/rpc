package com.hlr.core.config.spring.bean;

import com.hlr.core.config.ConsumerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * ConsumerBean
 * Description:
 * date: 2023/9/21 11:02
 *
 * @author hlr
 */
public class ConsumerBean<T> extends ConsumerConfig<T> implements FactoryBean<T> {

    private Logger logger = LoggerFactory.getLogger(ConsumerBean.class);

    @Override
    public T getObject() throws Exception {
        logger.info("开始加载consumerBean。。。。。,{}", this.getAlias());

        logger.info("加载远程服务");

        logger.info("生成代理对象");


        return null;
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
