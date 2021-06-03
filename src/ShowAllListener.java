import java.awt.event.MouseEvent;

public class ShowAllListener implements java.awt.event.MouseListener,Runnable {

    final SelectRecords sr = new SelectRecords();

    @Override
    public void run() {
        new ShowAll().main(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("fucked");

        sr.selectAll();
        //new ShowAll().main(null);
        run();

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
