package com.algorithm.Algorithm;

import java.util.ArrayList;
import java.util.List;

import com.algorithm.Algorithm.SpanningTreeAlgorithms.Prim.Edge;
import com.algorithm.Algorithm.SpanningTreeAlgorithms.Prim.Prim;
import com.algorithm.Algorithm.SpanningTreeAlgorithms.Prim.Vertex;
import org.junit.Test;
public class PrimsUnitTest {


    @Test
    public void givenAGraph_whenPrimRuns_thenPrintMST() {
        Prim prim = new Prim(createGraph());
        System.out.println(prim.originalGraphToString());
        System.out.println("----------------");
        prim.run();
        System.out.println();
        prim.resetPrintHistory();
        System.out.println(prim.minimumSpanningTreeToString());
    }

    public static List<Vertex> createGraph() {
        List<Vertex> graph = new ArrayList<>();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Edge ab = new Edge(2, "AB");
        a.addEdge(b, ab);
        b.addEdge(a, ab);
        Edge ac = new Edge(3, "AC");
        a.addEdge(c, ac);
        c.addEdge(a, ac);
        Edge bc = new Edge(2, "BC");
        b.addEdge(c, bc);
        c.addEdge(b, bc);
        Edge be = new Edge(5, "BE");
        b.addEdge(e, be);
        e.addEdge(b, be);
        Edge cd = new Edge(1, "CD");
        c.addEdge(d, cd);
        d.addEdge(c, cd);
        Edge ce = new Edge(1, "CE");
        c.addEdge(e, ce);
        e.addEdge(c, ce);
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        return graph;
    }

}
