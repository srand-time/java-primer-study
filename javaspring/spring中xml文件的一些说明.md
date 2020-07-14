xml文件不要加一些乱七八糟的空格或者换行，很可能会诱发错误。



**1.** **xmlns:**xsi是w3c认证的专用的命名空间，是用来引用XML Schema的，XML Schema是W3C制定的基于XML格式的XML文档结构描述标准，直接点说就是一个xml引入的XML Schema中定义了这个xml的语法。



beans.xml头部配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.2.xsd">

......以下省略中间代码

</beans>
```





**2.xml的注释:**

<!--      -->



