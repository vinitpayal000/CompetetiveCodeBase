class Node{
    public int data;
    public Node left;
    public Node right;
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

class BinaryTree{
    public Node rootNode;

    public BinaryTree(Node rootNode) {
        this.rootNode = rootNode;
    }

    public BinaryTree() {
    }

    public void printInOrder(Node rootNode){
        if(rootNode == null) return;

        printInOrder(rootNode.left);
        System.out.print(rootNode.data+" ");
        printInOrder(rootNode.right);

    }
}

class WrapInt{
    int value;
}

class ActualWorker{
    public Node rootNode;

    public ActualWorker(Node rootNode) {
        this.rootNode = rootNode;
    }

    public int treeDiameter(Node rootNode, WrapInt maxDia){
        if(rootNode == null) return 0;

        int ld = treeDiameter(rootNode.left, maxDia);
        int rd = treeDiameter(rootNode.right, maxDia);

        if(ld + rd + 1 > maxDia.value){
            maxDia.value = ld + rd +1;
        }

        return 1 + Math.max(ld,rd);
    }

}


public class DiameterOfTree{
    public static void main(String[] args) {
        Node rootNode = new Node(-15);

        rootNode.left = new Node(5);
        rootNode.right = new Node(6);

        rootNode.left.left = new Node(-8);
        rootNode.left.right = new Node(1);

        rootNode.left.left.left = new Node(2);
        rootNode.left.left.right = new Node(-3);

        rootNode.right.left = new Node(3);
        rootNode.right.right = new Node(9);

        rootNode.right.right.right = new Node(0);
        rootNode.right.right.right.left= new Node(4);
        rootNode.right.right.right.right= new Node(-1);

        rootNode.right.right.right.right.left = new Node(1);
        rootNode.right.right.right.right.right = new Node(10);

        Node rootNode1 = new Node(-100);
        rootNode1.left = new Node(2);
        rootNode1.left.left = new Node(5);
        rootNode1.left.right = new Node(7);
        rootNode1.right = new Node(3);


        BinaryTree bt = new BinaryTree(rootNode);

        WrapInt theInt = new WrapInt();
        theInt.value = -2147483648;

        new ActualWorker(rootNode).treeDiameter(bt.rootNode,theInt);

        System.out.println("Final Answer :"+theInt.value);
    }
}