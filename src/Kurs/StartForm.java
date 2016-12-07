package Kurs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Created by Roma on 03.12.2016.
 */
public class StartForm extends JFrame{
    private JPanel rootpanel;
    private JList list_orders;
    private JButton buttonShow;
    private JButton buttonShowDriver;
    private JButton button1;

    DefaultListModel model;
    SQLDataBase sqlDataBase;

    public StartForm(){

        super("Hello, its me");
        this.setSize(700,300);
        setContentPane(rootpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);


        model =new DefaultListModel();
        list_orders.setModel(model);
        sqlDataBase = new SQLDataBase();

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
