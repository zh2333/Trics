package factorymethod;


/**
 * 工厂方法模式--找出稳定的部分并抽象成接口.让子类自己决定实现哪一个
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Application application = new Application();
        Product product = application.getObject("1");
        product.method1();

        Application1 application1 = new ConcreateProductA();
        Product product1 = application1.getObject();
        product1.method1();
    }
}

interface Product {
    void method1();
}


class ProductA implements Product{
    public void method1() {
        System.out.println("ProductA.method1  执行");
    }
}

class ProductB implements Product{
    public void method1() {
        System.out.println("ProductA.method1  执行");
    }
}

/**
 * 简单工厂-- 更像是一种编码风格而不是设计模式
 */
class SimpleFactory {
    public static Product createProduct(String type) {
        if (type.equals("0")) {
            return new ProductA();
        } else if (type.equals("1")) {
            return new ProductB();
        }
        return null;
    }
}

class Application {
    private Product createProduct(String type) {
        return SimpleFactory.createProduct(type);
    }

    Product getObject(String type) {
        Product product = createProduct(type);
        return product;
    }
}

/**
 * 工厂方法
 */
abstract class Application1 {
    abstract Product createProduct();

    Product getObject() {
        Product product = createProduct();
        return product;
    }
}

class ConcreateProductA extends Application1 {
    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ConcreateProductB extends Application1 {
    @Override
    Product createProduct() {
        return new ProductB();
    }
}




