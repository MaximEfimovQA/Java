import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Класс, реализующий интерфейс SweetBox (коробка для сладостей)
public class SweetBoxArray implements SweetBox {
    // Хранилище сладостей - список, защищенный от модификации извне (private final)
    private final List<Sweet> sweets = new ArrayList<>();

    // Метод добавления сладости в коробку
    @Override
    public void addSweet(Sweet sweet) {
        sweets.add(sweet); // Просто добавляем объект сладости в список
    }

    // Метод удаления последней добавленной сладости
    @Override
    public void removeLastSweet() {
        if (!sweets.isEmpty()) { // Проверяем, не пуста ли коробка
            sweets.remove(sweets.size() - 1); // Удаляем последний элемент
        }
    }

    // Метод удаления сладости по индексу
    @Override
    public void removeSweetByIndex(int index) {
        // Проверяем, что индекс в допустимых пределах
        if (index >= 0 && index < sweets.size()) {
            sweets.remove(index); // Удаляем элемент по указанному индексу(- это число которое начинается с 0)
        }
    }

    // Метод расчета общего веса коробки
    @Override
    public double getTotalWeight() {
        // Преобразуем список в поток, преобразуем каждую сладость в ее вес, суммируем
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }

    // Метод расчета общей стоимости коробки
    @Override
    public double getTotalPrice() {
        // Аналогично весу, но работаем с ценами
        return sweets.stream().mapToDouble(Sweet::getPrice).sum();
    }

    // Метод вывода информации о всех сладостях в коробке
    @Override
    public void printAllSweets() {
        if (sweets.isEmpty()) { // Проверка на пустую коробку
            System.out.println("Коробка пуста");
            return;
        }

        System.out.println("Содержимое коробки:");
        // Для каждой сладости вызываем метод println (используем ссылку на метод)
        sweets.forEach(System.out::println);

        // Выводим общий вес с форматированием до 2 знаков после запятой
        System.out.printf("Общий вес: %.2f г\n", getTotalWeight());
        // Выводим общую стоимость с форматированием
        System.out.printf("Общая стоимость: %.2f руб\n\n", getTotalPrice());
    }

    // Метод оптимизации коробки по весу
    @Override
    public void optimizeByWeight(double maxWeight) {
        // Пока текущий вес превышает максимальный и коробка не пуста
        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            // Находим самую легкую сладость:
            Sweet lightest = sweets.stream()
                    // Сортируем по весу (по возрастанию)
                    .min(Comparator.comparingDouble(Sweet::getWeight))
                    // Если список пуст, выбросит исключение
                    .orElseThrow();
            // Удаляем найденную сладость
            sweets.remove(lightest);
        }
    }

    // Метод оптимизации коробки по цене
    @Override
    public void optimizeByPrice(double maxWeight) {
        // Аналогично оптимизации по весу, но:
        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            // Ищем самую дешевую сладость
            Sweet cheapest = sweets.stream()
                    .min(Comparator.comparingDouble(Sweet::getPrice))
                    .orElseThrow();
            sweets.remove(cheapest);
        }
    }
}