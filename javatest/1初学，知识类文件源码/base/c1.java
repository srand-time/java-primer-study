public class main{
    public static void main(String[] args){
        Person ming=new Person();
        ming.name="ming";
        ming.setage(12);
        int age=ming.getage();
        System.out.printf("age of ming %d",age);
    }
}
class Person{
    String name;
    private int age;
    public void setage(int age1){
        this.age=age1;
    }
    public int getage(){
        return this.age;
    }
}
