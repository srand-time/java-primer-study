public class SyncDemo02{
    public static void main(String args[]){
        MyThread mt1 = new MyThread("A") ;  // 定义线程对象
        Thread t1 = new Thread(mt1) ;    // 定义Thread对象
        Thread t2 = new Thread(mt1) ;    // 定义Thread对象
        Thread t3 = new Thread(mt1) ;    // 定义Thread对象
        t1.start() ;
        t2.start() ;
        t3.start() ;
    }
};

class MyThread implements Runnable{
    private int ticket = 20 ;    // 假设一共有20张票
    private String name ;       // 表示线程的名称 

    public MyThread(String name){ 
         this.name = name ;      // 通过构造方法配置name属性 
     } 

    public void run(){
        while(true){
            synchronized(this){ // 要对当前对象进行同步
                if(ticket>0){   // 还有票
                   /*try{
                        Thread.sleep(300) ; // 加入延迟
                    }catch(InterruptedException e){
                        e.printStackTrace() ;
                    }*/
                    System.out.println("Thread "+ Thread.currentThread().getName()+"  sell : ticket = " + ticket-- );
                }
	        if(ticket==0)
		        break;
            }
        }
    }

};
