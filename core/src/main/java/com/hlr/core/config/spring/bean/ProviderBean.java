package com.hlr.core.config.spring.bean;

import com.hlr.core.config.ProviderConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ProviderBean
 * Description:
 * date: 2023/9/21 11:00
 *
 * @author hlr
 */
public class ProviderBean extends ProviderConfig implements ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(ProviderBean.class);
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("生产者消息注册,{}",this.getAlias());
    }
}
