import javax.swing.*;

public class Task2 {
    public static void main(String[] args) {
        // Создаем окно
        JFrame frame = new JFrame("Hello swing");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Массив стран для JComboBox
        String[] countries = {"Россия", "США", "Германия", "Франция"};
        JLabel label = new JLabel("Выберите страну:");
        JComboBox<String> comboBox = new JComboBox<>(countries);
        JLabel infoLabel = new JLabel("Столица: ");

        // Добавляем обработчик событий для JComboBox
        comboBox.addActionListener(e -> {
            String selected = (String) comboBox.getSelectedItem();
            if (selected != null) {
                switch (selected) {
                    case "Россия" -> infoLabel.setText("Столица: Москва");
                    case "США" -> infoLabel.setText("Столица: Вашингтон");
                    case "Германия" -> infoLabel.setText("Столица: Берлин");
                    case "Франция" -> infoLabel.setText("Столица: Париж");
                }
            }
        });

        // Создаем панель и добавляем компоненты
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(comboBox);
        panel.add(infoLabel);

        // Добавляем панель в окно
        frame.add(panel);

        // Устанавливаем видимость окна
        frame.setVisible(true);
    }
}
