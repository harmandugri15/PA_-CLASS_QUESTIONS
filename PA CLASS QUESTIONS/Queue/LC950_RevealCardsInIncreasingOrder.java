// LeetCode 950: Reveal Cards In Increasing Order
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC950_RevealCardsInIncreasingOrder {

    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indexQueue.add(i);
        }

        int[] result = new int[n];
        for (int card : deck) {
            // Place the next smallest card at the front index
            result[indexQueue.poll()] = card;
            // Move the next index to the bottom of the queue
            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        System.out.println("Ordered deck: " + Arrays.toString(deckRevealedIncreasing(deck)));
    }
}
