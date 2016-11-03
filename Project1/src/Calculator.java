import service.CalculatorService;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taban on 11/1/16.
 *
 */


public class Calculator {
    private JPanel panel1;
    private JTextField CalculationArea;
    private JButton EqualsButton;
    private JLabel displayAnswer;
    private JButton Clear;
    private CalculatorService cs;

    public Calculator() {

        CalculationArea.setPreferredSize(new Dimension(40, 50));
        Clear.setPreferredSize(new Dimension(40, 50));
        EqualsButton.setPreferredSize(new Dimension(40, 50));
        EqualsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = CalculationArea.getText();
                String data = CalculatorService.operation(input);
                displayAnswer.setText(data);

            }
        });
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculationArea.setText("");
                displayAnswer.setText("");
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");

        frame.setSize(500, 250);
        frame.setContentPane(new Calculator().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
