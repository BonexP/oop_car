import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.peer.MouseInfoPeer;


public class MFrame extends JFrame {
//    Panel p=new Panel();
//    //p.(new JButton("草我"));
//    //this.add(new JButton("草我"));
//    JFrame frame = new JFrame();
//    JPanel jp=new JPanel();
    static TextField chepai=new TextField(20);
    static TextField timein=new TextField(20);
    static TextField timeout=new TextField(20);
    MFrame()
    {
        this.setLayout(new GridLayout(4,1));
        JPanel p1= new JPanel();
        JPanel p2= new JPanel();

        JButton fuckme =new JButton("草我");
        fuckme.addMouseListener(new MyMouseListener());
        fuckme.setSize(200,200);
        p1.setSize(500,200);
        p1.add(chepai,new FlowLayout());
        p1.add(timein,new FlowLayout());
        p1.add(timeout,new FlowLayout());
        p1.add(fuckme);
        this.add(p1);
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
        //this.add(new MForm2(),BorderLayout.SOUTH);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }


}

