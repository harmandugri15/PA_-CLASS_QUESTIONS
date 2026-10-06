
class Javapractice {

    public static void checkpall(int a) {
        String a1 = String.valueOf(a);
        int[] arr = new int[a1.length()];
        int index = 0;
        while (a > 0) {
            int digit = a % 10;
            arr[index++] = digit;
            a = a / 10;
        }
        int k = 0;
        index = index - 1;
        while (k < index) {
            if (arr[k] != arr[index]) {
                System.out.println("not pall");
                return;
            }
            k++;
            index--;
        }
        System.out.println("PALLI");
    }

    public static void main(String[] args) {
        checkpall(1111111);
    }
}
