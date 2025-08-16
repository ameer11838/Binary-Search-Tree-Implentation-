import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {

    public void insert(E data) {
        root = insert(root, data);
    }

    private Node<E> insert(Node<E> current, E data) {
        if (current == null)
            return new Node<>(data);

        int compare = data.compareTo(current.data);

        if (compare < 0)
            current.left = insert(current.left, data);

        else if (compare > 0)
            current.right = insert(current.right, data);

        return current;
    }

    public boolean search(E data) {
        return search(root, data);
    }

    private boolean search(Node<E> current, E data) {
        if (current == null)
            return false;

        int compare = data.compareTo(current.data);

        if (compare == 0)
            return true;

        if (compare < 0)
            return search(current.left, data);

        return search(current.right, data);
    }

    public void remove(E data) {
        root = remove(root, data);
    }

    private Node<E> remove(Node<E> current, E data) {
        if (current == null)
            return null;

        int compare = data.compareTo(current.data);

        if (compare < 0)
            current.left = remove(current.left, data);

        else if (compare > 0)
            current.right = remove(current.right, data);

        else {
            if (current.left == null)
                return current.right;

            if (current.right == null)
                return current.left;

            Node<E> smallest = current.right;

            while (smallest.left != null)
                smallest = smallest.left;

            current.data = smallest.data;

            current.right = remove(current.right, smallest.data);
        }

        return current;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Stack<Node<E>> stack = new Stack<>();

            Node<E> currentNode = root;

            {
                while (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                }
            }

            public boolean hasNext() {
                return !stack.isEmpty();
            }

            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                Node<E> node = stack.pop();

                E result = node.data;

                if (node.right != null) {
                    Node<E> temp = node.right;
                    while (temp != null) {
                        stack.push(temp);
                        temp = temp.left;
                    }
                }

                return result;
            }
        };
    }
}
