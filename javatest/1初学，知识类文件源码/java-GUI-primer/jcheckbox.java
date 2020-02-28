import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JCheckBoxAndJRadioButton {
    private JCheckBox jchb1, jchb2, jchb3;//复选框
    private JRadioButton jrb1, jrb2, jrb3;//单选框
    public void display() {
        // 创建复选框，true表示默认选中
        jchb1 = new JCheckBox("粗体", true);
        jchb2 = new JCheckBox("斜体");
        jchb3 = new JCheckBox("下划线");

        // 创建一个单选按钮组对象，创建单选按钮，true表示默认选中
        ButtonGroup grp = new ButtonGroup();
        jrb1 = new JRadioButton("红色", true);
        jrb2 = new JRadioButton("蓝色");
        jrb3 = new JRadioButton("绿色");

        // 布局
        JFrame f = new JFrame("复选框与单选按钮选取框");
        f.setBounds(200, 150, 400, 220);
        f.setLayout(null);

        jchb1.setBounds(20, 20, 150, 20);
        jchb2.setBounds(20, 40, 150, 20);
        jchb3.setBounds(20, 60, 150, 20);

        jrb1.setBounds(20, 80, 150, 20);
        jrb2.setBounds(20, 100, 150, 20);
        jrb3.setBounds(20, 120, 150, 20);
        // 把单选按钮加入到单选按钮组中
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
