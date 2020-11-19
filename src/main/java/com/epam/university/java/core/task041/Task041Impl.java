package com.epam.university.java.core.task041;

import java.util.ArrayList;
import java.util.Collection;

public class Task041Impl implements Task041 {

    @Override
    public Entity create(Collection<Entity> collection, String value) {
        if (collection == null || value == null) {
            throw new IllegalArgumentException();
        }
        //ArrayList<Entity> arrayList = new ArrayList<>(collection);
        // Entity en1 = (new EntityImpl(collection.size(), value));
        collection.add(new EntityImpl(collection.size(), value));
        ArrayList<Entity> arrayList = new ArrayList<>(collection);
        for (Entity e : collection) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Entity read(Collection<Entity> collection, Entity entity) {
        if (collection == null || entity == null) {
            throw new IllegalArgumentException();
        }
        return entity;
    }

    @Override
    public void update(Collection<Entity> collection, Entity entity, String value) {
        if (collection == null || value == null || entity == null || collection.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (Entity e : collection) {
            if (e.equals(entity)) {
                int x = e.getId();
                collection.remove(e);
                Entity xex = new EntityImpl(x, value);
                collection.add(xex);
            }
        }
    }

    @Override
    public void delete(Collection<Entity> collection, Entity entity) {
        if (collection == null || entity == null) {
            throw new IllegalArgumentException();
        }
        collection.remove(entity);
    }
}


//    @Test
//    public void testCreate() throws Exception {
//        Entity entity = instance.create(targetCollection, "Another Entity");
//        assertEquals(entity.getId(), targetCollection.size() - 1);
//    }