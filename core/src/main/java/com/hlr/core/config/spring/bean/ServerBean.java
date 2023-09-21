package com.hlr.core.config.spring.bean;

import com.hlr.core.config.ServiceConfig;
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
        
        logger.info("启动netty服务");
    }
}
