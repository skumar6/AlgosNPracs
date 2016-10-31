/**
 * Created by Sanjeev on 9/30/2016.
 */
public class GraphHandler {
    public static void main(String[] args){
      //  Graphs g = new Graphs();
        GraphAdjacencyList g = new GraphAdjacencyList(7);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,5);
        g.addEdge(2,6);



//
//        graph.addEdge(0,1);
//        graph.addEdge(1,2);
//        graph.addEdge(0,3);
//        graph.addEdge(3,4);



      // graph.bfs();
//        System.out.println();

       // GraphAdjacencyList g = new GraphAdjacencyList(5);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);


        g.dfs(0);


    }
}
