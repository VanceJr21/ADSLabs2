package org.example;

public class DijkstraSP {

    private DirectedEdge[] edgeTo; // edge

    private IndexMinPQ<Double> pq;

    private double[] distTo;


    /**
     * Parameterized constructor
     * @param G - The edge-weighted digraph
     * @param s - The starting vertex
     */


    public DijkstraSP(WeightedDigraph G, int s){

        // check for negative weights
        for(DirectedEdge e : G.edges()){
            if(e.weight() < 0){
                throw new IllegalArgumentException("edge " + e + " has negative weights");
            }
        }

        distTo = new double[G.getV()];

        edgeTo = new DirectedEdge[G.getV()];

        validateVertex(s);

        // for each vertex
        for(int v = 0; v < G.getV(); v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        // set the starting cost
        distTo[s] = 0.0;

        pq = new IndexMinPQ<>(G.getV());
    }

    private void validateVertex(int v){
         int V = distTo.length;

         if(v < 0|| v>= V){
             throw new IllegalArgumentException("vertex " +V+ "is not between 0 and " +(V-1));
         }

    }

}
