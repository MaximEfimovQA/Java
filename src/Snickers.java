public class Snickers extends Sweet {

    private final int count;  // Уникальное финальное поле класса, для каждого разное

    // Конструктор класса
    public Snickers(String name, double weight, double price, int count) {
        // Вызов конструктора родительского класса Sweet с общими параметрами
        super(name, weight, price);
        // Инициализация уникального параметра для Bounty
        this.count = count;
    }

    // Переопределение абстрактного метода getUniqueParameter() из класса Sweet
    @Override
    public String getUniqueParameter() {
        // Возвращает строку с описанием уникального параметра
        return "Арахис: " + count + " шт.";
    }

    // Геттер для получения значения уникального параметра
    public int getCount() {
        // Возвращает значение поля
        return count;
    }
}