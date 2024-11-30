//Добавить 2 статических поля и к ним 4 вида инициализации

class Order {
    private int number;
    private Client client;

    public Order(int number, Client client) {
        this.number = number;
        this.client = client;
    }

    public int getNumber() {
        return number;
    }

    public Client getClient() {
        return client;
    }
}

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

class Delivery {
    private Product product;
    private Order order;
    private String courier;

    // Статические поля
    public static String defaultShippingMethod = "Standard"; // 1. Прямая инициализация
    public static int defaultDeliveryDays;

    static {
        defaultDeliveryDays = 3; // Инициализация в статическом блоке
    }

    public Delivery(Product product, Order order, String courier) {
        this.product = product;
        this.order = order;
        this.courier = courier;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    public String getCourier() {
        return courier;
    }


    public static void setDefaultDeliveryDays(int days) {
        defaultDeliveryDays = days;
    }
}

class Client {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Иван Иванов");
        Order order = new Order(123, client);
        Product product = new Product("iPhone 14", "Смартфоны", 999.99);
        Delivery delivery = new Delivery(product, order, "Петр Сидоров");

        // Изменение значения статического поля после создания объекта
        Delivery.setDefaultDeliveryDays(5);


        System.out.println("Заказ №" + delivery.getOrder().getNumber() +
                " клиента " + delivery.getOrder().getClient().getName() +
                " содержит товар: " + delivery.getProduct().getName() +
                " (" + delivery.getProduct().getCategory() + ")" +
                " Доставка осуществляется курьером: " + delivery.getCourier() +
                ". Способ доставки: " + Delivery.defaultShippingMethod +
                ", срок доставки: " + Delivery.defaultDeliveryDays + " дней.");
    }
}