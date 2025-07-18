import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Реализация интерфейса SweetBox для работы с коробкой сладостей
public class SweetBoxArray implements SweetBox {

    // Хранилище для сладостей на основе ArrayList
    // final означает, что ссылка на список не может быть изменена после инициализации
    private final List<Sweet> sweets = new ArrayList<>();

    // Метод добавления сладости в коробку
    @Override
    public void addSweet(Sweet sweet) {
        // Просто добавляем переданный объект сладости в конец списка
        sweets.add(sweet);
    }

    // Метод удаления последней добавленной сладости
    @Override
    public void removeLastSweet() {
        // Проверяем, не пуста ли коробка
        if (!sweets.isEmpty()) {
            // Удаляем последний элемент списка (индекс size()-1)
            sweets.remove(sweets.size() - 1);
        }
    }

    // Метод удаления сладости по индексу, по весу или по цене
    @Override
    public void removeSweetByIndex(int index) {
        // Проверяем, что индекс находится в допустимых пределах (от 0 до size()-1)
        if (index >= 0 && index < sweets.size()) {
            // Удаляем элемент по указанному индексу
            sweets.remove(index);
        }
        // Если индекс невалидный, ничего не делаем (можно было бы выбросить исключение)
    }

    // Метод расчета общего веса коробки
    @Override
    public double getTotalWeight() {
        // Преобразуем список в поток (stream)
        // mapToDouble преобразует каждый элемент в его вес (double)
        // sum() суммирует все значения веса
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }

    // Метод расчета общей стоимости коробки
    @Override
    public double getTotalPrice() {
        // Аналогично getTotalWeight, но работаем с ценами сладостей
        return sweets.stream().mapToDouble(Sweet::getPrice).sum();
    }

    // Метод вывода информации о всех сладостях в коробке
    @Override
    public void printAllSweets() {
        // Проверяем, пуста ли коробка
        if (sweets.isEmpty()) {
            System.out.println("Коробка пуста");
            return; // Завершаем выполнение метода
        }

        System.out.println("Содержимое коробки:");
        // Для каждого элемента списка вызываем System.out.println
        // (используем method reference)
        sweets.forEach(System.out::println);

        // Выводим общий вес с точностью до 2 знаков после запятой
        System.out.printf("Общий вес: %.2f г\n", getTotalWeight());
        // Выводим общую стоимость с точностью до 2 знаков после запятой
        System.out.printf("Общая стоимость: %.2f руб\n\n", getTotalPrice());
    }

    // Метод оптимизации коробки по весу (удаляем самые легкие сладости)
    @Override
    public void optimizeByWeight(double maxWeight) {
        System.out.println("\n=== Оптимизация по весу, удаляем самый легкий по весу. ===");
        System.out.println("Текущий вес коробки: " + getTotalWeight() + " г");
        System.out.println("Максимально допустимый вес: " + maxWeight + " г");
        System.out.println("Текущее количество сладостей: " + sweets.size());

        // Проверяем, не превышает ли текущий вес максимально допустимый
        if (getTotalWeight() <= maxWeight) {
            System.out.println("Оптимизация не требуется - вес уже в пределах нормы!");
            return;
        }

        int removedCount = 0; // Счетчик удаленных сладостей
        double initialWeight = getTotalWeight(); // Запоминаем начальный вес
        double initialPrice = getTotalPrice(); // Запоминаем начальную цену

        // Пока вес превышает допустимый и в коробке есть сладости
        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            // Находим самую легкую сладость:
            // 1. Преобразуем список в stream
            // 2. Ищем минимум по весу (Comparator.comparingDouble)
            // 3. orElseThrow() - если список пуст, выбросит исключение
            Sweet lightest = sweets.stream()
                    .min(Comparator.comparingDouble(Sweet::getWeight))
                    .orElseThrow();

            // Выводим информацию об удаляемой сладости
            System.out.println("Удаляем: " + lightest.getName() +
                    " (вес: " + lightest.getWeight() + " г, цена: " +
                    lightest.getPrice() + " руб) " + lightest.getUniqueParameter());

            // Удаляем сладость из коробки
            sweets.remove(lightest);
            removedCount++; // Увеличиваем счетчик
        }

        // Выводим итоговую информацию об оптимизации
        System.out.println("\nРезультаты оптимизации:");
        System.out.println("Удалено сладостей: " + removedCount);
        System.out.println("Изначальный вес: " + initialWeight + " г");
        System.out.println("Новый вес: " + getTotalWeight() + " г");
        System.out.println("Изначальная стоимость: " + initialPrice + " руб");
        System.out.println("Новая стоимость: " + getTotalPrice() + " руб");
    }

    // Метод оптимизации коробки по цене (удаляем самые дешевые сладости)
    @Override
    public void optimizeByPrice(double maxWeight) {
        System.out.println("\n=== Оптимизация по весу, но удаляем по самой дешевой цене. ===");
        System.out.println("Текущий вес коробки: " + getTotalWeight() + " г");
        System.out.println("Максимально допустимый вес: " + maxWeight + " г");
        System.out.println("Текущее количество сладостей: " + sweets.size());

        // Проверяем, нужно ли оптимизировать
        if (getTotalWeight() <= maxWeight) {
            System.out.println("Оптимизация не требуется - вес уже в пределах нормы!");
            return;
        }

        int removedCount = 0;
        double initialWeight = getTotalWeight();
        double initialPrice = getTotalPrice();

        // Удаляем самые дешевые сладости, пока вес превышает допустимый
        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            // Находим самую дешевую сладость (аналогично поиску самой легкой)
            Sweet cheapest = sweets.stream()
                    .min(Comparator.comparingDouble(Sweet::getPrice))
                    .orElseThrow();

            System.out.println("Удаляем: " + cheapest.getName() +
                    " (цена: " + cheapest.getPrice() + " руб, вес: " +
                    cheapest.getWeight() + " г) | " + cheapest.getUniqueParameter());

            sweets.remove(cheapest);
            removedCount++;
        }

        // Выводим итоговую информацию
        System.out.println("\nРезультаты оптимизации:");
        System.out.println("Удалено сладостей: " + removedCount);
        System.out.println("Изначальный вес: " + initialWeight + " г");
        System.out.println("Новый вес: " + getTotalWeight() + " г");
        System.out.println("Изначальная стоимость: " + initialPrice + " руб");
        System.out.println("Новая стоимость: " + getTotalPrice() + " руб");
    }
}
//КОРОТКО О ТОМ КАК ЭТО РАБОТАЕТ
// Как работает:
//
//Хранит сладости в массиве (Sweet[])
//
//При добавлении автоматически расширяет массив при необходимости
//
//Реализует методы оптимизации:
//
//optimizeByWeight() - удаляет самые тяжелые сладости, пока вес не станет <= заданного
//
//optimizeByPrice() - аналогично, но по цене
//
//Важные методы:
//
//removeSweet() - приватный метод для удаления по индексу
//
//getTotalWeight(), getTotalPrice() - подсчет общих веса и стоимости