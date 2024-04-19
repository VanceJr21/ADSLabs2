package org.example;
import org.graphstream.graph.implementations.SingleGraph;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;


public class TestGraphStream {

    public static void main(String[] args) {

        System.setProperty("org.graphstream.ui", "swing");

        SingleGraph g = new SingleGraph("Matthew's Graph");

        g.setAutoCreate(true);
        g.setStrict(false);

        HashSet<Integer> nodeArr = new HashSet<>();

        try{
            File graphFile = new File("src/main/java/org/example/mediumG.txt");
            Scanner sc = new Scanner(graphFile);

            //catch the number of vertices
            int numVertices = sc.nextInt();

            //catch the number of edges
            int numEdges = sc.nextInt();

            //for each edge
            for(int i= 0; i< numEdges; i++){
                //the first node
                int n1 =sc.nextInt();

                int n2 = sc.nextInt();

                //if the set contains neither node
                // add both to the set and create a node for each
                if(!nodeArr.contains(n1) && !nodeArr.contains(n2)){

                    // create a node for the vertex
                    g.addNode(String.valueOf(n1));

                    nodeArr.add(n1);

                    // create a node for the vertex
                    g.addNode(String.valueOf(n2));

                    nodeArr.add(n2);

                    System.out.println("adding nodes for " + n1+ " and " + n2);

                    g.addEdge(String.valueOf(n1) + String.valueOf(n2), String.valueOf(n1), String.valueOf(n2));

                }

                else if (!nodeArr.contains(n1) && nodeArr.contains(n2)) {

                    g.addNode(String.valueOf(n1));

                    nodeArr.add(n1);

                    System.out.println("Adding node for " + n1);

                    g.addEdge(String.valueOf(i), String.valueOf(n1), String.valueOf(n2));

                }

                // if the set contains only 1st node
                // create a node for the 2nd one and add and edge

                else if (nodeArr.contains(n1) && !nodeArr.contains(n2)){

                    g.addNode(String.valueOf(n2));

                    nodeArr.add(n2);

                    System.out.println("Adding node for " + n2);

                    g.addEdge(String.valueOf(i), String.valueOf(n1), String.valueOf(n2));
                }

                // if the set contains both nodes
                // add an edge between them

                else {
                    g.addEdge(String.valueOf(n1) + String.valueOf(n2), String.valueOf(n1), String.valueOf(n2));

                }
            }

            //styling all nodes
            for(org.graphstream.graph.Node node : g){
                node.setAttribute("ui.style", "shape:circle; fill-color:blue; size: 25px; text-size: 20;");
                node.setAttribute("ui.label", node.getId());
            }

            g.display();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
