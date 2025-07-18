import java.util.ArrayList;
import java.util.List;

// Абстрактный базовый класс для всех сладостей
public abstract class Sweet {
    private final String name;    // Название сладости
    private final double weight;    // Вес сладости
    private final double price;  // Цена сладости

    public Sweet(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
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

    public abstract String getUniqueParameter();

    @Override
    public String toString() {
        return String.format("%s (%.2f г, %.2f руб) | %s",
                name, weight, price, getUniqueParameter());
    }
}
// //КОРОТКО О ТОМ КАК ЭТО РАБОТАЕТ
// Что делает:
//
//Это базовый класс, от которого наследуются все конкретные сладости
//
//Содержит общие для всех сладостей поля:
//
//name - название
//
//weight - вес в граммах
//
//price - цена в рублях
//
//Имеет абстрактный метод getUniqueParameter() - каждый класс-наследник должен реализовать его по-своему
//
//Ключевые методы:
//
//toString() - возвращает строковое представление сладости
//
//Геттеры для всех полей