import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class MyGraph{

    List<ArrayList<Integer>> list = new ArrayList<>();
    public MyGraph(int vertices){
        // Adding the vertices / node here we are going to create arraylist for each vertices
        // (ie) 0 -> new ArrayList ::  1 -> new ArrayList :: 2 -> new ArrayList :: 3 -> new ArrayList ::  4 -> new ArrayList
        for(int i =0; i<vertices; i++){
            list.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v){
        // Adding connection between vertices this is 2 way connection so adding at one go
        // Input 0, 1
        // 0 --- (Edge) 1 && 1 --- (Edge) 0
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public void display(){
        if(list.isEmpty()) {
            System.out.println("Graph is empty...");
        }
        else {
            for (int i = 0; i < list.size(); i++) { // First getting all vertices list
                System.out.println("Elements in list .. " + i); // Printing vertice
                for(int j=0; j < list.get(i).size(); j++) { // Get connected vertices (edges) from 1st element (Line # 32)
                    System.out.println(list.get(i).get(j)); // Printing connected vertices through edge
                }
            }
        }
    }

    public void bfs(int v){ // For BFS search Queue is used
        Queue<Integer> queue = new LinkedList<>(); //Initializing empty queue
        boolean visited[] = new boolean[list.size()]; //Initializing visited array : In Graph traversal each node should visit only 1 time
        queue.add(v); // Adding entry node to queue
        visited[v] = true; // Marking entry node as visited

        while(queue.size()!=0){ // To print all nodes iterating the queue
            int vertex = queue.remove(); // Dequeue front node from queue
            System.out.println(vertex); // Printing front mode
            for(int i=0 ; i<list.get(vertex).size(); i++){ // Iterating the vertex list and getting its adjacent node
                int adjacentVertex = list.get(vertex).get(i); // Fetching adjacent node
                if(!visited[adjacentVertex]){ // Checking is the adjacent node as visited
                    queue.add(adjacentVertex);  // Adding that to queue
                    visited[adjacentVertex] = true; // Marking the adjacent node as visited
                }
            }
        }
    }

    public void dfs(int v){ // For DFS search stack is used
        Stack<Integer> stack = new Stack<>(); //Initializing empty stack
        boolean visited[] = new boolean[list.size()]; //Initializing visited array : In Graph traversal each node should visit only 1 time
        stack.add(v); // Adding the entry node to stack
        visited[v] = true; // Marking the entry node as visited

        while(stack.size()!=0){  // To print all nodes iterating the stack
            int vertex = stack.pop(); // poping the node from stack
            System.out.println(vertex); // Printing poped noede
            for(int i=0 ; i<list.get(vertex).size(); i++){ // To get all adjacent nodes for the given node iterating that
                int adjacentVertex = list.get(vertex).get(i); // Getting the adjacent node from ArrayList
                if(!visited[adjacentVertex]){ // Checking is the adjacent node is already visited or not
                    stack.add(adjacentVertex); // Adding the adjacent node to stack
                    visited[adjacentVertex] = true; // Marking the adjacent node as visited
                }
            }
        }
    }
}

public class GraphUsingArrayList {
    public static void main(String[] args ){
        MyGraph myGraph = new MyGraph(5);
       //   Graph representation
       //      0 --- 1 ---- 2
       //       |   |       |
       //         3 --------4

        myGraph.addEdge(0,1);
        myGraph.addEdge(0,3);
        myGraph.addEdge(1,2);
        myGraph.addEdge(1,3);
        myGraph.addEdge(2,4);
        myGraph.addEdge(3,4);

        myGraph.display();
        System.out.println("BFS.....");
        myGraph.bfs(0);
        System.out.println("DFS.....");
        myGraph.dfs(0);

    }
}
