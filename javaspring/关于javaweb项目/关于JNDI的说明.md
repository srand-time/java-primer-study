JNDI：Java Naming and Directory Interface。是SUN公司推出的一套规范，属于JavaEE技术之一。目的是模仿windows系统中的注册表。用于在服务器中注册数据源。

为了保证不重，需要一个稍微完整的路径，不能只有变量名。



tomcat服务器一启动，key是一个字符串(directory(固定)+name(可以自己指定))。

而value是一个要存放的对象,通过配置文件的方式来指定。

