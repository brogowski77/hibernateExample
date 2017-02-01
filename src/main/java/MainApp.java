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

        //createAddress(1, "Wrocław", "Plac Grunwaldzki");
        //createAddress(2, "Wrocław", "Legincka 50");
        
        //usuwa po id
        deleteAddress(2);
    }

    private static void createAddress(int id, String city, String street) {
        entityManager.getTransaction().begin();
        MyAddress address = new MyAddress(id, city, street);
        entityManager.persist(address);
        entityManager.getTransaction().commit();
    }


    private static void deleteAddress(int id) {
        MyAddress address = entityManager.find(MyAddress.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(address);
        entityManager.getTransaction().commit();
    }

}
