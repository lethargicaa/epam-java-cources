package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashSet;

public class Task012Impl implements Task012 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        if (sourceGraph == null || actions == null || actions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (var action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        if (graph == null) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        if (graph instanceof GraphImpl) {
            count = ((GraphImpl) graph).getVertexesCount();
        }
        if (count < from || count < to) {
            throw new IllegalArgumentException();
        }

        if (graph.edgeExists(from, to)) {
            return true;
        }

        HashSet<Integer> visited = new HashSet<Integer>();
        int current = from;
        visited.add(from);
        boolean newVert = true;

        while (newVert) {
            newVert = false;
            Collection<Integer> neighbors = graph.getAdjacent(current);
            for (int x : neighbors) {
                if (x == to) {
                    return true;
                }
                if (!visited.contains(x)) {
                    current = x;
                    visited.add(x);
                    newVert = true;
                }
            }
        }
        return false;
    }
}