import java.util.Scanner;

public class Main {
    // Точка входа в программу
    public static void main(String[] args) {
        // Создаем коробку для сладостей (используем реализацию SweetBoxArray)
        SweetBox box = new SweetBoxArray();
        // Создаем сканер для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Начальное наполнение коробки сладостями:

        box.addSweet(new Snickers("Snickers", 60, 90, 16));

        box.addSweet(new Mars("Mars", 55, 100, 23));

        box.addSweet(new Bounty("Bounty", 100, 60, "75%"));

        box.addSweet(new Kinder("Kinder", 120, 170, "Копатыч"));

        // Основной цикл программы, работает пока пользователь не выберет выход
        while (true) {
            // Выводим текущее содержимое коробки
            System.out.println("\n=== Текущее содержимое коробки ===");
            box.printAllSweets();

            // Выводим меню действий
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Оптимизировать по весу(т.е сколько будет весить коробка со всеми сладостями).");
            System.out.println("2 - Оптимизировать по цене(Общая цена коробки).");
            System.out.println("3 - Добавить дополнительные сладости, вдруг будет мало.");
            System.out.println("0 - Выход.");
            System.out.print("Ваш выбор: ");

            // Читаем выбор пользователя
            int choice = scanner.nextInt();

            // Если выбран выход (0), завершаем программу
            if (choice == 0) {
                System.out.println("Программа завершена.");
                break; // Выход из цикла
            }

            // Обработка выбора пользователя
            switch (choice) {
                case 1: // Оптимизация по весу
                    System.out.print("Введите максимальный вес (г): ");
                    // Вызываем метод оптимизации, передаем введенный пользователем вес
                    box.optimizeByWeight(scanner.nextDouble());  //box это как ссылка на контейнер, который содержит все сладости SweetBox box = new SweetBoxArray();
                    System.out.println("Оптимизация по весу выполнена!");
                    break;

                case 2: // Оптимизация по весу
                    System.out.print("Введите максимальную весу (rub): ");
                    // Вызываем метод оптимизации, передаем введенный пользователем вес
                    box.optimizeByPrice(scanner.nextDouble());
                    System.out.println("Оптимизация по весу выполнена!");
                    break;

                case 3: // Добавление сладостей

                    box.addSweet(new Cookie("Орео", 80, 70, "черное"));

                    box.addSweet(new BigKinder("BigKinder", 220, 300, "большой Копатыч."));
                    System.out.println("Добавлены новые сладости!");
                    break;

                default: // Неизвестный выбор
                    System.out.println("Вы ввели что-то неправильно");
            }
        }
    }
}

//Главный класс Main
//Логика работы:
//
//Создает коробку (SweetBox box = new SweetBoxArray())
//
//Наполняет её сладостями (изначально 4 шт.)
//
//В цикле предлагает пользователю выбор:
//
//Оптимизировать по весу/цене
//
//Добавить дополнительные сладости (еще 2 шт.)
//
//Выйти из программы
//
//Особенности:
//
//Использует Scanner для ввода пользователя
//
//После каждого действия выводит текущее состояние коробки
//
//Как взаимодействуют классы:
//Main создает объекты сладостей и добавляет их в SweetBox
//
//SweetBoxArray управляет коллекцией сладостей
//
//Каждая сладость знает, как представить свой уникальный параметр через getUniqueParameter()