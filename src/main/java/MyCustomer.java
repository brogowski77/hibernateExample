/**
 * Created by RENT on 2017-02-02.
 */

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class MyCustomer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "job")
    private String job;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private MyAddress myAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public MyAddress getMyAddress() {
        return myAddress;
    }

    public void setMyAddress(MyAddress myAddress) {
        this.myAddress = myAddress;
    }

    public MyCustomer(String firstname, String lastname, String job, MyAddress myAddress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.job = job;
        this.myAddress = myAddress;
    }

    public MyCustomer() {
    }

    @Override
    public String toString() {
        return "MyCustomer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", job='" + job + '\'' +
                ", myAddress=" + myAddress +
                '}';
    }
}
