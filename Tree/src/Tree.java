import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sanjeev on 5/11/2016.
 */
public class Tree {

    private Node root;

    public Node getRoot(){
        return root;
    }
    //inset a node into the tree
    public void insert(int n ){
        Node newNode = new  Node(n);

        if(root == null){
            root = newNode;
        }else {
            Node current = root;
            Node previous;
            while (true) {
                previous = current;
                if (current.data > n) {
                    current = current.left;
                    if (current == null) {
                        previous.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        previous.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    //tree traversal techniques

    //inorder- visit left, print, visit right, prints tree in a sorted way.
    public void inOrder(Node root){
        Node current = root;
        if(current == null)
            return;
        inOrder(current.left);
        current.displayNode();
        inOrder(current.right);
        }

    public void preOrder(Node root){
        Node current = root;
        if(current == null)
            return;
        current.displayNode();
        preOrder(current.left);
        preOrder(current.right);

    }

    public void postOrder(Node root){
        Node current = root;
        if(current == null)
            return;
        preOrder(current.left);
        preOrder(current.right);
        current.displayNode();
    }
    //its kind of BFS, we will taverse the tree level by level
    //most famous technique is to use queue for it.
    public void levelOrder(Node root){
        Node current = new Node();
        Queue q = new LinkedList();
        q.add(current);
        while(!q.isEmpty() ){
            Node n = (Node)q.remove();
            n.displayNode();
            if(n.left != null)
                q.add(n.left);
            if(n.right != null)
                q.add(n.right);
        }

    }


    }



