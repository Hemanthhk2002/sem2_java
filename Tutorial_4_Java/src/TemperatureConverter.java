import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton convertButton;
    private JButton clearButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public TemperatureConverter() {

        getContentPane().add(panel1);
        setSize(400, 400);
        setTitle("Temperature Converter");
        setVisible(true);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputTemperature = Double.parseDouble(textField1.getText());

                    double fahrenheit = inputTemperature;
                    double celsius = fahrenheitToCelsius(fahrenheit);
                    double kelvin = celsiusToKelvin(celsius);

                    textField2.setText(String.format("%.2f", celsius));
                    textField3.setText(String.format("%.2f", fahrenheit));
                    textField4.setText(String.format("%.2f", kelvin));
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
            }
        });
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static void main(String[] args) {
        new TemperatureConverter();
    }
}
