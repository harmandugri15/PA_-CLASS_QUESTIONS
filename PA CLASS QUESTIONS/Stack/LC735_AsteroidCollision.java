// LeetCode 735: Asteroid Collision
import java.util.Stack;
import java.util.Arrays;

public class LC735_AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean alive = true;
            while (alive && ast < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if (stack.peek() < -ast) {
                    stack.pop(); // Left asteroid is smaller and explodes
                } else if (stack.peek() == -ast) {
                    stack.pop(); // Both explode
                    alive = false;
                } else {
                    alive = false; // Current asteroid explodes
                }
            }
            if (alive) {
                stack.push(ast);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println("Surviving asteroids: " + Arrays.toString(asteroidCollision(asteroids)));
    }
}
