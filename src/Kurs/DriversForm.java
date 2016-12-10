package Kurs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private JButton addDriverButton;
    private JButton buttonDeleteDriver;
    private JTable tableDrivers;


    TableModel tableModel;
    SQLDataBase sqlDataBase;

    public DriversForm(){
        super("Drivers");
        this.setSize(750,300);
        setContentPane(rootpanel);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);



        sqlDataBase = new SQLDataBase();

        showTable();

        buttonShowDivers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           showTable();
            }
        });

    addDriverButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addDrivers();
        }
    });

    buttonDeleteDriver.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            deleteDriver();
        }
    });

    }


    private  void showTable(){
        ArrayList<DriversCars> drivers = sqlDataBase.SQLReadDrivers();
        tableModel = new TableModelDrivers(drivers);
        tableDrivers.setModel(tableModel);
        tableDrivers.getColumnModel().getColumn(0).setPreferredWidth(3);
    }

    private void addDrivers(){
        AddDriverForm addDriver = new AddDriverForm();
    }

    private void deleteDriver(){
        DeleteDriverForm deleteDriverForm = new DeleteDriverForm();
    }

}
