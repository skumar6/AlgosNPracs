import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sanjeev on 10/25/2016.
 */
public class NaryNodeHandler {
    public static void main(String[] args) {
        NaryTree nt = new NaryTree();
        nt.addChildren(1,2,"a");
        nt.addChildren(1,3,"b");
        nt.addChildren(1,4,"c");
        nt.addChildren(2,5,"d");
        nt.addChildren(2,6,"e");
        nt.addChildren(3,7,"f");
        nt.addChildren(3,8,"g");
        nt.addChildren(6,9,"h");
        nt.addChildren(6,10,"i");
        nt.addChildren(7,11,"j");
        nt.addChildren(7,12,"k");

       List<List<Integer>> lst;
       lst =  nt.dfs();
        for(int i =0; i<lst.size();i++){
            if(lst.get(i).contains(6) || lst.get(i).contains(7)){
                System.out.println(lst.get(i));
            }
        }
        System.out.println(nt.lca(lst,11,12));








    }
}
