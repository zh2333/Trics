
public class MyArray {
    public void printArray(int[] arr) {
        System.out.print("[");
        for (int num:arr) {
            if (num == arr[arr.length - 1]) {
                System.out.print(num);
            } else {
                System.out.print(num + ",");
            }
        }
        System.out.println("]");
    }
}
