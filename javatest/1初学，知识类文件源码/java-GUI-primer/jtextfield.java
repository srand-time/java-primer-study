import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JText {
    private JTextField jtf = new JTextField("���ı����ɱ༭", 30);    // �����ı������, 30 ��
    private JPasswordField jpf = new JPasswordField("�����ı�", 30);   // ���������ı������, 30 ��
    private JTextArea jta = new JTextArea("����", 10, 30);
    // �����ı������,10�У�30��
    private JScrollPane jsp = new JScrollPane(jta);                    // ����������������ʾ�������ı�������
    public void display() {

        // ����
        JFrame f = new JFrame("�ı��༭���ܴ���");
        f.setBounds(200, 150, 350, 227);
        f.setLayout(null);

        jta.setEditable(false);
        jta.setLineWrap(true); // �����Զ�����
        jpf.setBounds(20, 10, 140, 20);
        jtf.setBounds(20, 40, 140, 20);
        jsp.setBounds(20, 70, 160, 100);

        // �������ӽ�����f��
        f.add(jpf);
        f.add(jtf);
        f.add(jsp);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        (new JText()).display();
    }
}
