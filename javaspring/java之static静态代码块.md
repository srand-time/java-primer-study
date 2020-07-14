转自：https://www.cnblogs.com/Heliner/p/10524699.html





# [Java之static静态代码块        ](https://www.cnblogs.com/Heliner/p/10524699.html)              

​             

## 构造代码块

使用`{}`包裹的代码区域，这里的代码区域特指位于`class{}`下面的而不是存在于其他`type method(){}`这类函数下面的代码区域

```java
public class HelloA {
    /**
    ...
    */
    {
        System.out.println("I'm A construct code block");
    }

}
```

## 构造函数代码块

构造函数代码块指的是构造函数中所包含的代码,类似` className(){}`中的代码块

```java
public class HelloA {
    public HelloA(){
        System.out.println("I'm A construct method code block");
    }
}
```

## static代码块

static代码块指的是`static{}`包裹的代码块，且静态代码只执行一次，可以通过`Class.forName("classPath")`的方式唤醒代码的static代码块,但是也执行一次。

```java
public class HelloA {
    static{
        System.out.println("I'm A static code block");
    }

}
```

## 三种代码方式的执行顺序

```java
public class HelloA {
    public HelloA(){
        System.out.println("I'm A construct method code block");
    }
    {
        System.out.println("I'm A construct code block");
    }

    static {
        System.out.println("I'm A static code block");
    }

    public static void main(String[] args) {
        new HelloA();
        new HelloA();

    }
}
```

result

> I'm A static code block
>  I'm A construct code block
>  I'm A construct method code block
>  I'm A construct code block
>  I'm A construct method code block

可以看到显示static代码初始化，然后是构造方法初始化，然后是构造函数初始化，并且静态代码只会初始化一次。

### 为什么构造代码块一定在构造函数代码块前执行

这里可以直接代码编译后的文件`HelloA.class`

```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class HelloA {
   /*构造代码块直接被内联到了构造函数代码块中*/
    public HelloA() {
        System.out.println("I'm A construct code block");
        System.out.println("I'm A construct method code block");
    }

    public static void main(String[] args) {
        new HelloA();
        new HelloA();
    }

    static {
        System.out.println("I'm A static code block");
    }
}
```

因此得出结论**构造代码块直接被内联到构造函数代码块中**

并且还可以**推论**可以直接在构造代码块中调用`this`或者调用`this.method()`或者`this.staticMethod()`;

## 加上继承的情况

```java
public class HelloB extends HelloA {
    {
        System.out.println("I'm A construct  code block");
    }

    public HelloB() {
        System.out.println("I'm A construct method code block");
    }

    static {
        System.out.println("I'm B static code block");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}
```

result

> I'm A static code block
>  I'm B static code block
>  I'm A construct code block
>  I'm A construct method code block
>  I'm A construct  code block
>  I'm A construct method code block

初始化的整体顺序可以渐进的表示为

static > instace







