
import java.util.*;

class randomquestions {

    public static void mergesortedarray(int[] arr1, int[] arr2) {
        int[] a = new int[arr1.length + arr2.length];
        int index = 0;
        for (int i : arr1) {
            a[index++] = i;
        }
        for (int j : arr2) {
            a[index++] = j;
        }
        Arrays.sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }

    }

    public static void fun1(String a) {
        String[] arr = a.split("\\s+");
        StringBuilder sb = new StringBuilder(arr[0]);
        sb.reverse();
        System.out.print(sb.toString() + " ");
        System.out.print(arr[1]);
    }

    public static void fun2(int[] arr) {
        int maxones = 0;
        int currones = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                currones++;
            } else {
                currones = 0;
            }
            maxones = Math.max(maxones, currones);
        }
        System.out.println(maxones);
    }

    public static void fun3(int a) {
        int smallest = Integer.MAX_VALUE;
        while (a > 0) {
            int digit = a % 10;
            a = a / 10;
            smallest = Math.min(smallest, digit);
        }
        System.out.println(smallest);
    }

    public static boolean fun4(int a) {
        int x = a % 10;
        while (a > 0) {
            int digit = a % 10;
            if (digit != x) {
                return false;
            }
            a = a / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {6, 5, 7};
        mergesortedarray(arr1, arr2);
        System.out.println("");
        int[] arr = {0, 1, 0, 0, 1, 1, 1, 1, 0, 1};
        String a = "Hello world";
        fun1(a);
        System.out.println("");
        fun2(arr);

        System.out.println("");

        fun3(12345);
        System.out.print(fun4(11211));
    }
}
