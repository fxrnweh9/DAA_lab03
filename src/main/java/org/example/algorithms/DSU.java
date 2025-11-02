package org.example.algorithms;

public class DSU {

    private final int[] parent;
    private final int[] sizeRank;
    private int stepCount;

    public DSU(int n) {
        parent = new int[n];
        sizeRank = new int[n];
        stepCount = 0;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sizeRank[i] = 0;
            stepCount += 2;
        }
    }

    public int find(int x) {
        stepCount++;
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
            stepCount++;
        }
        return parent[x];
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        stepCount += 2;

        if (rootA == rootB) {
            return false;
        }

        if (sizeRank[rootA] < sizeRank[rootB]) {
            parent[rootA] = rootB;
            stepCount++;
        } else if (sizeRank[rootA] > sizeRank[rootB]) {
            parent[rootB] = rootA;
            stepCount++;
        } else {
            parent[rootB] = rootA;
            sizeRank[rootA]++;
            stepCount += 2;
        }

        return true;
    }

    public int getStepCount() {
        return stepCount;
    }
}
