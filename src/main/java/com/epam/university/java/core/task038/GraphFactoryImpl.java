package com.epam.university.java.core.task038;

import com.epam.university.java.core.task012.GraphImpl;

public class GraphFactoryImpl implements GraphFactory {
    @Override
    public Graph newInstance(int vertexCount) {
        if (vertexCount == 0) {
            throw new IllegalArgumentException();
        }
        return ((Graph) new GraphImpl(vertexCount));
    }
}