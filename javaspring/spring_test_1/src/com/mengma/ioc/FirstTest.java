package com.mengma.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class FirstTest {
    @Test
    public void testl() {
        // 定义Spring配置文件的路径
        String xmlPath = "bean.xml";
        // 初始化Spring容器，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        // 通过容器获取personDao实例
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
        // 调用 personDao 的 add ()方法
        personDao.add();
    }
}
