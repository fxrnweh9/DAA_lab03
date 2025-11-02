package org.example.algorithms;

import org.example.obj.Edge;
import org.example.obj.Graph;

import java.util.*;

public class Prim {

    private final Graph graph;
    private final List<Edge> mstEdges;
    private int totalCost;
    private int stepCount;
    private long execTime;

    public Prim(Graph graph) {
        this.graph = graph;
        this.mstEdges = new ArrayList<>();
        this.totalCost = 0;
        this.stepCount = 0;
        this.execTime = 0;
    }

    public void findMST() {
        long start = System.currentTimeMillis();

        List<String> nodes = graph.getNodes();
        if (nodes.isEmpty()) return;

        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        String startNode = nodes.get(0);
        visited.add(startNode);

        for (Edge e : graph.getEdges()) {
            if (e.getFrom().equals(startNode) || e.getTo().equals(startNode)) {
                pq.offer(e);
            }
        }

        stepCount++;

        while (!pq.isEmpty() && mstEdges.size() < nodes.size() - 1) {
            Edge edge = pq.poll();
            stepCount++;

            String u = edge.getFrom();
            String v = edge.getTo();

            String next = null;
            if (visited.contains(u) && !visited.contains(v)) next = v;
            else if (visited.contains(v) && !visited.contains(u)) next = u;

            if (next == null) continue;

            mstEdges.add(edge);
            totalCost += edge.getWeight();
            visited.add(next);

            for (Edge e : graph.getEdges()) {
                if ((e.getFrom().equals(next) && !visited.contains(e.getTo())) ||
                        (e.getTo().equals(next) && !visited.contains(e.getFrom()))) {
                    pq.offer(e);
                }
            }
        }

        execTime = System.currentTimeMillis() - start;
    }

    public void printResult() {
        System.out.println("\n=== Prim Algorithm Result ===");
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
