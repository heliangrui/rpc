package com.hlr.core;

import com.hlr.core.service.HelloService;
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
        String[] configs = {"itstack-rpc-consumer.xml","applicationContext.xml"};
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(configs);

        HelloService consumerHelloService = (HelloService)classPathXmlApplicationContext.getBean("consumer_helloService");
        HelloService consumerHelloService1 = (HelloService)classPathXmlApplicationContext.getBean("helloService");
        consumerHelloService1.echo();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                    consumerHelloService.echo();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        
        thread.start();
        
        
    }

}
