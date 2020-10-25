package builder;


/**
 * 建造者模式
 */
public class Builder {
    public static void main(String[] args) {
        ProductBuilder builder = new ConcerateProductBuilder();
        Director director = new Director(builder);
        Product product = director.makeProduct("卫龙", 2, 200, "白色", "湖南");
        System.out.println(product);
    }
}

interface ProductBuilder {
    void buildName(String name);
    void buildPrice(int price);
    void buildAmount(int amount);
    void buildColor(String color);
    void buildAddress(String address);
    Product productBuilder();

}


/**
 * 如何建造
 */
class Director {
    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String name, int price, int amount, String color, String address) {
        builder.buildAddress(address);
        builder.buildAmount(amount);
        builder.buildColor(color);
        builder.buildPrice(price);
        builder.buildName(name);

        return builder.productBuilder();
    }

}

class ConcerateProductBuilder implements ProductBuilder {
    private String name;
    private int price;
    private int amount;
    private String color;
    private String address;


    @Override
    public void buildName(String name) {
        this.name = name;
    }

    @Override
    public void buildPrice(int price) {
        this.price = price;
    }

    @Override
    public void buildAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void buildColor(String color) {
        this.color = color;
    }

    @Override
    public void buildAddress(String address) {
        this.address = address;
    }

    @Override
    public Product productBuilder() {
        return new Product(this.name, this.price, this.amount, this.color, this.address);
    }
}

/**
 * 这个产品有很多的属性, 对这个类对象的属性初始化很麻烦
 */
class Product {
    private String name;
    private int price;
    private int amount;
    private String color;
    private String address;
    //.....


    public Product(String name, int price, int amount, String color, String address) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
