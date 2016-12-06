package Kurs;
import java.sql.*;
import java.util.ArrayList;
/**
 * Created by Roma on 03.12.2016.
 */
public class SQLDataBase {

    public ArrayList<String> SQLReadDrivers(){
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
                ResultSet res = stm.executeQuery("select name_driv, phone_number, driving_experience, model, car_number, color from drivers left join cars on car_id = cars.id \n");


                // обробляємо отримані результати
                ArrayList<String> table = new ArrayList<String>();

                while (res.next()) {
                    String name_driv = res.getString("name_driv");
                    String phone_number = res.getString("phone_number");
                    String driving_experience = res.getString("driving_experience");
                    String model = res.getString("model");
                    String car_number = res.getString("car_number");
                    String color = res.getString("color");
                    table.add(name_driv+ ", "+ phone_number+ ", "+ driving_experience+", "+model+ ", "+ color + ", "+ car_number);
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

}
