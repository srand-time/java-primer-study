//import java.util.HashMap;
//import java.util.Map;
import java.util.*;

public class MainTest {
public static void main(String[] args) {
Map<String,Integer> map = new HashMap<String,Integer>();
Scanner scan=new Scanner(System.in);
final boolean debug=true;
map.put("a", 1);
map.put("b", 2);
/*
if(debug)
    {
    String s=scan.nextLine();
    int i=scan.nextInt();
    test(map,s,i);
    }
*/

/*
for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }
*/
Integer value=map.get("c");
System.out.println(value);
System.out.println(" ");

//System.out.println(map.get("a"));
//System.out.println(map.get("b"));
//System.out.println(map.get("c"));
}

    public static void test(Map map,String s,int i)
    {
    //Map<String,String> map2 = new HashMap<>();
    //map2=map;
    map.put(s, i);
    }
}
