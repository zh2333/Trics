import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 1222, 234, 345, 456, 567, 567, 678, 789, 7890, 32,21, 54, 65, 87, 98, 1110, 119, 118, 228,117, 116, 115, 114, 113, 122};
        MultiProc proc = new MultiProc("MyArray", 5);
        proc.init();

        int size = arr.length;
        System.out.println(size);
        int pageSize = 5;
        //for (int i = 0; i < size / pageSize; i ++) {
        //    int[] tmp = Arrays.copyOfRange(arr, i * pageSize, i * pageSize + pageSize);
            proc.addtask("printArray", arr);
        //}
        proc.release();
    }
}
