**1.** **xmlns:**xsi是w3c认证的专用的命名空间，是用来引用XML Schema的，XML Schema是W3C制定的基于XML格式的XML文档结构描述标准，直接点说就是一个xml引入的XML Schema中定义了这个xml的语法。

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.2.xsd">

......以下省略中间代码

</beans>
```



**2.xml的注释:**

<!--      -->



