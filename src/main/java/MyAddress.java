/**
 * Created by RENT on 2017-02-01.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class MyAddress {


    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public MyAddress(int id, String city, String street) {
        super();
        this.id = id;
        this.city = city;
        this.street = street;
    }

    public MyAddress() {
        super();
    }

    @Override
    public String toString() {
        return "myAddress [id=" + id + ", city=" + city + ", street=" + street + "]";
    }


}
