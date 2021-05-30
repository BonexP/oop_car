import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
        MForm2 form2 = new MForm2();
        form23 = form2;
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
    final int totalPOS = 100;

    public MForm2() {
        button1.addMouseListener(new InsertMouseListener());
        showAllButton.addMouseListener(new ShowAllListener());
        button2.addMouseListener(new GetSumListener());
        car_in.addMouseListener(new CarInMouseListener());
        car_out.addMouseListener(new CarOutMouseListener());
        refresh.addMouseListener(new RefreshMouseListener());
        int carSUm = new SQLiteOP().getCarSum();
        used_count.setText(String.valueOf(carSUm));
        left_count.setText(String.valueOf(totalPOS - carSUm));
        charge.addMouseListener(new ChargeMouseListener());

        //this.setVisible(true);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        textArea1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textArea1.setText("");
            }
        });
    }


    public void setData(MForm2 data) {
    }

    public String getData(MForm2 data) {
        //return "\""+'+'\"+'+;
        System.out.println("'" + data.textArea1.getText() + "','" + data.textArea1.getText() + "','" + data.textArea3.getText() + "'");
        carBrandCheck(data.textArea1.getText());
        timeCheck(data.textArea2.getText());
        timeCheck(data.textArea3.getText());

        return "'" + data.textArea1.getText() + "','" + data.textArea2.getText() + "','" + data.textArea3.getText() + "','";
    }

    public boolean isModified(MForm2 data) {
        return false;
    }

    private void createUIComponents() {

    }

    public boolean IsTime(String Time){
        if (Time.length()!=4)
            return false;
        int Hour=Integer.parseInt(Time.substring(0,2));
        int Minute=Integer.parseInt(Time.substring(2,4));
        return Hour >= 0 && Hour <= 24 && Minute >= 0 && Minute <= 60;
    }
    public boolean IsCarBrand(String CarBrand){
        String cb;//=CarBrand.substring(CarBrand.length()-6);
        cb=CarBrand;
        //char c;
        //for(int i=0;i<5;i++){
        //    c=cb.charAt(i);
        //    if(!Character.isDigit(c))&&(c<65||c>90)&&(c<97||c>122))
        //    return false;
        //}
        //return true;
        return cb.matches("[a-zA-Z0-9]{5}");
    }

    public  void timeCheck(String time){
        if (IsTime(time)) {
        }
        else{
            warn("时间错误",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void carBrandCheck(String carBrand) {
        if (!IsCarBrand(carBrand)) {
            warn("车牌错误",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void warn(String info,int type){
        JOptionPane.showMessageDialog(new JPanel(), info, "汽车管理系统",type);
    }
    public int charge(String timein,String timeout) {
        int ti0 = Integer.parseInt(timein.substring(0,2));
        int ti1 = Integer.parseInt(timeout.substring(2,4));
        int to0 = Integer.parseInt(timein.substring(0,2));
        int to1 = Integer.parseInt(timeout.substring(2,4));
        int f=0,charge;
        if(to1-ti1>=30)
            f=1;
        charge=(to0-ti0+f)*5+5;
        return charge;
    }
    class CarInMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            carBrandCheck(textArea1.getText());
            timeCheck(textArea2.getText());
            if (!IsTime(textArea2.getText()))
                return;
            if (!IsCarBrand(textArea1.getText()))
                return;
            new SQLiteOP().carIn(textArea1.getText(), textArea2.getText());
            int carSUm = new SQLiteOP().getCarSum();
            used_count.setText(String.valueOf(carSUm));
            left_count.setText(String.valueOf(totalPOS - carSUm));
            warn("车辆进入",JOptionPane.INFORMATION_MESSAGE);
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

    class CarOutMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            SQLiteOP sqLiteOP = new SQLiteOP();
            carBrandCheck(textArea1.getText());
            timeCheck(textArea2.getText());
            sqLiteOP.carOut(textArea1.getText(), textArea3.getText());
            new Charger(charge(textArea2.getText(),textArea3.getText()));
            int carSUm = sqLiteOP.getCarSum();
            sqLiteOP.refresh();
            used_count.setText(String.valueOf(carSUm));
            left_count.setText(String.valueOf(totalPOS - carSUm));
            warn("车辆离开",JOptionPane.INFORMATION_MESSAGE);
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

    static class RefreshMouseListener implements MouseListener {
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

    class ChargeMouseListener implements MouseListener{


        @Override
        public void mouseClicked(MouseEvent e) {
            try {

                new Charger(charge(textArea2.getText(), textArea3.getText()));
            }
            catch (StringIndexOutOfBoundsException e1){
                warn(e1.getMessage(),JOptionPane.WARNING_MESSAGE);
            }

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
            MForm2 form2 = MForm2.form23;
            System.out.println(form2.getData(form2) + "1'");
            iR.insert(form2.getData(form2) + "1'");
            int carSUm = new SQLiteOP().getCarSum();
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

    static class GetSumListener implements MouseListener {
        final SQLiteOP op = new SQLiteOP();

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(op.getCarSum());
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
