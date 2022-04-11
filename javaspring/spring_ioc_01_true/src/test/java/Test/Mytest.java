package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Service.UserServiceImpl;
import UserDao.UserDao;

public class Mytest {
	public static void main(String args[]) {
		//System.out.println();
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		UserServiceImpl user01=(UserServiceImpl) context.getBean("user01");
		user01.getUser();
	}
}
