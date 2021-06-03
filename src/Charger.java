import javax.swing.*;

public class Charger {
    public JPanel panel1;
    private JLabel chargerMoney;
//    private JPanel photo;

    public Charger(){
        JFrame jFrame=new JFrame();
        jFrame.setContentPane(panel1);
        ImageIcon imageIcon=new ImageIcon("res/img/money.png");
        //jFrame.setSize(500,400);
        jFrame.setVisible(true);
        //photo.add(new JLabel(new ImageIcon("res\\img\\index.png")));
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setIconImage(imageIcon.getImage());
        jFrame.setTitle("缴费面板");
        jFrame.pack();
    }
    public Charger(int number){
        this();
        chargerMoney.setText(chargerMoney.getText()+ number +"元");

    }

}
