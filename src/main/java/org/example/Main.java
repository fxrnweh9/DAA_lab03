package org.example;

import com.google.gson.*;
import org.example.algorithms.Kruskal;
import org.example.algorithms.Prim;
import org.example.obj.Edge;
import org.example.obj.Graph;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = Files.readString(Paths.get("data/ass_3_input(1).json"));
        InputData input = gson.fromJson(json, InputData.class);

        List<Map<String, Object>> results = new ArrayList<>();

        for (GraphData g : input.graphs) {
            System.out.println("\n=== Processing Graph ID: " + g.id + " ===");

            Graph graph = new Graph(g.id, g.nodes, g.edges);

            Kruskal kruskal = new Kruskal(graph);
            kruskal.findMST();

            Prim prim = new Prim(graph);
            prim.findMST();

            System.out.println("\nKruskal Result:");
            kruskal.printResult();

            System.out.println("\nPrim Result:");
            prim.printResult();

            Map<String, Object> graphResult = new LinkedHashMap<>();
            graphResult.put("graph_id", g.id);
            graphResult.put("graph_type", g.type);

            Map<String, Object> inputStats = new LinkedHashMap<>();
            inputStats.put("vertices", g.nodes.size());
            inputStats.put("edges", g.edges.size());
            graphResult.put("input_stats", inputStats);

            Map<String, Object> primResult = new LinkedHashMap<>();
            primResult.put("edges", prim.getMstEdges());
            primResult.put("total_cost", prim.getTotalCost());
            primResult.put("steps", prim.getStepCount());
            primResult.put("execution_time_ms", prim.getExecTime());
            graphResult.put("prim", primResult);

            Map<String, Object> kruskalResult = new LinkedHashMap<>();
            kruskalResult.put("edges", kruskal.getMstEdges());
            kruskalResult.put("total_cost", kruskal.getTotalCost());
            kruskalResult.put("steps", kruskal.getStepCount());
            kruskalResult.put("execution_time_ms", kruskal.getExecTime());
            graphResult.put("kruskal", kruskalResult);

            results.add(graphResult);
        }

        Map<String, Object> output = new LinkedHashMap<>();
        output.put("results", results);

        try (FileWriter writer = new FileWriter("data/ass_3_output.json")) {
            gson.toJson(output, writer);
        }

        System.out.println("\nResults written to data/ass_3_output.json");
    }

    static class InputData {
        List<GraphData> graphs;
    }

    static class GraphData {
        int id;
        String type;
        List<String> nodes;
        List<Edge> edges;
    }
}
