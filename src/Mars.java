public class Mars extends Sweet{

    private final int sugar ;  // Уникальное финальное поле класса, для каждого разное

    // Конструктор класса
    public Mars(String name, double weight, double price, int sugar) {
        // Вызов конструктора родительского класса Sweet с общими параметрами
        super(name , weight, price);
        // Инициализация уникального параметра для Bounty
        this.sugar = sugar;
    }

    // Переопределение абстрактного метода getUniqueParameter() из класса Sweet
    @Override
    public String getUniqueParameter() {
        // Возвращает строку с описанием уникального параметра
        return "Грамм сахара в батончике " + sugar;
    }

    // Геттер для получения значения уникального параметра
    public int getSugar() {
        // Возвращает значение поля
        return sugar;
    }
}

