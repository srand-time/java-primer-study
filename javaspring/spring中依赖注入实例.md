**现在工作都用注解的方式注入。**



**1.**构造函数注入、属性注入实现代码：



constructor-arg：通过构造函数注入。
  property：通过setxx方法注入。



xml文件：

```xml
	<bean id="FirstBean" class="smart.springdemo_whole.FirstBean" 
	init-method="init" destroy-method="destroy"
	scope="singleton">
    	<property name="message" value="i love Spring!"></property>
	</bean>
	
	<bean id="secondBean" class="smart.springdemo_whole.SecondBean">
	<constructor-arg type="int" value="520"></constructor-arg>
	<constructor-arg type="java.lang.String" value="JAVAER"></constructor-arg>
	<!--
	<constructor-arg name="frtBean" ref="FirstBean"></constructor-arg>
	-->
	<property name="firstBean" ref="FirstBean"></property>
	
	<property name="thirdBean" ref="thirdBean"></property>
	</bean>
	
	<bean id="thirdBean" class="smart.springdemo_whole.ThirdBean">
    <property name="listProp">
        <list>
            <value>100</value>
            <value>2</value>
            <value>3</value>
            <value>4</value>
            <value>5</value>
            <value>6</value>
            <value>7</value>
            <value>8</value>
            <value>9</value>
        </list>
    </property>
	</bean>
```



SecondBean.java：

```java
public class SecondBean {
	private int intProp;
    private String strProp;
    private ThirdBean thirdBean;
    private FirstBean firstBean;
    

public SecondBean(int ipro,String sPro){
    this.intProp=ipro;
    this.strProp=sPro;
}

    
public int getIntProp() {
    return intProp;
}
 
public void setIntProp(int intProp) {
    this.intProp = intProp;
}
 
public String getStrProp() {
    return strProp;
}
 
public void setStrProp(String strProp) {
    this.strProp = strProp;
}
 
public ThirdBean getThirdBean() {
    return thirdBean;
}

public void setFirstBean(FirstBean firstBean){
	this.firstBean = firstBean;
}

public void setThirdBean(ThirdBean thirdBean) {
    this.thirdBean = thirdBean;
}

public void outPutAll() {
    System.out.println("output start>>>>");
    System.out.printf("intProp:%d,strProp:%s %n",intProp,strProp);
    firstBean.showMessage(strProp);
    
    List<Integer> list=thirdBean.getListProp();
    StringBuffer strBuffer=new StringBuffer();
    
    for(Integer i:list)
    {
        strBuffer.append(i.toString()+",");
    }
     
    System.out.println(strBuffer.toString());
     
    System.out.println("output end<<<<");
}

}
```



ThirdBean.java：

```
public class ThirdBean {
	private List<Integer> listProp;
	 
public List<Integer> getListProp() {
    return listProp;
}
 
public void setListProp(List<Integer> listProp) {
    this.listProp = listProp;
}

}
```



FirstBean.java:

```java
package smart.springdemo_whole;

public class FirstBean {
    private String uuidStr = java.util.UUID.randomUUID().toString();
 
    private String message;
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
 
    }
 
    public void showMessage(String name) {
        System.out.printf("hello,%1$s,Message:%2$s UUID:%3$s %n", name, message, uuidStr);
    }
 
    public void throwEx() throws Exception {
        throw new Exception("throw a new Exception!");
    }
 
    public void init() {
        System.out.println(uuidStr + ":init...");
    }
 
    public void destroy() {
        System.out.println("destroy...");
    }
}

```



主函数:APP.java

```java
    public static void main( String[] args ) {
    // TODO Auto-generated method stub
    ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
    context.start();
     
    //FirstBean firstBean= (FirstBean)context.getBean("FirstBean");
    //firstBean.showMessage("梦在旅途");
    SecondBean secondBean=(SecondBean)context.getBean("secondBean");
    secondBean.outPutAll();
    
    context.close();
     
    context.registerShutdownHook();
    }
```







**2.**通过JAVA注解来配置依赖注入，这样Bean配置文件可以少些配置，要实现注解配置依赖注入首先需要在Bean配置文件的根元素（beans）添加context命名空间,然后去掉相关的依赖注入的元素节点，最后改造完成的bean配置如下：

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-4.3.xsd">
 
    <context:annotation-config />
 
    <bean id="FirstBean" class="smart.springdemo_whole.FirstBean" 
	init-method="init" destroy-method="destroy"
	scope="singleton">
    	<property name="message" value="i love Spring!"></property>
	</bean>
	

	<bean id="secondBean" class="smart.springdemo_whole.SecondBean">
	<constructor-arg type="int" value="520"></constructor-arg>
	<constructor-arg type="java.lang.String" value="JAVAER"></constructor-arg>

	</bean>
	
	
	<bean id="thirdBean" class="smart.springdemo_whole.ThirdBean">
    <property name="listProp">
        <list>
            <value>100</value>
            <value>2</value>
            <value>3</value>
            <value>4</value>
            <value>5</value>
            <value>6</value>
            <value>7</value>
            <value>8</value>
            <value>9</value>
        </list>
    </property>
	</bean>
	
</beans>
```

配置变化点：(1)<bean>标签中增加了context命名空间及对应的schemaLocation信息，

(2)然后添加了<context:annotation-config />元素，该元素告诉Spring IOC容器采要注解配置，

(3)最后移除了有关之前使用ref的依赖注入的元素，改为在代码中通过如下一系列注解来实现：

​		给FirstBean增加@PostConstruct、@PreDestroy注解，用于指示初始回调、销毁回调方法并且

​		import javax.annotation.*;



FirstBean.java

```
import javax.annotation.*;

@PostConstruct
    public void init() {
        System.out.println(uuidStr + ":init...");
    }
 
    @PreDestroy
    public void destroy() {
        System.out.println("destroy...");
    }
```





SecondBean.java

```
@Autowired(required=true)
    public SecondBean(int ipro,String sPro,@Qualifier("FirstBean") FirstBean frtBean){
        this.intProp=ipro;
        this.strProp=sPro;
        this.firstBean=frtBean;
    }
    
@Autowired(required=true)
    public void setThirdBean(ThirdBean thirdBean) {
        this.thirdBean = thirdBean;
    }
    

```

@Autowired构造函数和属性。

@Autowired默认是按byType模式进行自动装配（即：bean的类型与被标注的成员：字段、属性、构造函数参数类型相同即为匹配注入），如果存在注册多个相同的bean类型，这时可能会报错，因为Spring容器不知道使用哪个类型进行注入实例，如果上面示例的Bean配置文件中的FirstBean定义了有两个，只是id不同，那么这种情况我们就需要使用@Qualifier("firstBean2")来显式指定注入哪个bean；



另外@Autowired(required=true)中的required表示是否必需依赖注入，如果为true，且在bean配置文件中没有找到注入的bean则会报错，如果为false则在注入失败时忽略，即为默认值。