public class MyHashImpl implements MyHash{

    @Override
    public int hashOne(String key) {
        int  hash = 0;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            hash = 33 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    @Override
    public int hashTwo(String key) {
        final int tmp = 16777619;
        int hash = (int) 2166136261L;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            hash = (hash ^ key.charAt(i)) * tmp;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    @Override
    public int hashThree(String key) {
        int hash = 0;
        int len = key.length();

        for (int i = 0; i < len; i++) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);

        return Math.abs(hash);

    }
}
