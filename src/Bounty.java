public class Bounty extends Sweet{

    private final String coconut; // Уникальное финальное поле класса, для каждого разное

    // Конструктор класса
    public Bounty(String name, double weight, double price, String coconut) {
        // Вызов конструктора родительского класса Sweet с общими параметрами
        super(name, weight, price);
        // Инициализация уникального параметра для Bounty
        this.coconut = coconut;
    }

    // Переопределение абстрактного метода getUniqueParameter() из класса Sweet
    @Override
    public String getUniqueParameter(){
        // Возвращает строку с описанием уникального параметра
        return "Содержание кокоса внутри батончика " + coconut +".";
    }

    // Геттер для получения значения уникального параметра
    public String getCoconut(){
        // Возвращает значение поля
        return coconut;
    }
}
