     public class RunnableDemo01{ 
         public static void main(String args[]){ 
         MyThread mt1 = new MyThread("theard A ") ;    // 实例化对象 
         MyThread mt2 = new MyThread("theard B ") ;    // 实例化对象 
         MyThread mt3 = new MyThread("theard C ") ;    // 实例化对象 
         Thread t1 = new Thread(mt1) ;       // 实例化Thread类对象 
         Thread t2 = new Thread(mt2) ;       // 实例化Thread类对象 
         Thread t3 = new Thread(mt3) ;       // 实例化Thread类对象 
         t1.start() ;    // 启动多线程 
         t2.start() ;    // 启动多线程 
         t3.start();
     } 
};

class MyThread implements Runnable{ // 实现Runnable接口，作为线程的实现类 
     private String name ;       // 表示线程的名称 
     public MyThread(String name){ 
         this.name = name ;      // 通过构造方法配置name属性 
     } 
     public void run(){  // 覆写run()方法，作为线程 的操作主体 
         for(int i=0;i<10;i++){ 
             System.out.println(name + "run,i = " + i) ; 
         } 
     } 
 };
 
