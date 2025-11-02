package org.example.algorithms;

import org.example.obj.Edge;
import org.example.obj.Graph;
import java.util.*;

public class Kruskal {

    private final Graph graph;
    private final List<Edge> mstEdges;
    private int totalCost;
    private int stepCount;
    private long execTime;

    public Kruskal(Graph graph) {
        this.graph = graph;
        this.mstEdges = new ArrayList<>();
        this.totalCost = 0;
        this.stepCount = 0;
        this.execTime = 0;
    }

    public void findMST() {
        long start = System.currentTimeMillis();

        List<Edge> edges = new ArrayList<>(graph.getEdges());
        edges.sort(Comparator.comparingInt(Edge::getWeight));
        stepCount += edges.size();

        Map<String, Integer> nodeIndex = new HashMap<>();
        int idx = 0;
        for (String node : graph.getNodes()) {
            nodeIndex.put(node, idx++);
        }

        DSU dsu = new DSU(graph.getNodes().size());

        for (Edge e : edges) {
            int u = nodeIndex.get(e.getFrom());
            int v = nodeIndex.get(e.getTo());

            if (dsu.union(u, v)) {
                mstEdges.add(e);
                totalCost += e.getWeight();
            }
            stepCount++;
        }

        execTime = System.currentTimeMillis() - start;
        stepCount += dsu.getStepCount();
    }

    public void printResult() {
        System.out.println("\n=== Kruskal Algorithm Result ===");
        System.out.println("Edges in MST: " + mstEdges);
        System.out.println("Total cost: " + totalCost);
        System.out.println("Steps: " + stepCount);
        System.out.println("Execution time: " + execTime + " ms");
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getStepCount() {
        return stepCount;
    }

    public long getExecTime() {
        return execTime;
    }

    public List<Edge> getMstEdges() {
        return mstEdges;
    }
}
