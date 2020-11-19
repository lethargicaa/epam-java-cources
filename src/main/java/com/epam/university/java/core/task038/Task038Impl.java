package com.epam.university.java.core.task038;

import java.util.Collection;

public class Task038Impl implements Task038 {
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
    public Collection<Vertex> getShortestPath(Graph graph, int startId, int endId) {
        return null;
    }
}
