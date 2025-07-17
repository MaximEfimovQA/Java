import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Класс, реализующий интерфейс SweetBox для работы с коробкой сладостей
public class SweetBoxArray implements SweetBox {

    // Хранилище для сладостей на основе ArrayList
    private final List<Sweet> sweets = new ArrayList<>();

    // Метод добавления сладости в коробку
    @Override
    public void addSweet(Sweet sweet) {
        sweets.add(sweet); // Добавляем переданный объект сладости в список
    }

    // Метод удаления последней добавленной сладости
    @Override
    public void removeLastSweet() {
        if (!sweets.isEmpty()) { // Проверяем, не пуста ли коробка
            sweets.remove(sweets.size() - 1); // Удаляем последний элемент списка
        }
    }

    // Метод удаления сладости по индексу
    @Override
    public void removeSweetByIndex(int index) {
        // Проверяем, что индекс находится в допустимых пределах
        if (index >= 0 && index < sweets.size()) {
            sweets.remove(index); // Удаляем элемент по указанному индексу
        }
    }

    // Метод расчета общего веса коробки
    @Override
    public double getTotalWeight() {
        // Преобразуем список в поток, получаем вес каждой сладости и суммируем
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }

    // Метод расчета общей стоимости коробки
    @Override
    public double getTotalPrice() {
        // Аналогично расчету веса, но работаем с ценами сладостей
        return sweets.stream().mapToDouble(Sweet::getPrice).sum();
    }

    // Метод вывода информации о всех сладостях в коробке
    @Override
    public void printAllSweets() {
        if (sweets.isEmpty()) { // Проверяем, пуста ли коробка
            System.out.println("Коробка пуста"); // Сообщаем о пустой коробке
            return; // Завершаем выполнение метода
        }

        System.out.println("Содержимое коробки:");
        // Выводим информацию о каждой сладости через метод toString()
        sweets.forEach(System.out::println);

        // Выводим общий вес с точностью до 2 знаков после запятой
        System.out.printf("Общий вес: %.2f г\n", getTotalWeight());
        // Выводим общую стоимость с точностью до 2 знаков после запятой
        System.out.printf("Общая стоимость: %.2f руб\n\n", getTotalPrice());
    }

    // Метод оптимизации коробки по весу
    @Override
    public void optimizeByWeight(double maxWeight) {
        System.out.println("\n=== Оптимизация по весу, удаляем самый легкий по весу. ===");
        System.out.println("Текущий вес коробки: " + getTotalWeight() + " г");
        System.out.println("Максимально допустимый вес: " + maxWeight + " г");
        System.out.println("Текущее количество сладостей: " + sweets.size());

        if (getTotalWeight() <= maxWeight) {
            System.out.println("Оптимизация не требуется - вес уже в пределах нормы!");
            return;
        }

        int removedCount = 0;
        double initialWeight = getTotalWeight();
        double initialPrice = getTotalPrice();

        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            Sweet lightest = sweets.stream()
                    .min(Comparator.comparingDouble(Sweet::getWeight))
                    .orElseThrow();

            System.out.println("Удаляем: " + lightest.getName() +
                    " (вес: " + lightest.getWeight() + " г, цена: " +
                    lightest.getPrice() + " руб) " + lightest.getUniqueParameter() );

            sweets.remove(lightest);
            removedCount++;
        }

        System.out.println("\nРезультаты оптимизации:");
        System.out.println("Удалено сладостей: " + removedCount);
        System.out.println("Изначальный вес: " + initialWeight + " г");
        System.out.println("Новый вес: " + getTotalWeight() + " г");
        System.out.println("Изначальная стоимость: " + initialPrice + " руб");
        System.out.println("Новая стоимость: " + getTotalPrice() + " руб");
    }

    @Override
    public void optimizeByPrice(double maxWeight) {
        System.out.println("\n=== Оптимизация по весу, но удаляем по самой дешевой цене. ===");
        System.out.println("Текущий вес коробки: " + getTotalWeight() + " г");
        System.out.println("Максимально допустимый вес: " + maxWeight + " г");
        System.out.println("Текущее количество сладостей: " + sweets.size());

        if (getTotalWeight() <= maxWeight) {
            System.out.println("Оптимизация не требуется - вес уже в пределах нормы!");
            return;
        }

        int removedCount = 0;
        double initialWeight = getTotalWeight();
        double initialPrice = getTotalPrice();

        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            Sweet cheapest = sweets.stream()
                    .min(Comparator.comparingDouble(Sweet::getPrice))
                    .orElseThrow();

            System.out.println("Удаляем: " + cheapest.getName() +
                    " (цена: " + cheapest.getPrice() + " руб, вес: " +
                    cheapest.getWeight() + " г) " + cheapest.getUniqueParameter() );

            sweets.remove(cheapest);
            removedCount++;
        }

        System.out.println("\nРезультаты оптимизации:");
        System.out.println("Удалено сладостей: " + removedCount);
        System.out.println("Изначальный вес: " + initialWeight + " г");
        System.out.println("Новый вес: " + getTotalWeight() + " г");
        System.out.println("Изначальная стоимость: " + initialPrice + " руб");
        System.out.println("Новая стоимость: " + getTotalPrice() + " руб");
    }
}