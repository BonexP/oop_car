import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.peer.MouseInfoPeer;


public class frame extends Frame {
//    Panel p=new Panel();
//    //p.(new JButton("草我"));
//    //this.add(new JButton("草我"));
//    JFrame frame = new JFrame();
//    JPanel jp=new JPanel();
    static TextField chepai=new TextField(20);
    static TextField timein=new TextField(20);
    static TextField timeout=new TextField(20);
    frame()
    {
        this.setLayout(new GridLayout(4,1));
        JButton fuckme =new JButton("草我");
        fuckme.addMouseListener(new MyMouseListener());
        fuckme.setSize(200,200);
        JPanel p1= new JPanel();
        p1.setSize(500,200);
        p1.add(chepai,new FlowLayout());
        p1.add(timein,new FlowLayout());
        p1.add(timeout,new FlowLayout());
        p1.add(fuckme);
        this.add(p1);
        JPanel p2= new JPanel();
        p2.setSize(500,200);
        JButton showall=new JButton("显示所有");
        showall.addMouseListener(new ShowAllListener());
        p2.add(showall,BorderLayout.CENTER);
        this.add(p2);
//        p2.add(new TextField(30));
//        this.add(p2,BorderLayout.NORTH);
//        JPanel p3= new JPanel();
//        p3.add(new TextField(30));
//        this.add(p3,BorderLayout.NORTH);

        this.setSize(600,500);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.show();
    }

}

class MyMouseListener implements java.awt.event.MouseListener {
    InsertRecords iR = new InsertRecords();

    public MyMouseListener() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("fucked");
        iR.insert();

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
class ShowAllListener implements java.awt.event.MouseListener {

    SelectRecords sr=new SelectRecords();



    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("fucked");
        sr.selectAll();

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