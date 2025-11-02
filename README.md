# Analytical Report

**Course:** Design and Analysis of Algorithms  
**Student:** Olzhas Omerzak 
**Group:** SE-2403
**Assignment 3: Optimization of a City Transportation Network (Minimum Spanning Tree)**


## 1. Summary of Input Data and Algorithm Results

|Graph ID|Algorithm|Vertices|Edges|MST Edges|Total Cost|Steps|Execution Time (ms)|
|---|---|---|---|---|---|---|---|
|1|Prim|5|6|4|16|6|1|
|1|Kruskal|5|6|4|16|71|4|
|2|Prim|4|3|3|6|4|0|
|2|Kruskal|4|3|3|6|52|0|

**Notes:**

- Input data consists of weighted undirected graphs representing potential city roads between districts.
    
- Both algorithms correctly compute the Minimum Spanning Tree (MST) with identical total cost.
    
- Prim’s algorithm generally performs fewer operations (`steps`) on these small graphs.
    
- Execution times are negligible due to the small size of the graphs.
    

---

## 2. Comparison of Prim’s and Kruskal’s Algorithms

|Aspect|Prim’s Algorithm|Kruskal’s Algorithm|
|---|---|---|
|Algorithm Type|Greedy, grows MST from a starting node|Greedy, sorts edges and adds smallest valid edge|
|Data Structure Usage|Priority Queue, HashSet|DSU (Disjoint Set Union)|
|Steps / Operations|Fewer on small dense graphs|Higher due to edge sorting and union-find operations|
|Execution Time|Slightly faster on small graphs|Slightly slower due to sorting|
|MST Output|MST may differ in structure|MST may differ in structure|
|Efficiency|Better for dense graphs|Better for sparse graphs with many edges|
|Implementation Complexity|Moderate|Moderate to high (needs DSU)|

**Observations:**

- For small or dense graphs, Prim is more efficient in terms of operations.
    
- Kruskal is preferred for sparse graphs, especially when edges are already sorted or stored in edge lists.
    
- Both algorithms guarantee the correct MST and identical total cost, but the structure of the MST may vary.
    

---

## 3. Conclusions

1. **Correctness:** Both Prim’s and Kruskal’s algorithms reliably compute the MST with the minimal total cost.
    
2. **Efficiency:**
    
    - Prim’s algorithm is more efficient on small and dense graphs due to fewer operations.
        
    - Kruskal’s algorithm is more suitable for sparse graphs with a large number of vertices but relatively few edges.
        
3. **Implementation Considerations:**
    
    - Prim requires a priority queue and careful management of visited nodes.
        
    - Kruskal requires sorting edges and implementing a DSU structure for cycle detection.
        
4. **Recommendation:**
    
    - Use Prim for dense graphs or when adjacency structures are readily available.
        
    - Use Kruskal for sparse graphs or when edges are already in a list form.
        

---
