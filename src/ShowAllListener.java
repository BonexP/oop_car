import java.awt.event.MouseEvent;

public class ShowAllListener implements java.awt.event.MouseListener {

    final SelectRecords sr = new SelectRecords();


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
