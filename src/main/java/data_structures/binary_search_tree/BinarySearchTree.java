
package data_structures.binary_search_tree;

public class BinarySearchTree {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields 
    //~ ----------------------------------------------------------------------------------------------------------------

    Node root;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors 
    //~ ----------------------------------------------------------------------------------------------------------------

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node3 = new Node(5);
        Node node2 = new Node(4);
        Node node4 = new Node(2);
        Node node6 = new Node(6);
        Node node5 = new Node(1);

        BinarySearchTree binarySearchTree = new BinarySearchTree(node1);
        System.out.println("Inserted node with value: " + binarySearchTree.insertNode(node2).value);
        System.out.println("Inserted node with value: " + binarySearchTree.insertNode(node3).value);
        System.out.println("Inserted node with value: " + binarySearchTree.insertNode(node4).value);
        System.out.println("Inserted node with value: " + binarySearchTree.insertNode(node5).value);
        System.out.println("Inserted node with value: " + binarySearchTree.insertNode(node6).value);
        System.out.println("Tree root value is: " + binarySearchTree.root.value);
//        System.out.println(binarySearchTree.search(1).value);

        System.out.println("In order traversal");
        binarySearchTree.inOrderTraversalPrint();
        System.out.println("Pre order traversal");
        binarySearchTree.preOrderTraversalPrint();
        System.out.println("Post order traversal");
        binarySearchTree.postOrderTraversalPrint();

        System.out.println("Biggest value in bst: " + binarySearchTree.findBiggestValue().value);

    }

    public void deleteNode(int value) {
        deleteNode(value, root);
    }

    public Node deleteNode(int value, Node node) {
        if (node == null) {
            return null;
        } else if (node.value == value) {
            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            } else {
                node.rightChild = lift(node.rightChild, node);
                return node;
            }
        } else if (value > node.value) {
            node.rightChild = deleteNode(value, node.rightChild);
            return node;
        } else {
            node.leftChild = deleteNode(value, node.leftChild);
            return node;
        }
    }

    public Node lift(Node node, Node nodeToDelete) {
        if (node.leftChild != null) {
            node.leftChild = lift(node.leftChild, nodeToDelete);
            return node;
        } else {
            nodeToDelete.value = node.value;
            return node.rightChild;
        }
    }

    public void printTree() {
        printTree(root);
    }

    public Node insertNode(Node node) {
        if (root == null) {
            root = node;
            return node;
        }
        return insertNode(node, root);
    }

    public Node search(int value) {
        return search(value, root);
    }

    public void inOrderTraversalPrint() {
        inOrderTraversalPrint(this.root);
    }

    public void preOrderTraversalPrint() {
        preOrderTraversalPrint(this.root);
    }

    public void postOrderTraversalPrint() {
        postOrderTraversalPrint(this.root);
    }

    public void inOrderTraversalPrint(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversalPrint(node.leftChild);
        System.out.println(node.value);
        inOrderTraversalPrint(node.rightChild);
    }

    public void preOrderTraversalPrint(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrderTraversalPrint(node.leftChild);
        preOrderTraversalPrint(node.rightChild);
    }

    public void postOrderTraversalPrint(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversalPrint(node.leftChild);
        postOrderTraversalPrint(node.rightChild);
        System.out.println(node.value);
    }

    public Node findBiggestValue() {
        return findBiggestValue(root);
    }

    public Node findBiggestValue(Node node) {
        if(node.rightChild == null) {
            return node;
        }

        return findBiggestValue(node.rightChild);
    }

    private void printTree(Node node) {
        if (node == null) {
            System.out.println("--------");
            return;
        }
        System.out.println();
        System.out.println(node.value);
        if (node.leftChild != null) {
            System.out.print("/");
            printTree(node.leftChild);
        }
        if (node.rightChild != null) {
            System.out.print("\\");
            printTree(node.rightChild);
        }
    }

    private Node insertNode(Node node, Node treeNode) {
        if (node.value > treeNode.value) {
            if (treeNode.rightChild != null) {
                insertNode(node, treeNode.rightChild);
            } else {
                treeNode.rightChild = node;
            }
        }
        if (node.value < treeNode.value) {
            if (treeNode.leftChild != null) {
                insertNode(node, treeNode.leftChild);
            } else {
                treeNode.leftChild = node;
            }
        }

        return node;
    }

    private Node search(int value, Node node) {
        if (node == null) {
            throw new RuntimeException("Node was not found!");
        }
        if (node.value == value) {
            return node;
        }
        if (value > node.value) {
            return search(value, node.rightChild);
        }

        return search(value, node.leftChild);
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Nested Classes 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}
