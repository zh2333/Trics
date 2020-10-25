package singleton;

/**
 * 单例模式--饿汉加载(基于java的类加载机制, 在类加载阶段对实例进行初始化)如果内存中没有这个类就会加载这个类, 如果有了就不会加载了
 */
public class HungrySingeton {
    private static volatile HungrySingeton instance = new HungrySingeton();
    private HungrySingeton() {

    }

    public static HungrySingeton getInstance1() {
        return instance;
    }
}
