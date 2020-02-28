//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();//链表实现
        list.add("apple"); // size=1
        list.add("pear"); // size=2
        list.add("apple"); // 允许重复添加元素，size=3
        list.remove(1);
        list.add(1,"p3");
        //System.out.println(list.size());
        for(int i=0;i<list.size();i++)
        {
           System.out.println(list.get(i));
        }
        //this method is not so fast

        list.remove("p3");
        System.out.println();
        System.out.println(list.size());


        //faster
        for(Iterator<String> it = list.iterator(); it.hasNext(); )
        {
            String s = it.next();
            System.out.println(s);
        }

        //faster 2
        for (String s : list)
        {
            System.out.println(s);
        }
    }
}
