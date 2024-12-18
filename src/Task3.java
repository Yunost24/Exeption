import javax.swing.*;

public class Task3 {
    public static void task3() {
        // Создаем окно
        JFrame frame = new JFrame("Hello swing");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Текстовая область
        JTextArea textArea = new JTextArea();

        // Меню
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenu editMenu = new JMenu("Правка");
        JMenu helpMenu = new JMenu("Справка");

        // Пункты меню
        JMenuItem openItem = new JMenuItem("Открыть");
        JMenuItem saveItem = new JMenuItem("Сохранить");
        JMenuItem copyItem = new JMenuItem("Копировать");
        JMenuItem pasteItem = new JMenuItem("Вставить");
        JMenuItem aboutItem = new JMenuItem("О программе");

        // Добавляем пункты в соответствующие меню
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        helpMenu.add(aboutItem);

        // Добавляем меню в строку меню
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Добавляем обработчики событий
        openItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Открыть: функционал пока не реализован"));
        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Сохранить: функционал пока не реализован"));
        copyItem.addActionListener(e -> textArea.copy());
        pasteItem.addActionListener(e -> textArea.paste());
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Это пример программы с меню"));

        // Создаем панель для кнопок
        JPanel buttonPanel = new JPanel();

        // Создаем кнопки
        JButton clearButton = new JButton("Очистить");
        JButton exitButton = new JButton("Выход");

        // Добавляем обработчики событий для кнопок
        clearButton.addActionListener(e -> textArea.setText(""));

        exitButton.addActionListener(e -> {
            frame.dispose();  // Закрываем окно
            System.exit(0);  // Завершаем программу
        });

        // Добавляем кнопки на панель
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        // Настраиваем окно
        frame.setJMenuBar(menuBar);
        frame.add(new JScrollPane(textArea), "Center");
        frame.add(buttonPanel, "South");  // Добавляем панель с кнопками в нижнюю часть окна
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Запуск приложения
        task3();
    }
}
