package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        if (toCheck == null || annotationToFind == null) {
            throw new IllegalArgumentException();
        }
        boolean a = false;
        Class clazz = toCheck.getClass();

        Package myPackage = clazz.getPackage();
        Annotation[] myPackageAnnotations = myPackage.getAnnotations();
        for (Annotation annotation : myPackageAnnotations) {
            if (annotation.annotationType().equals(annotationToFind)) {
                a = true;
            }
        }

        Annotation[] annotationsss = clazz.getAnnotationsByType(annotationToFind);
        for (Annotation annotation : annotationsss) {
            if (annotation.annotationType().equals(annotationToFind)) {
                a = true;
            }
        }

        Method[] methodss = clazz.getMethods();
        for (Method method : methodss) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(annotationToFind)) {
                    a = true;
                }
            }
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(annotationToFind)) {
                    a = true;
                }
            }
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[][] annotations = method.getParameterAnnotations();
            for (Annotation[] annotation : annotations) {
                for (Annotation annotation1 : annotation) {
                    if (annotation1.annotationType().equals(annotationToFind)) {
                        a = true;
                    }
                }
            }
        }

        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Annotation[] annotations = constructor.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(annotationToFind)) {
                    a = true;
                }
            }
        }

        return a;
    }
}
                

