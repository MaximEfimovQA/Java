import java.io.*;
import java.util.*;

public class DZ2 {
    public static void main(String[] args) {
        // Создание Scanner в try-with-resources для автоматического закрытия
        try (Scanner scanner = new Scanner(System.in)) {
            // Бесконечный цикл для многократного запроса путей к файлам
            while (true) {
                // Вывод приглашения для ввода пути
                System.out.print("Введите путь к файлу (Остановка 'exit' или 'выход'): ");

                // Чтение введенного пользователем пути
                String path = scanner.nextLine();

                // Проверка на команду выхода (без учета регистра)
                if (path.equalsIgnoreCase("exit") || path.equalsIgnoreCase("выход")) {
                    // Выход из цикла при вводе exit/выход
                    break;
                }

                // Открытие файла для чтения (автоматическое закрытие)
                try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                    // Создание Map для хранения данных (ключ-значение), создаем словарь в котором будет храниться ключ и значение.
                    Map<String, String> data = new HashMap<>();

                    // Переменная для хранения текущей строки, сохраняет каждую строку при каждой итерации по порядку
                    String line;

                    // Построчное чтение файла до конца (null)
                    while ((line = reader.readLine()) != null) {
                        // Разбиение строки по знаку "=" (максимум на 2 части)
                        String[] parts = line.split("=", 2);

                        // Проверка, что строка содержит "="
                        if (parts.length == 2) {
                            // Добавление в Map: ключ - левая часть[0], значение - правая[1] (с удалением пробелов)
                            data.put(parts[0].trim(), parts[1].trim());
                        }
                    }

                    // Форматирование результата в JSON-подобную строку
                    String output = String.format(
                            """
                            {
                                "name": <%s>,
                                "surname": <%s>,
                                "age": <%s>
                            }""",
                            data.get("name"),     // Получение значения по ключу "name"
                            data.get("surname"), // Получение значения по ключу "surname"
                            data.get("age")      // Получение значения по ключу "age"
                    );

                    // Вывод того, что сверху
                    System.out.println(output);

                } catch (IOException e) {
                    // Ошибка чтения файла
                    System.out.println("Ошибка при чтении файла!");
                }
            }
        }
    }
}