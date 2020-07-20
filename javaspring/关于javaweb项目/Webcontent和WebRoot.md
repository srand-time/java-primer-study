转自：https://blog.csdn.net/ftd1314/article/details/80420696





**引言：** 

​       **在MyEclipse中创建web项目后，web程序的根目录文件夹是WebRoot，而创建dynam web project时候，web程序的根**

**目录文件夹是WebContent,他们之间没有本质区别，都表示你的web程序的根目录文件夹。**



### 相同点

​             **都是web-inf 文件夹，大家都知道该目录下面的文件是不可以直接访问的，只能是Java文件调用访问，不能直接在浏览器下访问。**



​            **web-inf  是Java web的安全目录，之所以说他安全是因为客户端不可以访问，只有服务器端可以访问，如果想在客户端访问，也不是不可能，那么就在web.xml文件中对要访问的文件进行映射配置就OK了。**



​           **web-inf文件夹下除了有web.xml文件之外，还有一个class文件，用以存放\*.class文件,这些文件时网站设计人员编写的类库，实现了jsp页面前台美工与后台服务的分离，使得网站维护更加方便。web.xml文件是网站部署描述xml文件，是个牛掰的文件，对网站的部署非常重要。**

​         **当然在web-inf 文件夹下还有lib文件夹（存放jar包）。。。**



​    

###             **不同点：**

​             **WebRoot是MyEclipse创建的web项目，可以添加一些开源的框架支持，如struts、hibernate。。。也就是说web project是MyEclipse扩展后的项目，它具有dynamic web  project 特性并具有一些集成功能。**

​                 

​               **WebContent是Eclipse下面创建的dynamic web  project，与他对应的是static  web  project，dynamic web  project包含一些动态代码，如Java，而static  web  project仅包含静态文件。**