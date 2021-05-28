import java.awt.event.MouseEvent;

public class MyMouseListener implements java.awt.event.MouseListener {
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
