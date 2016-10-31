import java.util.*;

/**
 * Created by Sanjeev on 10/25/2016.
 */
 class NaryNode {
    int num;
    String name;
    HashSet<Integer> children ;

    public NaryNode(int i, String s){
        this.num = i;
        this.name = s;
        children =  new HashSet<Integer>();
    }
    public NaryNode(){

    }
}


public class NaryTree {


    NaryNode root;
    HashMap<Integer, NaryNode> nodeList = new HashMap<Integer, NaryNode>();


    public void addChildren(int i,int k,String s){
        if(root == null) {
            root = new NaryNode(i,"ceo");
            nodeList.put(i, root);
        }
        nodeList.get(i).children.add(k);
        nodeList.put(k, new NaryNode(k,s));
    }

    public List<List<Integer>> dfs(){
        List<List<Integer>> fnl = new ArrayList<List<Integer>>();
        List<Integer> lst = new ArrayList<Integer>();
        dfsUtil(root, lst, fnl);
        return fnl;
    }

    public  void dfsUtil(NaryNode root,List<Integer>lst, List<List<Integer>> fnl){
        System.out.println(root.num);
        if(root == null)
            return;
        Iterator i = root.children.iterator();
        if(!i.hasNext()){
            lst.add(root.num);
            fnl.add((lst));
            return;
        }
        lst.add(root.num);
        while(i.hasNext()){
            dfsUtil(nodeList.get(i.next()),new ArrayList<>(lst), fnl);
        }
    }

    public int lca(List<List<Integer>> lst, int a, int b){
        List<Integer> arra= new ArrayList<>();
        List<Integer> arrb= new ArrayList<>();
        boolean flaga = true;
        boolean flagb = true;
        for(int i =0; i<lst.size(); i++){
            if(lst.get(i).contains(a) && flaga){
                flaga = false;
                arra = lst.get(i);
            }
            if(lst.get(i).contains(b) && flagb){
                flagb = false;
                arrb = lst.get(i);
            }
        }
        int res= -1;
        for(int j =0; j<arra.size()&& j<arrb.size();  j++){
            if(arra.get(j) == arrb.get(j)){
                res = arra.get(j);
            }
        }
        System.out.println(nodeList.get(res).name);
        return res;
    }










}
