public class Kinder extends Sweet{

    private final String surprise; // Уникальное финальное поле класса, для каждого разное

    // Конструктор класса
    public Kinder(String name, double weight, double price, String surprise) {
        // Вызов конструктора родительского класса Sweet с общими параметрами
        super(name, weight, price);
        // Инициализация уникального параметра для Bounty
        this.surprise = surprise;
    }

    // Переопределение абстрактного метода getUniqueParameter() из класса Sweet
    @Override
    public String getUniqueParameter() {
        // Возвращает строку с описанием уникального параметра
        return "Внутри игрушка из смешариков и это - " + surprise + " , но может быть и другая." ;
    }

    // Геттер для получения значения уникального параметра
    public String getSurprise(){
        // Возвращает значение поля
        return surprise;
    }

}
