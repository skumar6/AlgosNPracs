import java.util.*;

/**
 * Created by Sanjeev on 10/25/2016.
 */
public class Company {
    int nEmployee;
    //LinkedList[] adj;
    HashMap<Integer, LinkedList> adj = new HashMap<Integer, LinkedList>();
    HashMap<Integer,Boolean > visited = new HashMap<Integer, Boolean>();

    public Company(int v){
        nEmployee=v;
        for(int i =1; i<=nEmployee; i++){
            adj.put(i, new LinkedList());
        }
    }

    public void addEmp(int id1, int id2){
        (adj.get(id1)).add(id2);
        visited.put(id2, false);
    }

    public void getPaths(int source){
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(source);
        boolean flag = false;


        s.push(source);
        visited.put(source, true);
        System.out.println(source);

        while(!s.empty()){
            int ele = s.peek();
            Iterator i =  (adj.get(ele)).listIterator();
            if(i.hasNext()){
                int n = (int)i.next();
                if(!visited.get(n)){
                    s.push(n);
                    visited.put(n,true);
                    i.remove();
                    lst.add(n);
                    flag = true;
                }
            }else{
                if(flag)
                    for (int m = 0; m < lst.size(); m++) {
                        System.out.print(lst.get(m) + " ");
                    }
                flag = false;

                lst.remove(lst.size()-1);
                s.pop();
            }
            System.out.println();
        }
    }

}
