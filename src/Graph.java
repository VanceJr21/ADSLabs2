import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
    private int V; //number of vertices
    private int E;  // number of edges

    private Bag<Integer>[] adj;

    public Graph(int v){
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[v];

        for(int i=0; i< V; i++){
            adj[i] = new Bag<>();
        }
    }

    // A Graph constructor that initializes a Graph OS from
    // a file

    public Graph(String fileName){

        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            this.V = sc.nextInt();

            adj = (Bag<Integer>[]) new Bag[V];

            for(int i=0; i< V; i++){
                adj[i] = new Bag<>();
            }

            this.E = sc.nextInt();

            for(int i=0; i < this.E; i++){
                int v = sc.nextInt();
                int w = sc.nextInt();

                if(validateVertex(v) && validateVertex(w)){
                    addEdge(v,w);
                }

            }


        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private boolean validateVertex(int v){
        if(v < 0 || v >this.V){
            return false;
        }
        return true;
    }

    // Adding edges for an undirected graph data structure
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    // Returns the vertices adjacent to vertex v
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    //Returns the degree of vertex v
    public int degree(int v){
        return adj[v].size();
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices " + E + " edges\n");

        for(int i=0; i < V; i++){
            s.append(i +": ");
            for( int w : adj[i]){
                s.append(w +", ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    // for testing purposes ONLY
    public static void main(String[] args) {
        Graph g = new Graph("mediumG.txt");
        System.out.println(g);
    }
}
