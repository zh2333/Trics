package adapter.adapter1;

import java.lang.annotation.Target;

public class Adapter1 {
    public static void main(String[] args) {

    }
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
 * 对象识别器模式
 */
class Adapter implements Traget {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i = adaptee.output220v();

        System.out.println(String.format("原始电压: %d  -->  输出电压: %d", i, 5));
        return 5;
    }
}


