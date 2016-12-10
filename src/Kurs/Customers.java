package Kurs;

/**
 * Created by Roma on 10.12.2016.
 */
public class Customers {
    String id;
    String nameCustomer;
    String phoneCust;

    public Customers(String id, String nameCustomer, String phoneCust) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.phoneCust = phoneCust;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneCust() {
        return phoneCust;
    }

    public void setPhoneCust(String phoneCust) {
        this.phoneCust = phoneCust;
    }
}
