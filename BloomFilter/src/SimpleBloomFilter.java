public interface SimpleBloomFilter {

    /**
     * 向过滤器中添加需要甄别是否存在的字符串
     * @param key
     */
    void add(String key);

    /**
     * 判断输入字符串是否存在;如果为true只是可能存在, 如果是false则一定不存在
     * @param key
     * @return
     */
    boolean mightContains(String key);
}
