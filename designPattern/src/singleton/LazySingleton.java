package singleton;

/**
 * 单例模式--懒汉加载
 */
public class LazySingleton {
    private static volatile LazySingleton instance;//防止实例在初始化的时候的指令重排(重排序后会先引用赋值再初始化, 导致进程拿到的是空的实例)
    private LazySingleton() {

    }

    /**
     * 多线程方式下回产生多个实例
     * @return
     */
    public static LazySingleton getInstance1() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 解决第一种情况--锁太重了, 无论有没有实例化都会加锁, 但是只有在未实例化的时候才需要加锁
     * @return
     */
    public static synchronized LazySingleton getInstance2() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 只有在实例未初始化的时候才需要加锁, 并且使用了double check
     * @return
     */
    public static LazySingleton getInstance3() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return  instance;
    }

}
