package com.hlr.core;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/5/4
 * 本章节主要介绍如何读取自定义配置xml文件字段信息
 */
public class ApiTest {
     private static final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    public static void main(String[] args) {
        String[] configs = {"itstack-rpc-consumer.xml"};
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(configs);

        Object consumerHelloService = classPathXmlApplicationContext.getBean("consumer_helloService");
        
        logger.info(JSONObject.toJSONString(consumerHelloService));
        
    }

}
