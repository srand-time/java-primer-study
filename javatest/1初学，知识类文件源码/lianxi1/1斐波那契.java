import java.util.*;
public class fb{
    public static void main(String args[])
    {
        int f,f1,f2;
        f1=1;
        f2=1;
        for(int i=0;i<=12;i++)
        {
            System.out.println("第"+i+"个月的兔子数目"+f1);
            f=f1;
            f1=f2;
            f2=f+f1;
        }

        System.out.println("method 2:------->");
        int []a=new int[13];
        a[0]=1;
        a[1]=1;
        for(int i=2;i<=12;i++)
            a[i]=a[i-1]+a[i-2];
        for(int i=0;i<=12;i++)
            System.out.println("第"+i+"个月"+a[i]);
    }
}
