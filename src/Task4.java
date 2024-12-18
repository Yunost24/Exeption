import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task4 extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] numberButtons;
    private JButton addButton, subButton, mulButton, divButton, equalButton, dotButton;

    private double num1, num2, result;
    private char operator;

    public Task4() {
        setTitle("Калькулятор");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Расположение кнопок
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton = new JButton("/"));

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton = new JButton("*"));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton = new JButton("-"));

        panel.add(numberButtons[0]);

        // Кнопка точки
        dotButton = new JButton(".");
        dotButton.addActionListener(this);

        equalButton = new JButton("=");

        panel.add(dotButton);
        panel.add(addButton = new JButton("+"));
        panel.add(equalButton);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalButton.addActionListener(this);
        dotButton.addActionListener(this);

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    display.setText(display.getText() + i);
                }
            }

            if (e.getSource() == dotButton) {
                // Проверка на наличие уже введенной точки
                if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
            } else if (e.getSource() == addButton) {
                num1 = Double.parseDouble(display.getText());
                operator = '+';
                display.setText("");
            } else if (e.getSource() == subButton) {
                num1 = Double.parseDouble(display.getText());
                operator = '-';
                display.setText("");
            } else if (e.getSource() == mulButton) {
                num1 = Double.parseDouble(display.getText());
                operator = '*';
                display.setText("");
            } else if (e.getSource() == divButton) {
                num1 = Double.parseDouble(display.getText());
                operator = '/';
                display.setText("");
            } else if (e.getSource() == equalButton) {
                num2 = Double.parseDouble(display.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new ArithmeticException("Деление на ноль!");
                        }
                        result = num1 / num2;
                        break;
                    default:
                        throw new IllegalStateException("Неизвестная операция!");
                }

                display.setText(String.valueOf(result));
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Некорректный ввод!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            display.setText("");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            display.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Произошла ошибка: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            display.setText("");
        }
    }

    public static void main(String[] args) {
        Task4 calculator = new Task4();
        calculator.setVisible(true);
    }
}
