


public class MyFilter implements SimpleBloomFilter{
    private int size;
    private boolean[] filter;

    /**
     * 构造指定大小的布隆过滤器.size越小, 越不精确;size的大小不能小于要检测的关键字的个数
     * size = -[(n * lnp) / (ln2)^2]
     * n:要检测的字符串的数量
     * p:想要达到的误判率
     * 哈希函数的个数 = ln2 * (m / n)
     * @param size
     */
    public MyFilter(int size) {
        this.size = size;
        this.filter = new boolean[size];
    }

    @Override
    public void add(String key) {
        int[] indexs = getIndex(key);

        for (int index:indexs) {
            this.filter[index] = true;
        }

    }

    @Override
    public boolean mightContains(String key) {
        MyHash hashs = new MyHashImpl();

        int[] indexs = getIndex(key);
        boolean[] filter = this.filter;
        for (int index:indexs) {
            if (!filter[index]) {
                return false;
            }
        }
        return true;
    }

    public int[] getIndex(String key) {
        MyHash hashs = new MyHashImpl();

        int[] indexs = new int[3];
        indexs[0] = hashs.hashOne(key) % this.size;
        indexs[1] = hashs.hashTwo(key) % this.size;
        indexs[2] = hashs.hashThree(key) % this.size;

        return indexs;
    }
}
