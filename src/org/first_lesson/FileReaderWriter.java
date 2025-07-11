// Объявление пакета, к которому принадлежит класс
package org.first_lesson;

// Импорт необходимых классов для работы с вводом-выводом
import java.io.*;

// Главный класс программы
public class FileReaderWriter {

    // Главный метод программы - точка входа
    public static void main(String[] args) {
        // Путь к исходному файлу для чтения
        String inputFile = "introduce java.txt";
        // Путь к файлу для записи результата
        String outputFile = "dz1JavaResult.txt";

        // Счетчики для подсчета гласных и согласных букв
        int vowelCount = 0;       // Счетчик гласных букв
        int consonantCount = 0;   // Счетчик согласных букв

        // Блок try-with-resources для автоматического закрытия потоков
        try (
                // Создаем поток для чтения из файла
                FileReader reader = new FileReader(inputFile);
                // Создаем поток для записи в файл
                FileWriter writer = new FileWriter(outputFile)
        ) {
            // Переменная для хранения кода прочитанного символа
            int charCode;

            //  Это цикл while, который читает файл посимвольно до тех пор, пока не достигнет конца файла.(-1)
            while ((charCode = reader.read()) != -1) {
                // Преобразуем код символа в символ
                char originalChar = (char) charCode;
                // Преобразуем символ по заданным правилам
                char transformedChar = transformChar(originalChar);
                // Записываем преобразованный символ в выходной файл
                writer.write(transformedChar);

                // Подсчитываем количество гласных и согласных букв в исходном файле
                if (isVowel(originalChar)) {
                    vowelCount++;  // Увеличиваем счетчик гласных
                } else if (isConsonant(originalChar)) {
                    consonantCount++;  // Увеличиваем счетчик согласных
                }
            }

            // Выводим сообщение об успешном завершении
            System.out.println("Успешно! Результат в файле: " + outputFile);
            // Выводим статистику по буквам
            System.out.println("Статистика букв в исходном файле:");
            System.out.println("Гласных букв: " + vowelCount);
            System.out.println("Согласных букв: " + consonantCount);

        } catch (IOException ex) {
            // Обработка возможных ошибок ввода-вывода
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }

    // Метод для преобразования символов по заданным правилам
    private static char transformChar(char ch) {
        // Если символ - гласная, заменяем на 'a'
        if (isVowel(ch)) {
            return 'a';
        }
        // Если символ - согласная, заменяем на 'м'
        else if (isConsonant(ch)) {
            return 'м';
        }
        // Все остальные символы оставляем без изменений
        else {
            return ch;
        }
    }

    // Вспомогательный метод для проверки, является ли символ гласной буквой
    private static boolean isVowel(char ch) {
        // Все гласные буквы (русские и английские в обоих регистрах)
        String vowels = "аеёиоуыэюяaeiouAEIOUАЕЁИОУЫЭЮЯ";
        // Проверяем, содержится ли символ в строке гласных
        return vowels.indexOf(ch) != -1;
    }

    // Вспомогательный метод для проверки, является ли символ согласной буквой
    private static boolean isConsonant(char ch) {
        // Все согласные буквы (русские и английские в обоих регистрах)
        String consonants = "бвгджзйклмнпрстфхцчшщbcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";
        // Проверяем, содержится ли символ в строке согласных
        return consonants.indexOf(ch) != -1;
    }
}