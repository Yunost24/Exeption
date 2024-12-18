import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LabExample extends JFrame {
    JTextField jta1 = new JTextField(10); // Текстовое поле для первого числа
    JTextField jta2 = new JTextField(10); // Текстовое поле для второго числа
    JButton button = new JButton("Выполнить"); // Кнопка для выполнения операции
    JComboBox<String> operations = new JComboBox<>(new String[]{"+", "-", "*", "/"}); // Выпадающий список операций
    Font fnt = new Font("Times New Roman", Font.BOLD, 20); // Шрифт для элементов

    // Конструктор класса LabExample
    LabExample() {
        super("Hello swing"); // Заголовок окна
        setLayout(new FlowLayout()); // Устанавливаем компоновку
        setSize(300, 200); // Устанавливаем размер окна

        // Добавляем надпись для первого числа
        add(new JLabel("1-е число"));
        add(jta1); // Добавляем текстовое поле для ввода первого числа

        // Добавляем надпись для второго числа
        add(new JLabel("2-е число"));
        add(jta2); // Добавляем текстовое поле для ввода второго числа

        // Добавляем выпадающий список для выбора операции
        add(new JLabel("Операция"));
        add(operations);

        // Добавляем кнопку
        add(button);

        // Добавляем обработчик событий для кнопки
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    // Получаем значения из текстовых полей и преобразуем их в числа
                    double x1 = Double.parseDouble(jta1.getText().trim());
                    double x2 = Double.parseDouble(jta2.getText().trim());

                    // Получаем выбранную операцию
                    String operation = (String) operations.getSelectedItem();
                    double result = 0;

                    // Выполняем соответствующую операцию
                    switch (operation) {
                        case "+":
                            result = x1 + x2;
                            break;
                        case "-":
                            result = x1 - x2;
                            break;
                        case "*":
                            result = x1 * x2;
                            break;
                        case "/":
                            if (x2 != 0) {
                                result = x1 / x2;
                            } else {
                                throw new ArithmeticException("Деление на ноль");
                            }
                            break;
                    }

                    // Показываем результат в всплывающем окне
                    JOptionPane.showMessageDialog(
                            null,
                            "Результат = " + result,
                            "Сообщение",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (NumberFormatException e) {
                    // Если произошла ошибка ввода, показываем окно с сообщением об ошибке
                    JOptionPane.showMessageDialog(
                            null,
                            "Ошибка в числах!",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE
                    );
                } catch (ArithmeticException e) {
                    // Если произошло деление на ноль, показываем соответствующее сообщение
                    JOptionPane.showMessageDialog(
                            null,
                            "Ошибка: " + e.getMessage(),
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }); // Конец добавления обработчика событий

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закрытие программы при закрытии окна
        setVisible(true); // Делаем окно видимым
    }

    public static void main(String[] args) {
        new LabExample(); // Создаем и запускаем объект класса LabExample
    } // Конец метода main
} // Конец класса LabExample
