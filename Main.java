import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinarySearchTree<Integer>();
        Random rand = new Random(1);
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 11;
        long tick, tock;

        System.out.println("insert");
        tick = System.nanoTime();
        for (int i = 0; i < num; ++i) {
            int n = rand.nextInt(num);
            tree.insert(n);
            System.out.print(n + ": ");
            for (Integer j : tree) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        tock = System.nanoTime();
        System.out.println(tock - tick);

        System.out.println("search");
        tick = System.nanoTime();
        for (int i = 0; i < num / 2; ++i) {
            int n = rand.nextInt(num);
            System.out.println(n + ": " + tree.search(n));
        }
        tock = System.nanoTime();
        System.out.println(tock - tick);

        rand = new Random(1);
        System.out.println("remove");
        tick = System.nanoTime();
        for (int i = 0; i < num; ++i) {
            int n = rand.nextInt(num);
            tree.remove(n);
            System.out.print(n + ": ");
            for (Integer j : tree) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        tock = System.nanoTime();
        System.out.println(tock - tick);
        System.out.println("tree " + (tree.isEmpty() ? "is" : "is not") + " empty");
    }
}
