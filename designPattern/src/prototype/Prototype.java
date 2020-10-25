package prototype;

/**
 * 原型模式
 */
public class Prototype {

        public static void main(String[]args) throws CloneNotSupportedException{
            BaseInfo baseInfo = new BaseInfo("2020年");
            Product product = new Product("卫龙", 2, 200, "白色", "湖南", baseInfo);
            Product clone = product.clone();
            System.out.println(product);
            System.out.println(clone);
            product.getBaseInfo().setDate("2019年");
            System.out.println(product);
            System.out.println(clone);
        }


}

class BaseInfo implements Cloneable{
    private String date;

    public BaseInfo(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "date='" + date + '\'' +
                '}';
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return (BaseInfo) super.clone();
    }
}


class Product implements Cloneable{//实现创建一个对象的副本--浅拷贝
    private String name;
    private int price;
    private int amount;
    private String color;
    private String address;
    private BaseInfo baseInfo;


    public Product(String name, int price, int amount, String color, String address, BaseInfo baseInfo) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.address = address;
        this.baseInfo = baseInfo;
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

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return this.hashCode() + "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                '}' + baseInfo.hashCode() + "  " +baseInfo.toString();
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {//深拷贝--对象是另一个对象的成员, 其成员对象也要实现cloneable 接口
        Product clone = (Product)super.clone();
        BaseInfo baseInfo = this.baseInfo.clone();
        clone.setBaseInfo(baseInfo);
        return clone;
    }
}
