转自:https://www.cnblogs.com/NinWoo/p/9788302.html

1.**Spring中的事件处理**

ApplicationContext 是Spring的核心模块，管理着Beans完整的生命周期。当加载Bean时，ApplicationContext会发布特定类型的事件。
 eg:当Context启动时ContextStartEvent被发布，当关闭时，ContextStoppedEvent被发布。

ApplicationContext事件处理被ApplicationEvent类和ApplicationListener接口提供。因此，实现了ApplicationListener的bean，每次ApplicationContext发布ApplicationEvent时，Bean将会被通知。



Spring内建事件

- **ContextRefreshedEvent** : 当ApplicationContext被初始化或者刷新时被发布。也可以通过调用ConfigurableApplicationContext接口的refresh()函数发起。
- **ContextStartedEvent** : 当Application使用ConfigurableApplicationContext的start()方法启动时被发布。您可以轮询您的数据库，也可以在收到此事件后重新启动任何已停止的应用程序。
- **ContextStoppedEvent** : 当ApplicationContext在ConfigurableApplicationContext接口上使用stop()方法停止时，就会发布这个事件。你可以在收到这个活动后做家务。
- **ContextClosedEvent** : 当使用ConfigurableApplicationContext接口上的close()方法关闭ApplicationContext时，将发布此事件。一个封闭的环境到达了生命的终点;不能刷新或重新启动。
- **RequestHandledEvent** : 这是一个特定于web的事件，它告诉所有bean HTTP请求已经得到了服务。



Spring的事件处理是单线程的，因此如果发布了一个事件，直到并且除非所有接收者都得到消息，否则进程将被阻塞，线程将不会继续。因此，如果要使用事件处理，那么在设计应用程序时应该小心。



监听Context事件：

要想监听一个context事件，bean需要实现仅有一个方法onApplicationEvent()的ApplicationListener接口



### Example

 

HelloWorld.java

 

```
public class HelloWorld {
   private String message;

   public void setMessage(String message){
      this.message  = message;
   }
   public void getMessage(){
      System.out.println("Your Message : " + message);
   }
}
```

 

CStartEventHandler.java

 

```
public class CStartEventHandler 
   implements ApplicationListener<ContextStartedEvent>{

   public void onApplicationEvent(ContextStartedEvent event) {
      System.out.println("ContextStartedEvent Received");
   }
}
```

 

CStopEventHandler

 

```
public class CStopEventHandler 
   implements ApplicationListener<ContextStoppedEvent>{

   public void onApplicationEvent(ContextStoppedEvent event) {
      System.out.println("ContextStoppedEvent Received");
   }
}
```

 

MainApp.java

 

```
public class MainApp {
   public static void main(String[] args) {
      ConfigurableApplicationContext context = 
         new ClassPathXmlApplicationContext("Beans.xml");

      // Let us raise a start event.
      context.start();
	  
      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();

      // Let us raise a stop event.
      context.stop();
   }
}
```

 

Beans

 

```
<?xml version = "1.0" encoding = "UTF-8"?>

<beans xmlns = "http://www.springframework.org/schema/beans"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation = "http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id = "helloWorld" class = "com.tutorialspoint.HelloWorld">
      <property name = "message" value = "Hello World!"/>
   </bean>

   <bean id = "cStartEventHandler" class = "com.tutorialspoint.CStartEventHandler"/>
   <bean id = "cStopEventHandler" class = "com.tutorialspoint.CStopEventHandler"/>

</beans>
```

 

输出：

```repl
ContextStartedEvent Received
Your Message : Hello World!
ContextStoppedEvent Received
```







## 自定义Spring事件

 

下边的案例将讲述如何编写和发布你自己的自定义事件

 

添加自定义事件`CustomEvent.java`,继承ApplicationEvent类

 

```
public class CustomEvent extends ApplicationEvent{
   public CustomEvent(Object source) {
      super(source);
   }
   public String toString(){
      return "My Custom Event";
   }
}
```

 

添加自定义事件发布类`CustomEventPublisher.java`，实现ApplicationEventPublisherAware接口

 

```
public class CustomEventPublisher implements ApplicationEventPublisherAware {
   private ApplicationEventPublisher publisher;
   
   public void setApplicationEventPublisher (ApplicationEventPublisher publisher) {
      this.publisher = publisher;
   }
   public void publish() {
      CustomEvent ce = new CustomEvent(this);
      publisher.publishEvent(ce);
   }
}
```

 

自定义事件监听处理类，实现ApplicationListener

 

```
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
   public void onApplicationEvent(CustomEvent event) {
      System.out.println(event.toString());
   }
}
```

 

MainApp.java

 

```
public class MainApp {
   public static void main(String[] args) {
      ConfigurableApplicationContext context = 
         new ClassPathXmlApplicationContext("Beans.xml");
	  
      CustomEventPublisher cvp = 
         (CustomEventPublisher) context.getBean("customEventPublisher");
      
      cvp.publish();  
      cvp.publish();
   }
}
```

 

Beans.xml

 

```
<beans xmlns = "http://www.springframework.org/schema/beans"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation = "http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id = "customEventHandler" class = "com.tutorialspoint.CustomEventHandler"/>
   <bean id = "customEventPublisher" class = "com.tutorialspoint.CustomEventPublisher"/>

</beans>
```

 

注意不要忘记添加customEventHandler,虽然在主函数中没有直接使用，但是context需要检查实现了ApplicationListener的
 bean,所以需要在xml文件中，添加该bean。

 

输出:

 

```
my Custom Event
my Custom Event
```