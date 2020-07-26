修改首页命名index.jsp :

项目中的WEB-INF下的web.xml文件中自动的生成了设置项目默认起始页为index.jsp和index.html，这样只要你的根目录下有index.jsp或index.html就会在项目启动时后默认打开此页面，你可以在web.xml文件中，对其进行修改，设置你自己想要的起始页。



```xml
<welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
</welcome-file-list>
<!-- 只要改变这个名称就可以设置你想要的起始页名称-->
```


也有可能是在一个Servers文件夹下的web.xml。

可以搜索一下。







### .jsp文件：

JSP文件后缀名为 *.jsp 。

JSP 与 PHP、ASP、ASP.NET 等语言类似，运行在服务端的语言。

JSP（全称Java Server Pages）是由 Sun Microsystems 公司倡导和许多公司参与共同创建的一种使软件开发者可以响应客户端请求,而动态生成 HTML、XML 或其他格式文档的Web网页的技术标准。JSP 技术是以 Java 语言作为脚本语言的,JSP 网页为整个服务器端的 Java 库单元提供了一个接口来服务于HTTP的应用程序。JSP开发的WEB应用可以跨平台使用，既可以运行在 Linux 上也能运行在 Windows 上。

<%@ page import="java.io.InputStream" %>

<% 中间可以直接写java代码  %>

