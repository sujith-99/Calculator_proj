package Calculator_proj;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    // Declare components
    TextField num1, num2, result;
    Button addButton, subtractButton, multiplyButton, divideButton;

    public Calculator() {
        // Set the layout for the frame
        setLayout(new FlowLayout());

        // Initialize components
        Label label1 = new Label("Number 1:");
        Label label2 = new Label("Number 2:");
        Label label3 = new Label("Result:");

        num1 = new TextField(10);
        num2 = new TextField(10);
        result = new TextField(15);
        result.setEditable(false); // Make the result field read-only

        addButton = new Button("Add");
        subtractButton = new Button("Subtract");
        multiplyButton = new Button("Multiply");
        divideButton = new Button("Divide");

        // Add components to the frame
        add(label1);
        add(num1);
        add(label2);
        add(num2);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(label3);
        add(result);

        // Add action listeners
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        // Configure the frame
        setTitle("AWT Simple Calculator");
        setSize(300, 200);
        setVisible(true);

        // Close the window when the user clicks the close button
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Parse input numbers
            double number1 = Double.parseDouble(num1.getText());
            double number2 = Double.parseDouble(num2.getText());
            double resultValue = 0;

            // Perform the appropriate operation based on the button clicked
            if (e.getSource() == addButton) {
                resultValue = number1 + number2;
            } else if (e.getSource() == subtractButton) {
                resultValue = number1 - number2;
            } else if (e.getSource() == multiplyButton) {
                resultValue = number1 * number2;
            } else if (e.getSource() == divideButton) {
                if (number2 == 0) {
                    result.setText("Error: Divide by 0");
                    return;
                }
                resultValue = number1 / number2;
            }

            // Display the result
            result.setText(String.valueOf(resultValue));
        } catch (NumberFormatException ex) {
            result.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        // Create an instance of the Calculator class
        new Calculator();
    }
}
