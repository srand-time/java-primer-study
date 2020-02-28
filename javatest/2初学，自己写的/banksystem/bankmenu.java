import java.util.*;
public class bankmenu
{
    public static void show_all_operation1()
    {
        for(int i=0;i<20;i++)
            System.out.println("");
        System.out.println("all operation displayed below:");
        System.out.println("---------------------------->>");
        System.out.printf("1.create an account");
        System.out.printf("\t2.display all account");
        System.out.printf("\n3.change the reminder of an account");
        System.out.printf("\t    4.delete an account");
        System.out.printf("\n else any number means exit");
        for(int i=0;i<3;i++)
            System.out.println("---------------------------->>");
    }


    public static void excute_an_operation(int i,Map map)
    /*parameter i means choose which operation*/
    {
        Scanner scanner=new Scanner(System.in);

        switch(i)
        {
            case 1:
                System.out.println("please input your account name");
                String name=scanner.nextLine();
                System.out.println("please input your account initial reminder");
                int re=scanner.nextInt();
                account.create(name,re,map);
                break;
            case 2:
                System.out.println("all account:");
                account.printall(map);
                break;
            case 3:
                System.out.println("please input the account name you want to change reminder");
                String name2=scanner.nextLine();
                System.out.println("The money this account have before change");
                Object value=map.get(name2);
                System.out.println(value);
                System.out.println("input change value increase or '-' means decrease");
                int add=scanner.nextInt();
                account.change(name2,add,map);
                System.out.println("After change");
                value=map.get(name2);
                System.out.println(value);
                break;
            case 4:
                System.out.println("the name of the account you want to remove");
                String name3=scanner.nextLine();
                account.delete(map,name3);
                Object value2=map.get(name3);
                if(value2==null)
                    System.out.println("successfully remove account:"+name3);
                else
                    System.out.println("error occur or no such account "+name3+" has not been removed");
                break;
        }
    }
}
