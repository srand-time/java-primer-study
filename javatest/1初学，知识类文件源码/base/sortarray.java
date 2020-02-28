import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int []ns={ 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        System.out.println("-------->sort1:");
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));
        System.out.printf("\n\n\n");
        for(int i=0;i<ns.length;i++)
        {
            System.out.printf("%d ",ns[i]);
        }
        System.out.printf("\n\n\n sort2:\n");
        for(int i=0;i<ns.length;i++)
        {
            ns[i]=0-ns[i];
        }
        Arrays.sort(ns);
        for(int i=0;i<ns.length;i++)
        {
            ns[i]=0-ns[i];
        }
        for(int i=0;i<ns.length;i++)
        {
            System.out.printf("%d ",ns[i]);
        }
    }
}
