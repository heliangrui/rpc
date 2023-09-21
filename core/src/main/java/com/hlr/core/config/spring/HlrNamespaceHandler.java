package com.hlr.core.config.spring;

import com.hlr.core.config.spring.bean.ConsumerBean;
import com.hlr.core.config.spring.bean.ProviderBean;
import com.hlr.core.config.spring.bean.ServerBean;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * HlrNamespaceHandler
 * Description:
 * date: 2023/9/21 10:56
 *
 * @author hlr
 */
public class HlrNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("consumer", new HlrBeanDefinitionParser(ConsumerBean.class));
        registerBeanDefinitionParser("provider", new HlrBeanDefinitionParser(ProviderBean.class));
        registerBeanDefinitionParser("server", new HlrBeanDefinitionParser(ServerBean.class));
    }
}
