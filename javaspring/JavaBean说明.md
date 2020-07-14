来源：百度百科



javabean是一种**规范，而不是一种技术或工具。**

在java语言层面上与普通的类没有区别

区别在于，某些被设计成处理javabean的框架或者工具，能按照他们的方式处理你的javabean。这就是所谓的隐藏属性了。



### 概述

JavaBean 是一种JAVA语言写成的可重用组件。为写成JavaBean，类必须是具体的和公共的，并且具有无参数的[构造器](https://baike.baidu.com/item/构造器/9844976)。JavaBean 通过提供符合一致性设计模式的公共方法将内部域暴露成员属性，set和get方法获取。众所周知，属性名称符合这种模式，其他Java 类可以通过自省机制(反射机制)发现和操作这些JavaBean 的属性。



它包含属性(Properties)、方法(Methods)、事件(Events)等特性。



### 特征

第一，其中JavaBean为共有类，此类要使用访问权限对public进行修饰，主要是为了方便JSP的访问；

###  [ ![Javabean](https://bkimg.cdn.bcebos.com/pic/30adcbef76094b361f609a43adcc7cd98c109daa?x-bce-process=image/resize,m_lfit,w_250,h_250,limit_1) ](https://baike.baidu.com/pic/JavaBean/529577/0/30adcbef76094b361f609a43adcc7cd98c109daa?fr=lemma&ct=single)  Javabean 

第二，JavaBean定义构造的方式时，一定要使用public修饰，同时不能要参数，不定义构造方式时，Java编译器可以构造无参数方式；

第三，JavaBean属性通常可以使用访问权限对private进行修饰，此种主要表示私有属性，但是也只能在JavaBean内使用，在声明中使用public修饰的则被认为是公有权限，主要是方便同时JSP进行交互； 

第四，使用setXXX()的方法以及getXXX()的方法得到JavaBean里的私有属性XXX数值； 

第五，JavaBean--定要放在包内，使用package进行自定义，也可以放在JavaBean代码第一行； 

第六，对于部署好的JavaBean修改是，一定要重新编译节码文件，同时启动Tomcat服务器，之后便能够生效。 





# 工厂模式介绍

工厂模式：用来解决对象类型的创建问题，我们可以把bean交给properies配置文件管理，在配置文件中配置我们需要的类型，工厂只负责对象的创建。





bean标签：

》》作用：用于配置对象让spring来创建它

