import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        st.push(s);
        //visited1[s] = true;
        System.out.println(s + ": initial push ");


        while (!st.empty()) {
            int n = st.pop();
            if (!visited1[n]) {
                st.push(n);
                visited1[n] = true;
                System.out.print(n + " ");
                Iterator i = adj[n].listIterator();
                while (i.hasNext()) {
                    st.push((Integer) i.next());


                }
            }
            System.out.println();
        }
    }
}








