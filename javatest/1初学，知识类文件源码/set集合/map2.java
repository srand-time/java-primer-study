import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String,Integer>();
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        int num=scanner.nextInt();
        map.put(name,num);
        Object value=map.get(name);
        int value2=Integer.parseInt(value.toString());

        int i=3;
        i=value2+i;
        map.put(name,i);
        System.out.println(name+i);


        //map.put("apple", 123);
        //map.put("pear", 456);
        //map.put("banana", 789);

        /*
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }
        */
    }
}
