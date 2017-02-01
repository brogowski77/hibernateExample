/**
 * Created by RENT on 2017-02-01.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {
    private static EntityManager entityManager;

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpaExample");
        entityManager = entityManagerFactory.createEntityManager();

        //createAddress(1, "Wrocław", "Plac Grunwaldzki");
        //createAddress(2, "Wrocław", "Legincka 50");

        //usuwa po id
        //deleteAddress(2);

        //update dane gdzie id = x, zamienia city i street
        //updateAddress(1, "Warszawa", "3 Maja");
        selectAddress(1);

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

    private static void updateAddress(int id, String city, String street){
        MyAddress address = entityManager.find(MyAddress.class, id);
        entityManager.getTransaction().begin();
        address.setCity(city);
        address.setStreet(street);
        entityManager.getTransaction().commit();
    }

    private static void selectAddress(int id) {
        MyAddress address = entityManager.find(MyAddress.class, id);
        entityManager.getTransaction().begin();
        System.out.println("id: " + address.getId() + " city: " + address.getCity() + " street: " + address.getStreet());
        entityManager.getTransaction().commit();
    }

}
