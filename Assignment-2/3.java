import java.util.*;

public class BinaryTreePaths {

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public List<String> binaryTreePaths(Node root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            findPaths(root,"",paths);
        }
        return paths;
    }

    private void findPaths(Node node, String currentPath, List<String> paths) {
        currentPath += node.data;

        if (node.left == null && node.right == null) {
            paths.add(currentPath);
            return;
        }

        if (node.left != null) {
            findPaths(node.left, currentPath + "->", paths);
        }
        if (node.right != null) {
            findPaths(node.right, currentPath + "->", paths);
        }
    }

    // method to build tree from Level-Order input
    public static Node buildTree() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root value (-1 for null):");
        int val = sc.nextInt();
        
        if (val == -1) return null;

        Node root = new Node(val);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.println("Enter left child of " + current.data + " (or -1 for null):");
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                current.left = new Node(leftVal);
                queue.add(current.left);
            }

            System.out.println("Enter right child of " + current.data + " (or -1 for null):");
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                current.right = new Node(rightVal);
                queue.add(current.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreePaths solver = new BinaryTreePaths();
        
        System.out.println("Binary Tree Path Finder");
        Node root = buildTree();

        if (root == null) {
            System.out.println("The tree is empty.");
        } else {
            List<String> result = solver.binaryTreePaths(root);
            System.out.println("\nAll Root-to-Leaf Paths:");
            for (String path : result) {
                System.out.println(path);
            }
        }
    }
}