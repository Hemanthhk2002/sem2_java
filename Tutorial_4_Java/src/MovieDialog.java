import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieDialog extends JDialog implements ActionListener {
    private JTextField titleField;
    private JTextField yearField;
    private int closeOption;

    public static final int OK_OPTION = 1;
    public static final int CANCEL_OPTION = 0;

    public MovieDialog(JFrame parent) {
        super(parent, "Add Movie", true);
        setLayout(new GridLayout(3, 2));

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);
        JLabel yearLabel = new JLabel("Year:");
        yearField = new JTextField(20);

        Container contentPane = getContentPane();
        contentPane.add(titleLabel);
        contentPane.add(titleField);
        contentPane.add(yearLabel);
        contentPane.add(yearField);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("CANCEL");
        contentPane.add(okButton);
        contentPane.add(cancelButton);

        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        pack();
        setLocationRelativeTo(parent);
    }

    public int getCloseOption() {
        return closeOption;
    }

    public String getTitleField() {
        return titleField.getText();
    }

    public String getYearField() {
        return yearField.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OK")) {
            closeOption = OK_OPTION;
        } else {
            closeOption = CANCEL_OPTION;
        }
        dispose();
    }
}
