/**
 * Created by Sanjeev on 5/11/2016.
 */
public class TreeHandler {

   public static void main(String args[]){
       Tree t = new Tree();
       t.insert(4);
       t.insert(15);
       t.insert(3);
       t.insert(16);

//       t.inOrder(t.getRoot());
//       System.out.println("");
//
       t.preOrder(t.getRoot());
       System.out.println("");
//
//       t.postOrder(t.getRoot());
//       System.out.println("");

//       t.iterativeInOrder(t.getRoot());
//       System.out.println("");
//       t.iterativePostOeder(t.getRoot());
       t.iterativePreOrder(t.getRoot());
   }
}
