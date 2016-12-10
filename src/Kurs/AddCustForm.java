package Kurs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Roma on 10.12.2016.
 */
public class AddCustForm extends CustomerForm{
    private JPanel rootpanel;
    private JTextField textFieldNameCaust;
    private JTextField textFieldPhoneNumb;
    private JButton buttonAddCust;
    String nameCust;
    String phoneNumb;

    SQLDataBase sqlDataBase;

    public AddCustForm(){
        this.setSize(280,120);
        setContentPane(rootpanel);

        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        sqlDataBase = new SQLDataBase();

        buttonAddCust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewCust();
            }
        });

    }

    private void addNewCust(){
         nameCust = textFieldNameCaust.getText().toString();
         phoneNumb = textFieldPhoneNumb.getText().toString();
         sqlDataBase.SQLAddNewCust(nameCust,phoneNumb);
        textFieldNameCaust.setText("");
        textFieldPhoneNumb.setText("");
    }
}
