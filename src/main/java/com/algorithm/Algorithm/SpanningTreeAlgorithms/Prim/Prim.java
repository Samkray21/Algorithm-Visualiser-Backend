package com.algorithm.Algorithm.SpanningTreeAlgorithms.Prim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Prim {

    private List<Vertex> graph;
    public List<String> finalGraph = new ArrayList<>();

    public Prim(List<Vertex> graph){
        this.graph = graph;
    }

    public void run(){
        if (graph.size() > 0){
            graph.get(0).setVisited(true);
        }
        while (isDisconnected()){
            Edge nextMinimum = new Edge(Integer.MAX_VALUE, "");
            Vertex nextVertex = graph.get(0);
            for (Vertex vertex : graph){
                if (vertex.isVisited()){
                    Pair<Vertex, Edge> candidate = vertex.nextMinimum();
                    if (candidate.getElement1().getWeight() < nextMinimum.getWeight()){
                        nextMinimum = candidate.getElement1();
                        nextVertex = candidate.getElement0();
                    }
                }
            }
            nextMinimum.setIncluded(true);
            nextVertex.setVisited(true);

            if(!this.finalGraph.contains(nextMinimum.toString())){
                this.finalGraph.add(nextMinimum.toString());
            }

        }
    }

    private boolean isDisconnected(){
        for (Vertex vertex : graph){
            if (!vertex.isVisited()){
                return true;
            }
        }
        return false;
    }

    public String originalGraphToString(){
        StringBuilder sb = new StringBuilder();
        for (Vertex vertex : graph){
            sb.append(vertex.originalToString());
        }
        return sb.toString();
    }

    public void resetPrintHistory(){
        for (Vertex vertex : graph){
            Iterator<Map.Entry<Vertex,Edge>> it = vertex.getEdges().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Vertex,Edge> pair = it.next();
                pair.getValue().setPrinted(false);
            }
        }
    }

    public String minimumSpanningTreeToString(){
        StringBuilder sb = new StringBuilder();
        for (Vertex vertex : graph){
            sb.append(vertex.includedToString());
        }
        return sb.toString();
    }

}
