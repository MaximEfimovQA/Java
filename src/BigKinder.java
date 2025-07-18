public class BigKinder extends Sweet {

    private final String big; // Уникальное финальное поле класса, для каждого разное

    // Конструктор класса
    public BigKinder(String name, double weight, double price, String big) {
        // Вызов конструктора родительского класса Sweet с общими параметрами
        super(name, weight, price);
        // Инициализация уникального параметра для Bounty
        this.big = big;
    }

    // Переопределение абстрактного метода getUniqueParameter() из класса Sweet
    @Override
    public String getUniqueParameter() {
        // Возвращает строку с описанием уникального параметра
        return  "Огромный киндер и поэтому в нем " + big;
    }

    // Геттер для получения значения уникального параметра
    public String getBig(){
        // Возвращает значение поля
        return big;
    }
}
