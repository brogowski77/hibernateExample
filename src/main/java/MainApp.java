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
        //    deleteCustomer(1);
        //update dane gdzie id = x, zamienia city i street
        //updateAddress(1, "Warszawa", "3 Maja");
        //selectAddress(1);
        //createAddress(4, "Wrocław", "Legincka 50");
        //createCustomer("Adam", "Mickiewicz", "poeta");

        MyAddress address1 = new MyAddress();
        MyAddress address2 = new MyAddress();
        address1.setStreet("ul. Mickiewicza");
        address2.setStreet("ul. Słowackiego");
        address1.setCity("Wieś Warszawa");
        address2.setCity("Stolica Polski Poznań");

        MyCustomer customer1 = new MyCustomer();
        customer1.setFirstname("Pan");
        customer1.setLastname("Tadeusz");
        customer1.setJob("Ziomek");
        customer1.setMyAddress(address1);
        MyCustomer customer2 = new MyCustomer();
        customer2.setFirstname("Jan");
        customer2.setLastname("Tadeusz");
        customer2.setJob("Ziomek");
        customer2.setMyAddress(address1);
        MyCustomer customer3 = new MyCustomer();
        customer3.setFirstname("Sran");
        customer3.setLastname("Tadeusz");
        customer3.setJob("Ziomek");
        customer3.setMyAddress(address2);


        entityManager.getTransaction().begin();
        entityManager.persist(address1);
        entityManager.persist(address2);
        entityManager.persist(customer1);
        entityManager.persist(customer2);
        entityManager.persist(customer3);

        entityManager.getTransaction().commit();




        entityManager.close();
        entityManagerFactory.close();

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

 /*   private static void createCustomer(String firstname, String lastname, String job, MyAddress address) {
        entityManager.getTransaction().begin();
        MyCustomer customer = new MyCustomer(firstname, lastname, address);
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

    }*/

    private static void deleteCustomer(int id) {
        MyCustomer customer = entityManager.find(MyCustomer.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(customer);
        entityManager.getTransaction().commit();

    }

}
