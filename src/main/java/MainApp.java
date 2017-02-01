/**
 * Created by RENT on 2017-02-01.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {
    private static EntityManager entityManager;

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("ProjectPU");
        entityManager = entityManagerFactory.createEntityManager();


        createAddress(2, "Wrocław", "Legincka 50");
        //deleteAddress(1, "Wrocław", "Plac Grunwaldzki");
    }

    private static void createAddress(int id, String city, String street) {
        entityManager.getTransaction().begin();
        MyAddress address = new MyAddress(id, city, street);
        entityManager.persist(address);
        entityManager.getTransaction().commit();
    }

    private static void deleteAddress(int id, String city, String street) {
        entityManager.getTransaction().begin();
        entityManager.flush();
        MyAddress address = new MyAddress(id, city, street);
        entityManager.remove(address);
        entityManager.getTransaction().commit();
    }
}
