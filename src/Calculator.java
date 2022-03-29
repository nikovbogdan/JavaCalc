import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    private static JTextField inputField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[11];
    JButton addButton, subButton, multiplyButton, divideButton;
    JButton decimalButton, equalsButton, deleteButton, clearButton, negativeButton,squaredButton, percentButton;
    JPanel panel;

    Font font = new Font("Arial", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator() {

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);


        inputField = new JTextField();
        inputField.setBounds(50, 25, 300, 50);
        inputField.setFont(font);
        inputField.setEnabled(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("Del");
        clearButton = new JButton("C");
        negativeButton = new JButton("(-)");
        squaredButton = new JButton("(x²)");
        percentButton = new JButton("(%)");
        //√

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;
        functionButtons[9] = squaredButton;
        functionButtons[10] = percentButton;

        for (JButton functionButton : functionButtons) {
            functionButton.setFont(font);
            functionButton.addActionListener(this);
            functionButton.setFocusable(false);
        }
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        negativeButton.setBounds(50, 80, 100, 35);
        deleteButton.setBounds(150, 80, 100, 35);
        clearButton.setBounds(250, 80, 100, 35);
        squaredButton.setBounds(250, 120, 100, 35);
        percentButton.setBounds(150, 120, 100, 35);

        panel = new JPanel();
        panel.setBounds(50, 160, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.GRAY); //make clear where the panel is located

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(divideButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(addButton);

        frame.add(panel);
        frame.add(negativeButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(squaredButton);
        frame.add(percentButton);
        frame.add(inputField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
       new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                inputField.setText(inputField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton) {
            inputField.setText(inputField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '+';
            inputField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '-';
            inputField.setText("");
        }
        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '*';
            inputField.setText("");
        }
        if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '/';
            inputField.setText("");
        }
        if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(inputField.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            inputField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clearButton) {
            inputField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
        if (e.getSource() == negativeButton) {
          double token = Double.parseDouble(inputField.getText());
          token*=-1;
          inputField.setText(String.valueOf(token));

        }
        if (e.getSource() == deleteButton) {
            String string = inputField.getText();
            inputField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                inputField.setText(inputField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == squaredButton) {
            num1 = Double.parseDouble(inputField.getText());
            inputField.setText(String.valueOf(num1*num1));
        }
    }
}
