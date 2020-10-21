package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class FigureImpl implements Figure {
    private int vertexCount;
    private Collection<Vertex> babyVertex = new ArrayList<>();

    public FigureImpl(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (babyVertex.size() == vertexCount) {
            throw new IllegalArgumentException();
        }
        babyVertex.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return babyVertex;
    }
}
