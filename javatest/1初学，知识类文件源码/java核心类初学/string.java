public class Main {
    public static void main(String[] args) {
        String s1 = "Hello";
        System.out.println(s1);
        String s2 = s1.toUpperCase();
        System.out.println(s2);
        System.out.println(s1.equalsIgnoreCase(s2));
        //��equalsIgnoreCase���Ժ��Դ�Сд�Ƚ�
        //������==�Ƚ�
        System.out.println("Hello".indexOf("l")); // 2
        System.out.println("Hello".lastIndexOf("l")); // 3
        System.out.println("Hello".startsWith("He")); // true
        System.out.println("Hello".endsWith("lo")); // true
        System.out.println("Hello".substring(2));
        // "llo"��2�������
        System.out.println("Hello".substring(2, 4)); //"ll"

    }
}
