package com.hlr.core.config.spring.bean;

import com.hlr.core.config.ServiceConfig;
import com.hlr.core.domain.LocalServerInfo;
import com.hlr.core.network.server.ServerSocket;
import com.hlr.core.registry.RedisRegistryCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ServerBean
 * Description:
 * date: 2023/9/21 10:58
 *
 * @author hlr
 */
public class ServerBean extends ServiceConfig implements ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(ServerBean.class);
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("启动注册中心 ...{},{}",this.host,this.port);
        RedisRegistryCenter.init(host,port);
        logger.info("启动注册中心完成");
        
        logger.info("初始化生产者服务");
        ServerSocket serverSocket = new ServerSocket(applicationContext);
        Thread thread = new Thread(serverSocket);
        thread.setDaemon(true);
        thread.start();
        
        while(!serverSocket.isActiveSocketServer()){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                
            }
        }
        logger.info("初始化生产者服务 {},{}", LocalServerInfo.LOCAL_PORT,LocalServerInfo.LOCAL_HOST);
    }
}
