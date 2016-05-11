/**
 * Created by Sanjeev on 5/11/2016.
 */
public class TreeHandler {

   public static void main(String args[]){
       Tree t = new Tree();
       t.insert(4);
       t.insert(15);
       t.insert(3);
       t.insert(12);

       t.inOrder(t.getRoot());
   }
}
