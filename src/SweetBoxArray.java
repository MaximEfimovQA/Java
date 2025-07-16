import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Реализация интерфейса SweetBox (коробка для сладостей)
public class SweetBoxArray implements SweetBox {

    // Хранилище для сладостей (используем ArrayList для хранения)
    private final List<Sweet> sweets = new ArrayList<>();

    // Добавление новой сладости в коробку
    @Override
    public void addSweet(Sweet sweet) {
        sweets.add(sweet); // Просто добавляем объект в список
    }

    // Удаление последней добавленной сладости
    @Override
    public void removeLastSweet() {
        if (!sweets.isEmpty()) { // Проверяем, есть ли что удалять
            sweets.remove(sweets.size() - 1); // Удаляем последний элемент
        }
    }

    // Удаление сладости по указанному индексу
    @Override
    public void removeSweetByIndex(int index) {
        // Проверяем, что индекс в допустимых пределах
        if (index >= 0 && index < sweets.size()) {
            sweets.remove(index); // Удаляем элемент по индексу
        }
    }

    // Расчет общего веса коробки
    @Override
    public double getTotalWeight() {
        // Преобразуем список в поток, получаем вес каждой сладости, суммируем
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }

    // Расчет общей стоимости коробки
    @Override
    public double getTotalPrice() {
        // Аналогично весу, но работаем с ценами
        return sweets.stream().mapToDouble(Sweet::getPrice).sum();
    }

    // Вывод информации о всех сладостях в коробке
    @Override
    public void printAllSweets() {
        if (sweets.isEmpty()) { // Если коробка пуста
            System.out.println("Коробка пуста");
            return; // Завершаем метод
        }

        System.out.println("Содержимое коробки:");
        // Выводим каждую сладость через метод toString()
        sweets.forEach(System.out::println);

        // Форматированный вывод общего веса (2 знака после запятой)
        System.out.printf("Общий вес: %.2f г\n", getTotalWeight());
        // Форматированный вывод общей стоимости
        System.out.printf("Общая стоимость: %.2f руб\n\n", getTotalPrice());
    }

    // Оптимизация коробки по весу (удаляем самые легкие, пока вес > maxWeight)
    @Override
    public void optimizeByWeight(double maxWeight) {
        System.out.println("\n=== Оптимизация по весу ===");
        System.out.println("Текущий вес: " + getTotalWeight() + " г");

        // Если вес уже не превышает лимит
        if (getTotalWeight() <= maxWeight) {
            System.out.println("Оптимизация не требуется");
            return; // Завершаем метод
        }

        int removed = 0; // Счетчик удаленных сладостей

        // Пока вес превышает лимит и есть что удалять
        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            // Находим самую легкую сладость
            Sweet lightest = sweets.stream()
                    .min(Comparator.comparingDouble(Sweet::getWeight))
                    .orElseThrow(); // Если список пуст, выбросит исключение

            System.out.println("Удаляем: " + lightest.getName() +
                    " (вес: " + lightest.getWeight() + " г)");
            sweets.remove(lightest); // Удаляем сладость
            removed++; // Увеличиваем счетчик
        }

        System.out.println("Удалено сладостей: " + removed);
        System.out.println("Новый вес: " + getTotalWeight() + " г");
    }

    // Оптимизация коробки по цене (удаляем самые дешевые, пока вес > maxWeight)
    @Override
    public void optimizeByPrice(double maxWeight) {
        System.out.println("\n=== Оптимизация по цене ===");
        System.out.println("Текущая стоимость коробки: " + getTotalPrice() + " руб");
        System.out.println("Количество сладостей: " + sweets.size());

        // Проверка необходимости оптимизации
        if (getTotalWeight() <= maxWeight) {
            System.out.println("Оптимизация не требуется - вес уже в пределах нормы!");
            return;
        }

        int removedCount = 0; // Счетчик удаленных
        double initialPrice = getTotalPrice(); // Запоминаем начальную цену

        // Удаляем, пока вес превышает лимит
        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            // Находим самую дешевую сладость
            Sweet cheapest = sweets.stream()
                    .min(Comparator.comparingDouble(Sweet::getPrice))
                    .orElseThrow();

            System.out.println("Удаляем сладость: " + cheapest.getName() +
                    " (цена: " + cheapest.getPrice() + " руб)");

            sweets.remove(cheapest); // Удаляем
            removedCount++; // Считаем
        }

        // Выводим итоги оптимизации
        System.out.println("\n=== Результат оптимизации ===");
        System.out.println("Удалено сладостей: " + removedCount);
        System.out.println("Новая стоимость: " + getTotalPrice() + " руб");
    }
}