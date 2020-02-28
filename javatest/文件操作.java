import java.io.*;
class FileAccept implements FilenameFilter{
    String str=null;
    FileAccept(String s)
        {
            str="."+s;
        }
    public boolean accept(File dir,String name)
        {
            return name.endsWith(str);
        }
}
//接受后缀名为（.s）s为参数,的文件。

public class Example9_1{
    public static void main(String args[])
        {
            File dir=new File("F:/java/javatest");
            FileAccept acceptCondition=new FileAccept("java");
            File fileName[]=dir.lastFiles(acceptCondition);
            for(int i=0;i<fileName.length;i++)
            {
                System.out.printf("\n文件名称:%s \t 长度:%d\t",
                fileName[i].getName(),fileName[i].length());
            }
        }
}
