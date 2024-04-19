package org.example;

import java.io.File;
import java.util.*;

/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 04/03/2024
Description: Implementing the dfs_traversal, is_DAG, bfs_traversal, and is_Disconnected
             to the Weighted Digraph.
 */


public class WeightedDigraph {

    private int V;

    private int E;

    private Bag<DirectedEdge>[] adj;

    private int [] indegree;

    //parameterized constructor
    public WeightedDigraph(String inFile){

        // build the graph
        try{
            File graphFile = new File(inFile);
            Scanner sc = new Scanner(graphFile);

            // get the number of vertices
            this.V = sc.nextInt();
            indegree = new int[V];


            // create adjacency list for vertices
            adj = new Bag[V];
            for(int v = 0; v < V; v++){
                adj[v] = new Bag<DirectedEdge>();
            }

            // get the number of edges
            int E = sc.nextInt();
            for (int i=0; i< E; i++){

                // get the first vertex
                int v1 = sc.nextInt();

                //get the second vertex
                int v2 = sc.nextInt();

                //validate the vertices
                validateVertex(v1);
                validateVertex(v2);

                // get the weight of the edge
                double w = sc.nextDouble();

                // adding the edge
                addEdge(new DirectedEdge(v1, v2, w));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    //copy constructor
    // Angle help with this.
    public WeightedDigraph(WeightedDigraph wd){
        this.V = wd.V;

        this.E = wd.E;

        this.indegree = wd.indegree;

        this.adj = (Bag<DirectedEdge>[]) new Bag[V];

        for (int i = 0; i< V; i++){
            this.adj[V] = new Bag<>();
            for (Iterator<DirectedEdge> it = wd.adj[i].iterator(); it.hasNext(); ) {
                DirectedEdge e = it.next();
                this.adj[i].add(new DirectedEdge(e.from(), e.to(), e.weight()));
            }
        }
    }

    // Getters and Setters
    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    public Bag<DirectedEdge>[] getAdj() {
        return adj;
    }

    public void setAdj(Bag<DirectedEdge>[] adj) {
        this.adj = adj;
    }

    public int[] getIndegree() {
        return indegree;
    }

    public void setIndegree(int[] indegree) {
        this.indegree = indegree;
    }


    /**
     * Using depth first search algorithm to traverse through the graph.
     * @param startV - is the starting vertices
     * @return - the traversal order of each visited vertices
     */

    public ArrayList<Integer> dfs_traversal(int startV){

        boolean[] visited = new boolean[V]; // if vertices are visited
        ArrayList<Integer> dfsOrder = new ArrayList<>(); // created an arraylist to hold the vertices being visited.
        Stack<Integer> stack = new Stack<>(); // creating a stack

        stack.push(startV); // putting the starting vertex into the stack

        // iterating through the stack
        while (!stack.isEmpty()){

            int currentV = stack.pop();// popping the stack then storing it as the current vertex

            // checking if the list has the current vertex
            if (!dfsOrder.contains(currentV)){
                dfsOrder.add(currentV);
            }

            // marking that current vertex that it was visited
            visited[currentV] = true;

            // looping through the adj list
            for( DirectedEdge e : adj[currentV]){
                int adjVertex = e.to();
                // checking if the next vertex has not been visited
                // then adding the vertex to the stack
                if (!visited[adjVertex]){
                    stack.add(adjVertex);

                }

            }
        }

        return dfsOrder;

    }


    /**
     *  Using breath first search algorithm to traverse through the graph.
     * @param startV - The starting vertex
     * @return - the order of the traversal for the shortest path.
     */

    public ArrayList<Integer> bfs_traversal(int startV){
        boolean[] visited = new boolean[V]; // Initialize a boolean array called visited
        Queue<Integer> queue = new LinkedList<>(); // creating a queue for the traversal
        ArrayList<Integer> bfsOrder = new ArrayList<>(); // creating an arraylist to store the order of the traversal.

        queue.add(startV); // adding the starting vertex to the queue

        // iterating through queue
        while (!queue.isEmpty()){

            // storing the current vertex of dequeueing from the queue
            int currentV = queue.poll();

            // checking if the arraylist doesn't have each current vertex
            // then adding the current vertex to the list
            if (!bfsOrder.contains(currentV)){
                bfsOrder.add(currentV);
            }

            visited[currentV] = true; // marking the current vertex being visited

            // looping through the adj list
            for( DirectedEdge e : adj[currentV]){
                // getting the vertex from the edge
                int adjVertex = e.to();
                // if the vertex from the edge is not visited then
                // add the vertex to the queue
                if (!visited[adjVertex]){
                    queue.add(adjVertex);

                }
            }



        }

        return bfsOrder;

    }

    //https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
    private boolean isCycle(int i, boolean[] visited, boolean[] recursion){


        // marking the visited and recursion
        if (recursion[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recursion[i] = true;

       // looping through the adj list
        for (DirectedEdge e : adj[i])
            // checking for a cycle by recalling the function
            if (isCycle(e.to(), visited, recursion))
                return true;

        recursion[i] = false;

        return false;
    }

    // https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
    public boolean is_DAG() {
        boolean[] visited = new boolean[V]; //  creating visited boolean list
        boolean[] recursion = new boolean[V]; // creating recursive boolean list

        // looping through all the vertices
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCycle(i, visited, recursion)) {
                return false; // is not a dag
            }
        }
        return true; //  is a dag


    }


    // reusing the dfs traversal but not returning any array
    public void dfs(int vertex, boolean[] visited){

        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);

        while (!stack.isEmpty()){

            int currentV = stack.pop();

            visited[currentV] = true;

            for( DirectedEdge e : adj[currentV]){
                int adjVertex = e.to();
                if (!visited[adjVertex]){
                    stack.add(adjVertex);

                }

            }
        }

    }

    // checking if the graph is disconnected
    public boolean is_Disconnected(){
        boolean[] visited = new boolean[V];

        dfs(0, visited); // call the dfs method

        // looping through the list
        for(Boolean v : visited){
            if(!v){
                return true; // is disconnected
            }
        }

        return false; // not disconnected

    }





    /**
     * Function to validate a vertex
     * @param v - the given vertex
     */

    private void validateVertex(int v){
        if(v < 0 || v >= V){
            throw new RuntimeException("Invalid vertex");
        }
    }

    /**
     * Function to add directed edge
     * @param e - The given edge
     */

    public void addEdge(DirectedEdge e){
         // get tail vertex
        int v = e.from();

        // get head vertex
        int w = e.to();

        // check if vaild vertices
        validateVertex(v);
        validateVertex(w);

        // add the edge in the adjacency list
        adj[v].add(e);

        //adjust the degree
        indegree[w]++;

        //increment edges
        E++;
    }


    public Iterable<DirectedEdge> edges(){

        Bag<DirectedEdge> list = new Bag<>();

        //for each vertex
        for(int v =0; v< V; v++){
            // for each edge
            for(DirectedEdge e: adj(v)){
                list.add(e);
            }
        }
        return list;
    }

    // return the directed edges from vertex v
    public Iterable<DirectedEdge> adj(int v){
        validateVertex(v);
        return adj[v];
    }

    //toString
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + "vertices, " + E + " Edges\n");

        //for each vertex
        for(int v =0; v< V; v++){
            sb.append(v +" ");
            // for each edge
            for(DirectedEdge e: adj(v)){
                sb.append(e + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WeightedDigraph G = new WeightedDigraph("tinyEWD.txt");
        WeightedDigraph G2 = new WeightedDigraph("tinyEWD_DAG.txt"); // for the DAG method

        System.out.println("dfs -> " + G.dfs_traversal(7));

       System.out.println("bfs -> " + G.bfs_traversal(3));

        if (G2.is_DAG()){
            System.out.println("The graph is a DAG");
        } else {
            System.out.println("The graph is not a DAG");
        }

        if (G.is_Disconnected()){
            System.out.println("The graph is disconnected");
        } else {
            System.out.println("The graph is not disconnected");
        }
    }
}
