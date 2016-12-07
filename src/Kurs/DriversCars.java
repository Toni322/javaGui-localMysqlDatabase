package Kurs;

public class DriversCars{
    String name_driv;
    String phone_number;
    String driving_experience;
    String model;
    String car_number;
    String color;

    public DriversCars(String name_driv, String phone_number, String driving_experience, String model, String car_number, String color) {
        this.name_driv = name_driv;
        this.phone_number = phone_number;
        this.driving_experience = driving_experience;
        this.model = model;
        this.car_number = car_number;
        this.color = color;
    }

    public String getName_driv() {
        return name_driv;
    }

    public void setName_driv(String name_driv) {
        this.name_driv = name_driv;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDriving_experience() {
        return driving_experience;
    }

    public void setDriving_experience(String driving_experience) {
        this.driving_experience = driving_experience;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}