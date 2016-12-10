package Kurs;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Created by Roma on 03.12.2016.
 */
public class StartForm extends JFrame{
    private JPanel rootpanel;
    private JButton buttonShow;
    private JButton buttonShowDriver;
    private JButton button1;
    private JTable tableOrders;
    private JButton button2;

    // DefaultListModel model;
   TableModel tableModel;

    SQLDataBase sqlDataBase;

    public StartForm(){

        super("Orders");
        this.setSize(900,300);
        setContentPane(rootpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);



        sqlDataBase = new SQLDataBase();
        ArrayList<Orders> ordersArrayList = sqlDataBase.SQLReadOrders();
        tableModel = new TableModelOrders(ordersArrayList);
        tableOrders.setModel(tableModel);
        tableOrders.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        tableOrders.getColumnModel().getColumn(0).setPreferredWidth(3);
        tableOrders.getColumnModel().getColumn(3).setPreferredWidth(7);
        tableOrders.getColumnModel().getColumn(5).setPreferredWidth(3);
        tableOrders.getColumnModel().getColumn(7).setPreferredWidth(5);


        buttonShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });



        buttonShowDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriversForm driversForm = new DriversForm();

            }
        });

    }





}
