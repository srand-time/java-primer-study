import java.util.*;
public class account
{
    public static void create(String name,int re,Map map)
    {
        map.put(name,re);
    }
    public static void printall(Map map)
    {
        for(Object key:map.keySet())
        {
            Object value=map.get(key);
            System.out.println("account: "+key +"\t money: "+ value);
        }
    }
    public static void change(String name,int add,Map map)
    {
        Object value=map.get(name);
        if(value==null)
        {
            System.out.println("no such name account");
        }
        else
        {
            int value2=Integer.parseInt(value.toString());
            value2=value2+add;
            map.put(name,value2);
        }
    }
    public static void delete(Map map,String name)
    {
        boolean flag=false;
        for(Object key:map.keySet())
        {
                if(key.equals(name))
                    {
                        map.remove(key);
                        flag=true;
                        break;
                    }
        }
        if(!flag)
        {
            System.out.println("no such name account"+name);
        }
    }
}
