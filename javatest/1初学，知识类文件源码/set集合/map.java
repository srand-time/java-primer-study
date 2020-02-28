import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        Student s = new Student("Xiao Ming", 99);
        Map<String, Student> map = new HashMap<>();
        map.put("Xiao Ming", s); // ��"Xiao Ming"��Studentʵ��ӳ�䲢����
        Student target = map.get("Xiao Ming"); // ͨ��key���Ҳ�����ӳ���Studentʵ��
        System.out.println(target == s); // true��ͬһ��ʵ��
        System.out.println(target.score); // 99

        Student s2=new Student("Bob",0);
        map.put("Bob",s2);
        Student another = map.get("Bob"); // ͨ����һ��key����
        System.out.println(another.score); // δ�ҵ�����null


    }
}

class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
