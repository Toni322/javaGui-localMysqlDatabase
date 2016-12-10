package Kurs;
import java.sql.*;
import java.util.ArrayList;
/**
 * Created by Roma on 03.12.2016.
 */
public class SQLDataBase {

    public ArrayList<DriversCars> SQLReadDrivers(){
        try {
            // спробувати завантажити драйвер
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // у випадку невдачі, друкуємо інформацію про виключну ситуацію
            ex.printStackTrace();
            System.out.println("Loh");
        }
        // формуємо адресу БД
        String url = "jdbc:mysql://localhost:3306/kursova";
        String login = "root";
        String passwd = "1488";


        try {
            // з’єднуємося із сервером БД
            Connection conn =
                    DriverManager.getConnection(url, login, passwd);
            System.out.println("Connection established.");
 /* виконуємо запити до БД */
            try {
                // Створюємо об’єкт Statement
                Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                // виконуємо запит до сервера
                ResultSet res = stm.executeQuery("select drivers.id, name_driv, phone_number, driving_experience, model, car_number, color from drivers left join cars on car_id = cars.id \n");


                // обробляємо отримані результати
                ArrayList<DriversCars> table = new ArrayList<DriversCars>();

                while (res.next()) {
                    String id = res.getString("id");
                    String name_driv = res.getString("name_driv");
                    String phone_number = res.getString("phone_number");
                    String driving_experience = res.getString("driving_experience");
                    String model = res.getString("model");
                    String car_number = res.getString("car_number");
                    String color = res.getString("color");

                    table.add(new DriversCars(id,name_driv,phone_number,driving_experience,model,car_number,color));

                }

                // видаляємо об’єкт Statement
                stm.close();
                return  table;



            } catch (SQLException ex) {
                // виводимо інформацію про виключну ситуацію
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }

            // завершуємо сеанс роботи з БД
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ArrayList<Orders> SQLReadOrders(){
        try {
            // спробувати завантажити драйвер
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // у випадку невдачі, друкуємо інформацію про виключну ситуацію
            ex.printStackTrace();
            System.out.println("Loh");
        }
        // формуємо адресу БД
        String url = "jdbc:mysql://localhost:3306/kursova";
        String login = "root";
        String passwd = "1488";


        try {
            // з’єднуємося із сервером БД
            Connection conn =
                    DriverManager.getConnection(url, login, passwd);
            System.out.println("Connection established.");
 /* виконуємо запити до БД */
            try {
                // Створюємо об’єкт Statement
                Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                // виконуємо запит до сервера
                ResultSet res = stm.executeQuery("select orders.id, start_address, finish_address, price, name_cust, name_driv, name_prod, weight from orders " +
                        "left join custumers on customer_id = custumers.id " +
                        "left join drivers on driver_id = drivers.id " +
                        "left join products on products.orders_id = orders.id ");


                // обробляємо отримані результати
                //  ArrayList<String> table = new ArrayList<String>();

                ArrayList<Orders> table = new ArrayList<Orders>();

                while (res.next()) {
                    String id = res.getString("id");
                    String start_address = res.getString("start_address");
                    String finish_address = res.getString("finish_address");
                    String price = res.getString("price");
                    String name_cust = res.getString("name_cust");
                    String name_driv = res.getString("name_driv");
                    String name_prod = res.getString("name_prod");
                    String weight = res.getString("weight");

                    table.add(new Orders(id,start_address,finish_address,price,name_cust,name_driv,name_prod,weight));
                //    table.add(new DriversCars(name_driv,phone_number,driving_experience,model,car_number,color));

                }

                // видаляємо об’єкт Statement
                stm.close();
                return  table;



            } catch (SQLException ex) {
                // виводимо інформацію про виключну ситуацію
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }

            // завершуємо сеанс роботи з БД
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public void SQLAddNewDriver(String name_driv, String phone_number, String driving_experience, String model, String car_number, String color){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Loh");
        }
        String url = "jdbc:mysql://localhost:3306/kursova";
        String login = "root";
        String passwd = "1488";
        try {
            Connection conn = DriverManager.getConnection(url, login, passwd);
            System.out.println("Connection established. Write");
            try {
                Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                stm.executeUpdate ("call add_driv('"+name_driv+"','"+phone_number+"','"+
                        driving_experience+"','"+model+"','"+car_number+"','"+color+"');");
                stm.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void SQLDeleteDriver(String idDriv){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Loh");
        }
        String url = "jdbc:mysql://localhost:3306/kursova";
        String login = "root";
        String passwd = "1488";
        try {
            Connection conn = DriverManager.getConnection(url, login, passwd);
            System.out.println("Connection established. Delete");
            try {
                Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                stm.executeUpdate ("delete from drivers where id = '"+idDriv+"';");
                stm.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Customers> SQLReadCustomers(){
        try {
            // спробувати завантажити драйвер
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // у випадку невдачі, друкуємо інформацію про виключну ситуацію
            ex.printStackTrace();
            System.out.println("Loh");
        }
        // формуємо адресу БД
        String url = "jdbc:mysql://localhost:3306/kursova";
        String login = "root";
        String passwd = "1488";


        try {
            // з’єднуємося із сервером БД
            Connection conn =
                    DriverManager.getConnection(url, login, passwd);
            System.out.println("Connection established.");
 /* виконуємо запити до БД */
            try {
                // Створюємо об’єкт Statement
                Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                // виконуємо запит до сервера
                ResultSet res = stm.executeQuery("SELECT * FROM custumers");


                // обробляємо отримані результати
                ArrayList<Customers> table = new ArrayList<Customers>();

                while (res.next()) {
                    String id = res.getString("id");
                    String name_cust = res.getString("name_cust");
                    String phone_number = res.getString("phone_number");


                    table.add(new Customers(id,name_cust,phone_number));

                }

                // видаляємо об’єкт Statement
                stm.close();
                return  table;



            } catch (SQLException ex) {
                // виводимо інформацію про виключну ситуацію
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }

            // завершуємо сеанс роботи з БД
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void SQLAddNewCust(String name_cust, String phone_number){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/kursova";
        String login = "root";
        String passwd = "1488";
        try {
            Connection conn = DriverManager.getConnection(url, login, passwd);
            System.out.println("Connection established. Write");
            try {
                Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                stm.executeUpdate ("insert into custumers(name_cust,phone_number) values('"+name_cust+"','"+phone_number+"');");
                stm.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void SQLDeleteCust(String idCust){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Loh");
        }
        String url = "jdbc:mysql://localhost:3306/kursova";
        String login = "root";
        String passwd = "1488";
        try {
            Connection conn = DriverManager.getConnection(url, login, passwd);
            System.out.println("Connection established. Delete");
            try {
                Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                stm.executeUpdate ("delete from custumers where id = '"+idCust+"';");
                stm.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
