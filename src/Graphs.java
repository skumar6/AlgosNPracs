import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Sanjeev on 9/30/2016.
 */
public class Graphs {

    public static int MAX_VERT = 20;
    Vertex[] vertexList ;
    int[][] adjMatrix;
    int nVert;

    public Graphs(){
        nVert = 0;
        vertexList = new Vertex[MAX_VERT];
        adjMatrix = new int[MAX_VERT][MAX_VERT];

        for(int i = 0; i< MAX_VERT; i++){
            for(int j =0; j<MAX_VERT; j++){
                adjMatrix[i][j] =0;
            }
        }
    }

    //add a vertex
    public void addVertex(String l){
        vertexList[nVert++] = new Vertex(l);
    }

    //add an edge
    public void addEdge(int i, int j){
        adjMatrix[i][j]=1;
        adjMatrix[j][i]=1;
    }

    //display
    public void display(int v){
        System.out.print(vertexList[v].label + " ");
    }

    //get list of all neighbours
    public int getAdjanctVertex(int v){
        for(int i =0; i< MAX_VERT; i++){
            if(adjMatrix[v][i] == 1 && !vertexList[i].isVisited)
                return i;
        }
        return -1;
    }

    /*depth first search implemnts stack
    1.push current node to stack
    2.keeping pushing until node has adjacent node
    3.if not, pop continue 2, 1.
     */
    public void dfs (){
        Stack<Integer> s = new Stack<Integer>();
        vertexList[0].isVisited = true;
        display(0);
        s.push(0);

        while(!s.isEmpty()){
            int v = getAdjanctVertex(s.peek());
            if(v == -1) {
                s.pop();
                System.out.println(" ");
            }
            else{
                vertexList[v].isVisited = true;
                display(v);
                s.push(v);
            }

        }
        for(int i =0; i<nVert; i++){
            vertexList[i].isVisited = false;
        }
    }

    /*breadth first search
    1. we ll be using queue over here
    2.put every adjacent, unvisited vertex on the queue
     3.similar to trees
     4.when no univisted node level is done
     5.pop and do the same
     6.queue empty? you are done
     */
    public void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        display(0);
        vertexList[0].isVisited= true;
        int v1;

        while(!q.isEmpty()){
            int cur = q.remove();
            while((v1=getAdjanctVertex(cur))!= -1){
                display(v1);
                vertexList[v1].isVisited = true;
                q.add(v1);
            }
            
        }

        for(int i =0; i<nVert; i++){
            vertexList[i].isVisited= false;
        }
    }



}
