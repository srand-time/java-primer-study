import java.util.*;
public class main
{
    public static void main(String []args)
    {
        Scanner scanner=new Scanner(System.in);
        int in_1;
        Map<String,Integer>map=new HashMap<String,Integer>();
        while(true)
        {
            bankmenu.show_all_operation1();
            in_1=scanner.nextInt();
            if(in_1<1||in_1>4)
            {break;}
            bankmenu.excute_an_operation(in_1,map);
        }
    }
}


