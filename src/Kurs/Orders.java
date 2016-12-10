package Kurs;

/**
 * Created by Roma on 08.12.2016.
 */
public class Orders {
    String id;
    String start_address;
    String finish_address;
    String price;
    String name_cust;
    String name_driv ;
    String name_prod;
    String weight;

    public Orders(String id, String start_address, String finish_address, String price, String name_cust, String name_driv, String name_prod, String weight) {
        this.id = id;
        this.start_address = start_address;
        this.finish_address = finish_address;
        this.price = price;
        this.name_cust = name_cust;
        this.name_driv = name_driv;
        this.name_prod = name_prod;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStart_address() {
        return start_address;
    }

    public void setStart_address(String start_address) {
        this.start_address = start_address;
    }

    public String getFinish_address() {
        return finish_address;
    }

    public void setFinish_address(String finish_address) {
        this.finish_address = finish_address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName_cust() {
        return name_cust;
    }

    public void setName_cust(String name_cust) {
        this.name_cust = name_cust;
    }

    public String getName_driv() {
        return name_driv;
    }

    public void setName_driv(String name_driv) {
        this.name_driv = name_driv;
    }

    public String getName_prod() {
        return name_prod;
    }

    public void setName_prod(String name_prod) {
        this.name_prod = name_prod;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
