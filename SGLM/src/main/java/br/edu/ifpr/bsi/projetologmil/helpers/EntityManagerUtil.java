package br.edu.ifpr.bsi.projetologmil.helpers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory factory = null;

    static {
        try {
            factory = Persistence.createEntityManagerFactory("sglmPU");
        } catch (Exception e) {
            System.err.println("Failed to create EntityManagerFactory: " + e);
            e.printStackTrace();
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }

    public static void closeEntityManagerFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}