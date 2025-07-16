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
        System.out.println("\n=== Оптимизация по весу ===");
        System.out.println("Текущий вес: " + getTotalWeight() + " г");

        // Проверяем, не превышает ли текущий вес максимально допустимый
        if (getTotalWeight() <= maxWeight) {
            System.out.println("Оптимизация не требуется"); // Сообщаем, что оптимизация не нужна
            return; // Завершаем выполнение метода
        }

        int removed = 0; // Счетчик удаленных сладостей

        // Цикл выполняется, пока вес превышает допустимый и в коробке есть сладости
        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            // Находим самую легкую сладость в коробке
            Sweet lightest = sweets.stream()
                    .min(Comparator.comparingDouble(Sweet::getWeight))
                    .orElseThrow(); // Если список пуст, выбрасываем исключение

            // Выводим информацию об удаляемой сладости
            System.out.println("Удаляем: " + lightest.getName() +
                    " (вес: " + lightest.getWeight() + " г)");
            sweets.remove(lightest); // Удаляем сладость из коробки
            removed++; // Увеличиваем счетчик удаленных сладостей
        }

        // Выводим результаты оптимизации
        System.out.println("Удалено сладостей: " + removed);
        System.out.println("Новый вес: " + getTotalWeight() + " г");
    }

    // Метод оптимизации коробки по цене
    @Override
    public void optimizeByPrice(double maxPrice) {
        System.out.println("\n=== Оптимизация по цене ===");
        System.out.println("Текущая стоимость коробки: " + getTotalPrice() + " руб");
        System.out.println("Максимально допустимая стоимость: " + maxPrice + " руб");
        System.out.println("Количество сладостей: " + sweets.size());

        // Проверяем, не превышает ли текущая стоимость максимально допустимую
        if (getTotalPrice() <= maxPrice) {
            System.out.println("Оптимизация не требуется - цена уже в пределах нормы!");
            return; // Завершаем выполнение метода
        }

        int removedCount = 0; // Счетчик удаленных сладостей
        double initialPrice = getTotalPrice(); // Запоминаем начальную стоимость

        // Цикл выполняется, пока стоимость превышает допустимую и в коробке есть сладости
        while (getTotalPrice() > maxPrice && !sweets.isEmpty()) {
            // Находим самую дешевую сладость в коробке
            Sweet cheapest = sweets.stream()
                    .min(Comparator.comparingDouble(Sweet::getPrice))
                    .orElseThrow(); // Если список пуст, выбрасываем исключение

            // Выводим информацию об удаляемой сладости
            System.out.println("Удаляем сладость: " + cheapest.getName() +
                    " (цена: " + cheapest.getPrice() + " руб, вес: " + cheapest.getWeight() + " г)");

            sweets.remove(cheapest); // Удаляем сладость из коробки
            removedCount++; // Увеличиваем счетчик удаленных сладостей
        }
    }
}