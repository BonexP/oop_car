import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MForm2 {
    public static MForm2 form23;
    public JTextArea textArea1;
    public JTextArea textArea2;
    public JTextArea textArea3;
    private JButton button1;
    private JButton showAllButton;
    private JPanel panel;
    private JButton button2;
    private JLabel pos_used;
    private JLabel pos_left;

    public static void main(String[] args) throws IOException {
        new GetSQL();
        JFrame frame = new JFrame();
        MForm2 form2=new  MForm2();
        form23=form2;
        frame.setContentPane(form2.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(640,400);
        frame.setTitle("车辆管理系统");
        frame.setVisible(true);


    }

    public MForm2() {
        button1.addMouseListener(new InsertMouseListener());
        showAllButton.addMouseListener(new ShowAllListener());
        button2.addMouseListener(new GetSumListener());
        int totalPOS=100;
        int carSUm=new SQLiteOP().getCarSum();
        pos_used.setText(pos_used.getText()+":"+carSUm);
        pos_left.setText(pos_left.getText()+":"+ (totalPOS - carSUm));
        //this.setVisible(true);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void setData(MForm2 data) {
    }

    public String  getData(MForm2 data) {
        //return "\""+'+'\"+'+;
        System.out.println( "'"+data.textArea1.getText()+"','"+data.textArea1.getText()+"','"+data.textArea3.getText()+"'");
        return "'"+data.textArea1.getText()+"','"+data.textArea2.getText()+"','"+data.textArea3.getText()+"'";
    }

    public boolean isModified(MForm2 data) {
        return false;
    }

    private void createUIComponents() {
        
    }
}

//import java.awt.event.MouseEvent;

 class InsertMouseListener implements java.awt.event.MouseListener {
    final InsertRecords iR = new InsertRecords();


    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("fucked");
        //iR.insert();
        MForm2 form2=MForm2.form23;
        iR.insert(form2.getData(form2));

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

class GetSumListener implements MouseListener{
    final SQLiteOP op=new SQLiteOP();
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println( op.getCarSum());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

