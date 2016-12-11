package Kurs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Roma on 08.12.2016.
 */
public class AddOrderForm extends JFrame{
    private JPanel rootpanel;
    private JTextField textFieldCustId;
    private JTextField textFieldDriverId;
    private JTextField textFieldStartAddress;
    private JTextField textFieldFinishAddress;
    private JTextField textFieldPrice;
    private JTextField textFieldProductName;
    private JTextField textFieldWeight;
    private JButton buttonAddOrd;

    String custId;
    String drivId;
    String startAddr;
    String finishAddr;
    String price;
    String prodName;
    String weight;

    SQLDataBase sqlDataBase;

    public AddOrderForm(){
       super("Add form");
       this.setSize(320,270);
       setContentPane(rootpanel);
       //    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setResizable(false);
       this.setLocationRelativeTo(null);

        sqlDataBase = new SQLDataBase();

        buttonAddOrd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrder();
            }
        });

   }

    private void  addOrder(){
     custId = textFieldCustId.getText().toString();
     drivId = textFieldDriverId.getText().toString();
     startAddr = textFieldStartAddress.getText().toString();
     finishAddr = textFieldFinishAddress.getText().toString();
     price = textFieldPrice.getText().toString();
     prodName = textFieldProductName.getText().toString();
     weight = textFieldWeight.getText().toString();

     sqlDataBase.SQLAddNewOrder(custId,drivId,startAddr,finishAddr,price,prodName,weight);

     textFieldCustId.setText("");
     textFieldDriverId.setText("");
     textFieldStartAddress.setText("");
     textFieldFinishAddress.setText("");
     textFieldPrice.setText("");
     textFieldProductName.setText("");
     textFieldWeight.setText("");

    }

}
