import java.util.*;
public class main
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("first number");
        int a=scanner.nextInt();
        //System.out.println(a);
        System.out.println("second number");
        int b=scanner.nextInt();
        if(a<b){int t=a;a=b;b=t;}
        //larger number first
        Inter inter=new Inter(a,b);
        int i=inter.gys();
        System.out.println("最大公约数"+i);
        int j=(a/i)*b;
        System.out.println("最小公倍数"+j);
    }
}
public class Inter
{
    private int a;
    private int b;
    public Inter(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
    public int gys()
    {
        int t;
        int x=a;
        int y=b;
        while(y!=0)
        {
            if(x==y) return x;
            else{int k=x%y;x=y;y=k;}
        }
        return x;
    }
}
