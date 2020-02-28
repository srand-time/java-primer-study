import java.util.*;
public class main
{
    public static void main(String[] args)
    {
        System.out.println("求输入数的阶乘");
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        Jie b=new Jie();
        System.out.println(b.qiujc(a));
    }
}
class Jie
{
    public int qiujc(int n)
    {
        if(n==1)
            return 1;
        else
            return qiujc(n-1)*n;
    }
}
