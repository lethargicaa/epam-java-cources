package com.epam.university.java.core.task012;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class GraphImpl implements Graph {

    private HashMap<Integer, HashSet<Integer>> edges;
    private int vertexesCount;

    public int getVertexesCount() {
        return vertexesCount;
    }

    public GraphImpl(int vertexesCount) {
        this.edges = new HashMap<>(vertexesCount);
        this.vertexesCount = vertexesCount;
    }

    @Override
    public void createEdge(int from, int to) {
        if (vertexesCount < from || vertexesCount < to) {
            throw new IllegalArgumentException();
        }

        if (!edges.containsKey(from)) {
            edges.put(from, new HashSet<>()); // edges.size() - 1
        }
        if (!edges.containsKey(to)) {
            edges.put(to, new HashSet<>()); // edges.size() - 1
        }
        if (to != from) {
            edges.get(from).add(to);
            edges.get(to).add(from);
        }
    }

    @Override
    public boolean edgeExists(int from, int to) {
        return edges.containsKey(from) && edges.get(from).contains(to);
    }

    @Override
    public void removeEdge(int from, int to) {

        if (edges.containsKey(from) && edges.containsKey(to)) {
            edges.get(from).remove(to);
            edges.get(to).remove(from);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        return edges.getOrDefault(from, null);
    }
}
