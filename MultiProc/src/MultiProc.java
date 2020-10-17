import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;

public class MultiProc {
    private String  className;
    private int wokerNum = 10;
    Class<?> clazz;
    Object instance;
    CountDownLatch count;
    private ExecutorService executorService;

    public MultiProc(String className, int wokerNum) {
        this.className = className;
        this.wokerNum = wokerNum;
    }

    /**
     * 实例化类
     */
    public void init() {
        try {
            this.clazz = Class.forName(this.className);//使用反射创建类对象
            this.instance = clazz.getConstructor().newInstance();
            this.executorService = Executors.newFixedThreadPool(this.wokerNum);//创建线程池
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param methodName 方法名
     * @param args 不固定类型, 不固定数量的参数
     * @throws Exception
     */
    public void addtask(String methodName, Object... args )  {
        //System.out.println(methodName);

        try {
            Class<?> clazz = this.clazz;
            Object instance = this.instance;

            Future<Object> future = executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws InvocationTargetException, IllegalAccessException {
                    for (Method classMethod: clazz.getMethods()) {
                        if (classMethod.getName().equals(methodName)) {
                            classMethod.invoke(instance,args);//执行该类中的方法
                        }
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭线程池
     */
    public void release() {
        this.executorService.shutdown();
    }


}
