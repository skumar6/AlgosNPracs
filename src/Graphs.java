import java.util.Stack;

/**
 * Created by Sanjeev on 9/30/2016.
 */
public class Graphs {

    private final int MAX_VERT = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Stack s;

    public Graphs(){
        vertexList = new Vertex[MAX_VERT];
        adjMat = new int[MAX_VERT][MAX_VERT];
        nVerts =0;
        for(int i=0; i<MAX_VERT;i++){
            for(int k =0; k<MAX_VERT; k++){
                adjMat[i][k]=0;
            }
        }
        s = new Stack();
    }

    //add a vertex to graph
    public void addVertex(String label){
        vertexList[nVerts++] = new Vertex(label);
    }

    //add an edge
    public void addEdge (int start, int end){
        adjMat[start][end]=1;
        adjMat[start][end]=1;
    }

    //display a node
    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }

    /*dfs: the idea is to
    * 1.visit first vertex, set the flag visited, take one of its adj nodes and move forward
    * 2.take a stack and put visited nodes on it
    * 3.when hit the deadend, backtrack popping out, on the peek see for unvisited node
    * 4. if yes, put on stack, if no pop out.
    * */

    public void dfs(){
        //intialize from the first 0
        vertexList[0].isVisited = true;
        displayVertex(0);
        s.push(0);

        while(!s.isEmpty()){
            int v2  = getUnvisitedVertex((int)s.peek());
            if(v2 != -1){
                 s.push(v2);
                 vertexList[v2].isVisited= true;
                 displayVertex(v2);
            }else{
                s.pop();
            }
        }

        //if stack becomes empty we are done, set the flags
        for(int i =0; i<nVerts; i++){
            vertexList[i].isVisited = false;
        }

    }

    public int getUnvisitedVertex(int v){
        for(int i =0; i<nVerts; i++){
            if(adjMat[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }


}
