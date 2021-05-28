import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MForm2 {
    public static MForm2 form23;
    public JTextArea textArea1;
    public JTextArea textArea2;
    public JTextArea textArea3;
    private JButton button1;
    private JButton 显示所有Button;
    private JPanel panel;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MForm2 form2=new  MForm2();
        form23=form2;
        frame.setContentPane(form2.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setTitle("车辆管理系统");
        frame.setVisible(true);


    }

    public MForm2() {
        button1.addMouseListener(new InsertMouseListener());
        显示所有Button.addMouseListener(new ShowAllListener());
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
}

//import java.awt.event.MouseEvent;

 class InsertMouseListener implements java.awt.event.MouseListener {
    InsertRecords iR = new InsertRecords();


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
