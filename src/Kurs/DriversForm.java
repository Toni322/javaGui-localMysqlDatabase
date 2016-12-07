package Kurs;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Roma on 07.12.2016.
 */
public class DriversForm extends JFrame {
    private JPanel rootpanel;
    private JList listDrivers;
    private JButton buttonShowDivers;
    private JButton button2;
    private JButton button3;
    private JTable tableDrivers;

   // DefaultListModel model;
    TableModel tableModel;
    SQLDataBase sqlDataBase;

    public DriversForm(){
        super("Hello, its me");
        this.setSize(700,300);
        setContentPane(rootpanel);
    //    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
       // this.setResizable(false);

      //  model =new DefaultListModel();
      //  listDrivers.setModel(model);

        sqlDataBase = new SQLDataBase();

        ArrayList<DriversCars> drivers = sqlDataBase.SQLReadDrivers();
        tableModel = new MyTableModel(drivers);
        tableDrivers.setModel(tableModel);

      //  showDrivers();


        buttonShowDivers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // showDrivers();

            }
        });
    }


    private void showDrivers(){
     //   model.clear();
//        ArrayList<String> table =sqlDataBase.SQLReadDrivers();
//        for (String row : table) {
//            model.addElement(row);
//        }



    }

}
