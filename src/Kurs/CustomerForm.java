package Kurs;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Roma on 10.12.2016.
 */
public class CustomerForm extends JFrame{
    private JPanel rootpanel;
    private JTable tableCustomers;
    private JButton buttonAdd;
    private JButton buttonDeleteCust;
    private JButton buttonShowTableCust;

    TableModel tableModel;

    SQLDataBase sqlDataBase;

    public CustomerForm(){
        super("Customers");
        this.setSize(300,300);
        setContentPane(rootpanel);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        sqlDataBase = new SQLDataBase();

        showTableCust();

        buttonShowTableCust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTableCust();
            }
        });


        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCustForm addCustForm = new AddCustForm();
            }
        });

        buttonDeleteCust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteCustForm deleteCustForm = new DeleteCustForm();
            }
        });
    }

    private void showTableCust(){
        ArrayList<Customers> customesArrayList = sqlDataBase.SQLReadCustomers();
        tableModel = new TableModelCustomers(customesArrayList);
        tableCustomers.setModel(tableModel);
        tableCustomers.getColumnModel().getColumn(0).setPreferredWidth(3);

    }

}
