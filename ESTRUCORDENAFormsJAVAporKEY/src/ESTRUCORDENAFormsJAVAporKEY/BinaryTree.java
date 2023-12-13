package ESTRUCORDENAFormsJAVAporKEY;
import java.util.*;
class BinaryTree {
    private Node root;

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public void insertar(int data, String priority) {
        root = insert(root, data, priority);
    }

    private Node insert(Node root, int data, String priority) {
        if (root == null) {
            root = new Node(data);
            // Additional logic for handling priority if needed
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data, priority);
        } else if (data > root.data) {
            root.right = insert(root.right, data, priority);
        }

        return root;
    }

    public boolean buscar(int data) {
        return search(root, data);
    }

    private boolean search(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }
}

