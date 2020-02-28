public class Testadd{
 class Student{
     public int id;
     public String name;
     public void showInfo(){
        System.out.println(id+"\t"+name);
        }
     }
 public class StudentsBiz{
    Student[] students=new Student[30];
    public void addStudent(Student stu){
        for(int i=0;i<30;i++){
                if(students[i]==null)
                {
                    students[i]=stu;
                    break;
                }
        }
    }
 }
 public void showStudents(){
    System.out.println("本班学生列表");
    for(int i=0;i<students.length;i++)
        if(students[i]!=null)
            students[i].showInfo();
    }
    public static void main(String[] args){
    Student student1=new Student();
    student1.id=10;
    student1.name="aa";
    Student student2=new Student();
    student2.id=20;
    student2.name="bb";
    StudentsBiz studentsBiz=new StudentsBiz();
    studnetsBiz.addStudent(student1);
    studnetsBiz.addStudent(student2);
    studentsBiz.showStudents();
    }
}







