import java.util.ArrayList;
import java.util.List;

// Абстрактный базовый класс для всех сладостей
public abstract class Sweet {
    private final String name;    // Название сладости
    private final double weight;    // Вес сладости
    private final double price;  // Цена сладости
    private final String uniqueParameter;  // Уникальный параметр сладости

    public Sweet(String name, double weight, double price, String uniqueParameter) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.uniqueParameter = uniqueParameter;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String getUniqueParameter() {
        return uniqueParameter;
    }

    @Override
    public String toString() {
        return String.format("%s: вес %.2f г, цена %.2f руб, %s",
                name, weight, price, uniqueParameter);
    }
}
