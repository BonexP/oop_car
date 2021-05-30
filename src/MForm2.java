import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

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
    private JLabel used_count;
    private JLabel left_count;
    private JButton car_in;
    private JButton car_out;
    private JButton refresh;
    private JButton charge;

    public static void main(String[] args) throws IOException {
        new GetSQL();
        JFrame frame = new JFrame();
        MForm2 form2=new  MForm2();
        form23=form2;
        frame.setContentPane(form2.panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(700,400);
        frame.setTitle("车辆管理系统");
        frame.setVisible(true);
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


    }
    int totalPOS=100;
    public MForm2() {
        button1.addMouseListener(new InsertMouseListener());
        showAllButton.addMouseListener(new ShowAllListener());
        button2.addMouseListener(new GetSumListener());
        car_in.addMouseListener(new CarInMouseListener());
        car_out.addMouseListener(new CarOutMouseListener());
        refresh.addMouseListener(new RefreshMouseListener());
        int carSUm=new SQLiteOP().getCarSum();
        used_count.setText(String.valueOf(carSUm));
        left_count.setText(String.valueOf(totalPOS - carSUm));

        //this.setVisible(true);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void setData(MForm2 data) {
    }

    public String  getData(MForm2 data) {
        //return "\""+'+'\"+'+;
        System.out.println( "'"+data.textArea1.getText()+"','"+data.textArea1.getText()+"','"+data.textArea3.getText()+"'");
        return "'"+data.textArea1.getText()+"','"+data.textArea2.getText()+"','"+data.textArea3.getText()+"','";
    }

    public boolean isModified(MForm2 data) {
        return false;
    }

    private void createUIComponents() {

    }
    class CarInMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            new SQLiteOP().carIn(textArea1.getText(),textArea2.getText());
            int carSUm=new SQLiteOP().getCarSum();
            used_count.setText(String.valueOf(carSUm));
            left_count.setText(String.valueOf(totalPOS - carSUm));

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
    class CarOutMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            SQLiteOP sqLiteOP =  new SQLiteOP();
            sqLiteOP.carOut(textArea1.getText(),textArea3.getText());
            int carSUm=sqLiteOP.getCarSum();
            sqLiteOP.refresh();
            used_count.setText(String.valueOf(carSUm));
            left_count.setText(String.valueOf(totalPOS - carSUm));

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
    class RefreshMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            new SQLiteOP().refresh();
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
    class InsertMouseListener implements java.awt.event.MouseListener {
        final InsertRecords iR = new InsertRecords();


        @Override
        public void mouseClicked(MouseEvent e) {
            //System.out.println("fucked");
            //iR.insert();
            MForm2 form2=MForm2.form23;
            System.out.println(form2.getData(form2)+"1'");
            iR.insert(form2.getData(form2)+"1'");
            int carSUm=new SQLiteOP().getCarSum();
            used_count.setText(String.valueOf(carSUm));
            left_count.setText(String.valueOf(totalPOS - carSUm));



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

//
//    class InsertMouseListener implements java.awt.event.MouseListener {
//        final InsertRecords iR = new InsertRecords();
//
//
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            //System.out.println("fucked");
//            //iR.insert();
//            MForm2 form2=MForm2.form23;
//            iR.insert(form2.getData(form2));
//
//
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//
//        }
//    }

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

}
//
////import java.awt.event.MouseEvent;
//
//class InsertMouseListener implements java.awt.event.MouseListener {
//    final InsertRecords iR = new InsertRecords();
//
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        //System.out.println("fucked");
//        //iR.insert();
//        MForm2 form2=MForm2.form23;
//        iR.insert(form2.getData(form2));
//
//
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//}
//
//// class GetSumListener implements MouseListener{
//    final SQLiteOP op=new SQLiteOP();
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        System.out.println( op.getCarSum());
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//}
//
