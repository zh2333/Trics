package adapter.adapter2;


import java.lang.annotation.Target;

public class Adapter2 {

}

class  Adaptee {
    public int output220v() {
        return 220;
    }
}

interface Traget {
    int output5v();
}

/**
 * 类适配器模式-- 使用了继承, 不符合迪米特原则(知道最少原则)
 */
class Adapter extends Adaptee implements Traget {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public int output5v() {
        int i = output220v();
        System.out.println(String.format("原始电压: %d  -->  输出电压: %d", i, 5));
        return 5;
    }
}
