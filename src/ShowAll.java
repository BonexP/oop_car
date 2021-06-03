import javax.swing.*;
import java.awt.event.*;

public class ShowAll extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea1;

    public ShowAll() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        textArea1.setText(new SelectRecords().selectAll(1));
        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // 单击十字时调用 onCancel()
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // 遇到 ESCAPE 时调用 onCancel()
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // 在此处添加代码
        dispose();
    }

    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }

    public static void main(String[] args) {
        ShowAll dialog = new ShowAll();
        dialog.pack();
        ImageIcon imageIcon=new ImageIcon("res/img/icon.png");
        dialog.setIconImage(imageIcon.getImage());
        dialog.setTitle("车库总览");
        dialog.setVisible(true);
        //System.exit(0);
    }
}
