/**
 * Created by Sanjeev on 5/11/2016.
 */
public class Node {
    Node left ;
    Node right ;
    int data;

    public Node(){}

    public Node(int n){
        this.data = n;
    }

    public void displayNode(){
        System.out.print(this.data+ " ");
    }
}
