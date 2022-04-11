package spring_hellospring_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sk.Hello;

public class Test01 {
	public static void main(String args[]) {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		Hello hello=(Hello) context.getBean("hello");
		hello.setName("sdhio");
		hello.show();
	}
}
