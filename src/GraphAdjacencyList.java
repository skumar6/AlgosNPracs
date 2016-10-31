import java.util.*;

/**
 * Created by Sanjeev on 10/21/2016.
 */
public class GraphAdjacencyList {
    int V;
    LinkedList<Integer> adj[];

    GraphAdjacencyList(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        //System.out.print(s+ " ");

        while (!q.isEmpty()) {
            int n = q.poll();
            System.out.print(n + " ");
            Iterator i = adj[n].listIterator();
            while (i.hasNext()) {
                int ele = (int) i.next();
                if (!visited[ele]) {
                    visited[ele] = true;
                    q.add(ele);
                }

            }

        }

    }

    public void dfs(int s) {
        Stack<Integer> st = new Stack<Integer>();
        boolean[] visited1 = new boolean[V];
        boolean flag=false;
        st.push(s);
        visited1[s] = true;
       // System.out.println(s + ": initial push ");
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(s);


        while (!st.empty()) {

            int ele = st.peek();
            Iterator<Integer> i = adj[ele].listIterator();

            if(i.hasNext() ) {
                int n = i.next();
                if(!visited1[n]) {
                    st.push(n);
                    visited1[n] = true;
                    lst.add(n);
                    i.remove();
                    flag = true;
                }
            }else{
                if(flag && (lst.get(lst.size()-1)==4  || lst.get(lst.size()-1)==3 )) {
                    for (int m = 0; m < lst.size(); m++) {
                        System.out.print(lst.get(m) + " ");
                    }
                }
                flag = false;
                lst.remove(lst.size()-1);
                st.pop();
            }
            System.out.println();
        }
    }



    public boolean detectCycleUtil(int v, boolean[] visited, boolean[] recStack){
        if( !visited[v]) {
            visited[v] = true;
            recStack[v] = true;
            Iterator i = adj[v].listIterator();
            while (i.hasNext()) {
                int ele = (int) i.next();
                if (!visited[ele]) {
                    if (detectCycleUtil(ele, visited, recStack)) {
                        return true;
                    }
                } else if (recStack[v]) {
                    return true;
                }
            }
        }
        recStack[v]=true;
        return  false;
    }

    public void isCycle(){
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for(int i =0; i<V; i++){
            if(detectCycleUtil(i, visited, recStack)) {
                System.out.println("cycle in the graph");
                return;
            }
        }
        System.out.println("no cycle");
    }


}








