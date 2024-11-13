// Red-Black Tree in Java

class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        int data;
        Node left, right, parent;
        boolean color;

        Node(int data) {
            this.data = data;
            this.color = RED;
        }
    }

    private Node root;

    // Left rotate
    private void leftRotate(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;

        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }

        rightChild.parent = node.parent;

        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }

        rightChild.left = node;
        node.parent = rightChild;
    }

    // Right rotate
    private void rightRotate(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;

        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        leftChild.parent = node.parent;

        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.left) {
            node.parent.left = leftChild;
        } else {
            node.parent.right = leftChild;
        }

        leftChild.right = node;
        node.parent = leftChild;
    }

    // Fix violations after insertion
    private void fixInsert(Node node) {
        while (node != root && node.parent.color == RED) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;

                if (uncle != null && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rightRotate(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;

                if (uncle != null && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    leftRotate(node.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    // Insert a node into the tree
    public void insert(int data) {
        Node newNode = new Node(data);
        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;
            if (newNode.data < current.data) {
                current = current.left;
            } else if (newNode.data > current.data) {
                current = current.right;
            } else {
                return;  // Duplicate values are not allowed in this tree
            }
        }

        newNode.parent = parent;

        if (parent == null) {
            root = newNode;
        } else if (newNode.data < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        fixInsert(newNode);
    }

    // Pre-order traversal
    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    // Display the tree in a visual format
    void display() {
        System.out.println("Binary Search Tree Structure:");
        displayRec(root, 0);
    }

    void displayRec(Node root, int level) {
        if (root == null)
            return;

        // Display right subtree
        displayRec(root.right, level + 1);

        // Indent based on level
        for (int i = 0; i < level; i++)
            System.out.print("    ");
        
        // Print current node
        System.out.println(root.data);

        // Display left subtree
        displayRec(root.left, level + 1);
    }

    // Utility function to print the tree
    public void printTree() {
        preOrderTraversal(root);
        System.out.println();
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        int[] elements = {30, 55, 20, 25, 35, 15, 10, 5};

        for (int element : elements) {
            rbt.insert(element);
            // display the contents of the tree after every insert
            // Hint: helps with debugging 
            rbt.display();  
            System.out.println("#############################");
        }

        System.out.print("Pre-order Traversal of Red-Black Tree: ");
        // rbt.printTree(); // Pre-order traversal of the tree 
        rbt.display();// display 
    }
}