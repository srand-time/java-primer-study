package com.mengma.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class FirstTest {
    @Test
    public void testl() {
        // ����Spring�����ļ���·��
        String xmlPath = "bean.xml";
        // ��ʼ��Spring���������������ļ�
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        // ͨ��������ȡpersonDaoʵ��
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
        // ���� personDao �� add ()����
        personDao.add();
    }
}
