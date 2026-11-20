// in this approach we will keep a hashmap of frequencies of each element in the sliding length of the queue and as the i gets bigger than 
// the window size t will reduce the nums[leftmost] element frequency and also remove it from queue and see if q.peek() 's frequency is !=1
// if it is !=1 than it is  removed as it is not single element in the window and -1 is returned 
import java.util.*;

class Q6_SlidingWindowMaximumWithDeque {

    static void findFirstNonRepeating(int[] nums, int n, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int current = nums[i];

            hmap.put(current, hmap.getOrDefault(current, 0) + 1); //added frequency as the element get parsed
            q.offer(current); // added the element in the queue as they come

            if (i >= k) { // if i gets bugger than window
                int left = nums[i - k];  //leftmost element from the array which's frequency is to be reduced 
                hmap.put(left, hmap.get(left) - 1);
            }
            

            if (i >= k - 1) { // check if q's size is full to its window and than start removing the elemenyts
                while (!q.isEmpty() && hmap.get(q.peek()) !=1) {
                    q.poll();  // if the leftmost element of queue has frequency of more than 1 than remove it 
                }
                if (q.isEmpty()) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(q.peek() + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        findFirstNonRepeating(nums, n, k);

        sc.close();
    }
}
