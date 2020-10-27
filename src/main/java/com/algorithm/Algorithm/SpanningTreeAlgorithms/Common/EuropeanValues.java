package com.algorithm.Algorithm.SpanningTreeAlgorithms.Common;

import com.algorithm.Algorithm.SpanningTreeAlgorithms.Boruvka.BoruvkaMST;
import com.algorithm.Algorithm.SpanningTreeAlgorithms.Kruskal.Kruskal;
import com.algorithm.Algorithm.SpanningTreeAlgorithms.Prim.Edge;
import com.algorithm.Algorithm.SpanningTreeAlgorithms.Prim.Prim;
import com.algorithm.Algorithm.SpanningTreeAlgorithms.Prim.Vertex;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EuropeanValues {

    private MutableValueGraph<Integer, Integer> graph;

    public List<String> getResults(String startingVertex, String algorithm){
        if (algorithm.equals("Prim")) {

            List<Vertex> primsGraph = new ArrayList<>();
            Map<Vertex, Boolean> edgeList = new LinkedHashMap<>();

            Vertex a = new Vertex("A");
            Vertex b = new Vertex("B");
            Vertex c = new Vertex("C");
            Vertex d = new Vertex("D");
            Vertex e = new Vertex("E");
            Vertex f = new Vertex("F");
            Vertex g = new Vertex("G");
            Vertex h = new Vertex("H");
            Vertex i = new Vertex("I");
            Vertex j = new Vertex("J");

            edgeList.put(a, false);
            edgeList.put(b, false);
            edgeList.put(c, false);
            edgeList.put(d, false);
            edgeList.put(e, false);
            edgeList.put(f, false);
            edgeList.put(g, false);
            edgeList.put(h, false);
            edgeList.put(i, false);
            edgeList.put(j, false);


            Edge ab = new Edge(1866, "BA");
            a.addEdge(b, ab);
            b.addEdge(a, ab);

            Edge ad = new Edge(1444, "DA");
            a.addEdge(d, ad);
            d.addEdge(a, ad);

            Edge ae = new Edge(343, "EA");
            a.addEdge(e, ae);
            e.addEdge(a, ae);

            Edge af = new Edge(882, "FA");
            a.addEdge(f, af);
            f.addEdge(a, af);

            Edge bf = new Edge(1073, "FB");
            b.addEdge(f, bf);
            f.addEdge(b, bf);

            Edge bh = new Edge(1051, "BH");
            b.addEdge(h, bh);
            h.addEdge(b, bh);

            Edge bc = new Edge(1137, "CB");
            b.addEdge(c, bc);
            c.addEdge(b, bc);

            Edge fe = new Edge(1034, "EF");
            f.addEdge(e, fe);
            e.addEdge(f, fe);

            Edge ed = new Edge(1575, "DE");
            e.addEdge(d, ed);
            d.addEdge(e, ed);


            Edge cd = new Edge(1860, "DC");
            c.addEdge(d, cd);
            d.addEdge(c, cd);


            Edge dg = new Edge(1630, "GD");
            d.addEdge(g, dg);
            g.addEdge(d, dg);

            Edge ge = new Edge(463, "GE");
            g.addEdge(e, ge);
            e.addEdge(g, ge);

            Edge ei = new Edge(955, "IE");
            e.addEdge(i, ei);
            i.addEdge(e, ei);

            Edge ih = new Edge(979, "HI");
            i.addEdge(h, ih);
            h.addEdge(i, ih);

            Edge fh = new Edge(992, "HF");
            f.addEdge(h, fh);
            h.addEdge(f, fh);

            Edge jh = new Edge(402, "HJ");
            j.addEdge(h, jh);
            h.addEdge(j, jh);

            Edge ji = new Edge(724, "JI");
            j.addEdge(i, ji);
            i.addEdge(j, ji);

            for (Map.Entry<Vertex, Boolean> edge : edgeList.entrySet()) {
                if (startingVertex.equals(edge.getKey().getLabel())) {
                    primsGraph.add(edge.getKey());
                    edge.setValue(true);
                    break;
                }
            }

            for (Map.Entry<Vertex, Boolean> edge : edgeList.entrySet()) {
                if (edge.getValue().equals(false)) {
                    primsGraph.add(edge.getKey());
                }
            }

            Prim prim = new Prim(primsGraph);
            prim.run();
            prim.resetPrintHistory();

            List<String> compareEdges = new ArrayList<>();

            for (int m=0; m<prim.finalGraph.size(); m++){
                String[] splitEdge = prim.finalGraph.get(m).split("(?!^)");
                if(splitEdge[0].equals(startingVertex) && m == 0){
                    prim.finalGraph.set(m, splitEdge[1] + splitEdge[0]);
                }else if (compareEdges.contains(splitEdge[1]) && m != 0){
                    //do nothing
                }else if(m != 0){
                    prim.finalGraph.set(m, splitEdge[1] + splitEdge[0]);
                }
                compareEdges.add(splitEdge[0]);
                compareEdges.add(splitEdge[1]);

            }

            return prim.finalGraph;

        }else{
            this.graph = ValueGraphBuilder.undirected().build();
            this.graph.putEdgeValue(0, 1, 1866);
            this.graph.putEdgeValue(0, 3, 1444);
            this.graph.putEdgeValue(0, 4, 343);
            this.graph.putEdgeValue(0, 5, 882);
            this.graph.putEdgeValue(1, 5, 1073);
            this.graph.putEdgeValue(1, 7, 1051);
            this.graph.putEdgeValue(1, 2, 1137);

            this.graph.putEdgeValue(4, 5, 1034);
            this.graph.putEdgeValue(3, 4, 1575);

            this.graph.putEdgeValue(2, 3, 1860);
            this.graph.putEdgeValue(3, 6, 1630);
            this.graph.putEdgeValue(6, 4, 463);
            this.graph.putEdgeValue(4, 8, 955);
            this.graph.putEdgeValue(8, 7, 979);
            this.graph.putEdgeValue(5, 7, 992);

            this.graph.putEdgeValue(9, 7, 402);
            this.graph.putEdgeValue(9, 8, 724);

            if (algorithm.equals("Kruskal")){
                Kruskal kruskal = new Kruskal();
                kruskal.minSpanningTree(this.graph);
                return kruskal.getFinalKGraph();
            }else if(algorithm.equals("Boruvka")){
                BoruvkaMST boruvkaMST = new BoruvkaMST(this.graph);
                return boruvkaMST.getFinalKGraph();
            }
        }
        return null;
    }
}
