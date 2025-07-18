public class Cookie extends Sweet{

    private final String black; // Уникальное финальное поле класса, для каждого разное

    // Конструктор класса
    public Cookie(String name, double weight, double price, String black) {
        // Вызов конструктора родительского класса Sweet с общими параметрами
        super(name, weight, price);
        // Инициализация уникального параметра для Bounty
        this.black = black;
    }
    // Переопределение абстрактного метода getUniqueParameter() из класса Sweet
    @Override
    public String getUniqueParameter(){
        // Возвращает строку с описанием уникального параметра
        return "Круглое печенье и еще оно " + black;
    }

    // Геттер для получения значения уникального параметра
    public String getBlack(){
        // Возвращает значение поля
        return black;
    }
}
