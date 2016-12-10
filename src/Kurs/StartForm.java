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
    private JButton buttonDeleteOrder;
    private JTable tableOrders;
    private JButton buttonShowCustomers;
    private JButton buttonAddOrders;

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
        showOrdersTable();


        buttonShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            showOrdersTable();
            }
        });

        buttonShowCustomers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerForm customerForm = new CustomerForm();
            }
        });

        buttonShowDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriversForm driversForm = new DriversForm();
            }
        });

        buttonAddOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddOrderForm addOrderForm = new AddOrderForm();
            }
        });

        buttonDeleteOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteOrderForm deleteOrderForm = new DeleteOrderForm();
            }
        });
    }


    private void showOrdersTable(){
        ArrayList<Orders> ordersArrayList = sqlDataBase.SQLReadOrders();
        tableModel = new TableModelOrders(ordersArrayList);
        tableOrders.setModel(tableModel);

        tableOrders.getColumnModel().getColumn(0).setPreferredWidth(3);
        tableOrders.getColumnModel().getColumn(3).setPreferredWidth(7);
        tableOrders.getColumnModel().getColumn(5).setPreferredWidth(3);
        tableOrders.getColumnModel().getColumn(7).setPreferredWidth(5);
    }

    public static void  main(String[] args) {
        StartForm startForm = new StartForm();
    }

}
