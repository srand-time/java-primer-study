import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JCheckBoxAndJRadioButton {
    private JCheckBox jchb1, jchb2, jchb3;//��ѡ��
    private JRadioButton jrb1, jrb2, jrb3;//��ѡ��
    public void display() {
        // ������ѡ��true��ʾĬ��ѡ��
        jchb1 = new JCheckBox("����", true);
        jchb2 = new JCheckBox("б��");
        jchb3 = new JCheckBox("�»���");

        // ����һ����ѡ��ť����󣬴�����ѡ��ť��true��ʾĬ��ѡ��
        ButtonGroup grp = new ButtonGroup();
        jrb1 = new JRadioButton("��ɫ", true);
        jrb2 = new JRadioButton("��ɫ");
        jrb3 = new JRadioButton("��ɫ");

        // ����
        JFrame f = new JFrame("��ѡ���뵥ѡ��ťѡȡ��");
        f.setBounds(200, 150, 400, 220);
        f.setLayout(null);

        jchb1.setBounds(20, 20, 150, 20);
        jchb2.setBounds(20, 40, 150, 20);
        jchb3.setBounds(20, 60, 150, 20);

        jrb1.setBounds(20, 80, 150, 20);
        jrb2.setBounds(20, 100, 150, 20);
        jrb3.setBounds(20, 120, 150, 20);
        // �ѵ�ѡ��ť���뵽��ѡ��ť����
        grp.add(jrb1);
        grp.add(jrb2);
        grp.add(jrb3);

        f.add(jchb1);
        f.add(jchb2);
        f.add(jchb3);
        f.add(jrb1);
        f.add(jrb2);
        f.add(jrb3);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }


    public static void main(String[] args) {
        //(new JCheckBoxAndJRadioButton()).display();
        JCheckBoxAndJRadioButton jcb=new JCheckBoxAndJRadioButton();
        jcb.display();
    }
}
