import java.util.*;

public class GraphwMap {

    private HashMap<Character, LinkedList<Character>> adList ;

    private GraphwMap(){
        adList = new HashMap<>();
    }

    private void addEdge(char source, char destination){
        if(!adList.containsKey(source))
            adList.put(source, new LinkedList<>());
        if(!adList.containsKey(destination))
            adList.put(destination, new LinkedList<>());
        adList.get(source).add(destination);
    }

    public LinkedList<Character> getEdge(char source){
            return adList.get(source);
    }

    private void dfs(char root, HashMap<Character, Boolean> visited, Stack s){
        //System.out.println(root + " "  );
        visited.put(root, true);
        Iterator i = adList.get(root).listIterator();
        while(i.hasNext()){
            char c = (char) i.next();
            if(!visited.containsKey(c))
                dfs(c, visited, s);
//            else{
//                System.out.println("circle found...");
//                return;
//            }
            s.push(c);
        }
    }

    private void topologicalSort( ){
        //before running this we need to make sure the graf is DAG
        //CHECK OUT FOR CYCLE FIRST.
        Stack<Character> s = new Stack();
        HashMap<Character, Boolean> visited = new HashMap<Character, Boolean> ();
        for(Character key: adList.keySet()){
            char ch = key;
            if(!visited.containsKey(ch)){
                dfs(ch, visited, s);
            }
        }
        for(Character c : s){
            System.out.print(c+" ");
        }

    }

    private void bfs(char root){
        Queue q = new LinkedList<Character>();
        q.add(root);
        HashMap<Character, Boolean> hm = new HashMap<>();
        hm.put(root, true);
        while(!q.isEmpty()){
            char ch = (char) q.poll();
            System.out.println(ch+" ");
            Iterator i = adList.get(ch).listIterator();
            System.out.println("here...");
            while(i.hasNext()){
                char d = (char) i.next();
                if(!hm.containsKey(d)){
                    hm.put(d,true);
                    q.add(d);
                }
            }
        }
    }


    public static void main(String[] args){
        GraphwMap graph = new GraphwMap();
        graph.addEdge('a','b');
        graph.addEdge('a','c');
       // graph.addEdge('b','c');
        //graph.addEdge('c','a');
        graph.addEdge('c','d');
        graph.addEdge('d','e');
        graph.addEdge('e','a');
      
//        LinkedList<Character> ll = graph.getEdge('b');
//        System.out.println(ll.size());
//        for(Character c  : ll){
//            System.out.println(c+" ");
//        }
        System.out.println(graph.adList.size());
        graph.topologicalSort();
       // graph.bfs('a');



    }
}
