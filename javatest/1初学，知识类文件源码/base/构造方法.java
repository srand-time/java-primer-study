public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Xiao Ming", 15); // �ȿ��Ե��ô������Ĺ��췽��
        Person p2 = new Person(); // Ҳ���Ե����޲������췽��
        int age=p1.getAge();
        System.out.printf("%d",age);
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
