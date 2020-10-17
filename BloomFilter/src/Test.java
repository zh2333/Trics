import java.util.HashMap;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        String[] standStrs = {"我", "爱祖国", "任命", "大地", "达人", "爱情", "无聊"};
        MyFilter filter = new MyFilter(1000);

        for (String str:standStrs) {
            filter.add(str);
        }

        String[] testStrs = {"我", "大家", "喜庆", "祖国", "爱", "聊天","达到"};
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for (String str:testStrs) {
            map.put(str, filter.mightContains(str));
        }

        for (String key:map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
