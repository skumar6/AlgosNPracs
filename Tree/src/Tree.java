import java.util.*;

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
        postOrder(current.left);
        postOrder(current.right);
        current.displayNode();
    }

    //its kind of BFS, we will taverse the tree level by level
    //most famous technique is to use queue for it.
    public void levelOrder(Node root){
        if(root == null)
            return;
        Node current = new Node();
        current = root;
        Queue q = new LinkedList();
        q.add(current);
        System.out.println(current.data);
        while(!q.isEmpty() ){
            current  = (Node)q.remove();
            if(current.left != null)
                q.add(current.left);
            if(current.right != null)
                q.add(current.right);
        }
    }
    /* keep traversing and adding left children until its null, starting from
       the root itself. if not null add, it current is null, pop n print, set current to current.right
    * */
    public void iterativeInOrder(Node root) {
        Node current = root;
        Stack s = new Stack<Node>();
        if (root == null) {
            return;
        }

        while (true) {
            if (current != null) {
                s.push(current);
                current = current.left;
            } else {
                if (s.empty()) {
                    break;
                }
                current = (Node) s.pop();
                current.displayNode();
                current = current.right;
            }
        }
    }
    //we ll need two stacks for this process
    public void iterativePostOeder(Node root){
        Node current = root;
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        s1.push(current);
        while(!s1.empty()){
            current = (Node) s1.pop();
            s2.push(current);
            if(current.left != null){
                s1.push(current.left);
            }
            if(current.right != null) {
                s1.push(current.right);
            }
        }
        while(!s2.empty()){
            current = (Node) s2.pop();
            current.displayNode();
        }
    }

    public void iterativePreOrder(Node root){
        Node current = root;
        Stack s = new Stack();
        s.push(current);

        while(!s.empty()){
            current = (Node) s.pop();
            current.displayNode();
            if(current.right != null)
                s.push(current.right);
            if(current.left != null)
                s.push(current.left);
        }
    }

    //finding height of a tree
    public int height(Node root){
        if(root == null){
            return 0;
        }
        return 1+ Math.max(height(root.left), height(root.right));
    }

    /* if both elements given are greater than root, recursively move to right
    * else if they both are smaller then recursively move to left
    * else return root cz either either it is equal to one of them or
    * it is in between them and that makes the LCA(Lowest common ancestor)
    */
    public Node lca (Node root, int n1, int n2){

      if(root.data > Math.max(n1, n2)){
          return lca(root.left,n1,n2);
      } else if(root.data <  Math.min(n1, n2)){
          return lca(root.right,n1,n2);
      } else {
          return root;
      }

    }

    //we ll develop a program for vertical order traversal recursively
    //adding to a tree map is special, traversal goes same like inorder
    TreeMap<Integer, List<Node>> tm = new TreeMap<>();
    public void verticalOrder(Node root,TreeMap<Integer, List<Node>> tm, int level){
        int min=0, max=0;
        if(root != null) {
            addNode(root, tm, level);
            verticalOrder(root.left,tm ,level - 1);
            verticalOrder(root.right, tm, level + 1);
        }
        for(Integer i: tm.keySet()){
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        for(int i = min; i<=max; i++){
            if(tm.containsKey(i)){
                printlist(tm.get(i));

            }
            System.out.println("");
        }
    }

    //helper method for vertical ptaversal
    private void printlist(List<Node> nodes) {
        for(Node n : nodes){
            System.out.print(n.data+" ");
        }

    }
    //helper method for vdrtical taversal
    public void addNode(Node root, TreeMap<Integer, List<Node>> tm, int level){
        if(tm.containsKey(level)){
            tm.get(level).add(root);
        }else{
            LinkedList<Node> newList = new LinkedList<Node>();
            newList.add(root);
            tm.put(level, newList);
        }
    }

    //spiral level order traversal
    //changinf direction of spiral just change order of insertion in stack and queue implemented
    public void spiralOrder(Node root) {
        Stack s = new Stack();
        Queue<Node> q = new LinkedList<Node>();
        s.add(root);
        Node current;
        while (!s.isEmpty() || !q.isEmpty()) {

            while (!s.isEmpty()) {
                current = (Node) s.pop();
                current.displayNode();
                if (current.right != null)
                    q.add(current.right);
                if (current.left != null)
                    q.add(current.left);
            }
            System.out.println("");

            while (!q.isEmpty()) {
                current = q.remove();
                current.displayNode();
                if (current.right != null)
                    s.push(current.right);
                if (current.left != null)
                    s.push(current.left);

            }
            System.out.println("");
        }
    }


    }






