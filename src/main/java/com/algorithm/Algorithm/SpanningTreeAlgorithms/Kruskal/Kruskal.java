package com.algorithm.Algorithm.SpanningTreeAlgorithms.Kruskal;
import com.algorithm.Algorithm.SpanningTreeAlgorithms.Common.NumToStringConverter;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraph;
import com.google.common.graph.ValueGraphBuilder;

import java.util.*;

public class Kruskal {

    private List<String> finalKGraph = new ArrayList<>();
    private NumToStringConverter convert = new NumToStringConverter();

    public ValueGraph<Integer, Integer> minSpanningTree(ValueGraph<Integer, Integer> graph) {
        return spanningTree(graph, true);
    }

    public ValueGraph<Integer, Integer> maxSpanningTree(ValueGraph<Integer, Integer> graph) {
        return spanningTree(graph, false);
    }

    private ValueGraph<Integer, Integer> spanningTree(ValueGraph<Integer, Integer> graph, boolean minSpanningTree) {
        Set<EndpointPair<Integer>> edges = graph.edges();
        List<EndpointPair<Integer>> edgeList = new ArrayList<>(edges);

        if (minSpanningTree) {
            edgeList.sort(Comparator.comparing(e -> graph.edgeValue(e).get()));
        } else {
            edgeList.sort(Collections.reverseOrder(Comparator.comparing(e -> graph.edgeValue(e).get())));
        }

        int totalNodes = graph.nodes().size();
        CycleDetector cycleDetector = new CycleDetector(totalNodes);
        int edgeCount = 0;

        MutableValueGraph<Integer, Integer> spanningTree = ValueGraphBuilder.undirected().build();
        for (EndpointPair<Integer> edge : edgeList) {
            if (cycleDetector.detectCycle(edge.nodeU(), edge.nodeV())) {
                continue;
            }
            spanningTree.putEdgeValue(edge.nodeU(), edge.nodeV(), graph.edgeValue(edge).get());
            finalKGraph.add(convert.convertNumToString(edge.nodeU()) + convert.convertNumToString(edge.nodeV()));
            edgeCount++;
            if (edgeCount == totalNodes - 1) {
                break;
            }
        }
        return spanningTree;
    }

    public List<String> getFinalKGraph() {
        return finalKGraph;
    }

    public void setFinalKGraph(List<String> finalKGraph) {
        this.finalKGraph = finalKGraph;
    }

}
