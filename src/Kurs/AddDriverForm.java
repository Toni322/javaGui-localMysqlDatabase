package Kurs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Roma on 08.12.2016.
 */
public class AddDriverForm extends JFrame {
    private JPanel rootpanel;
    private JTextField textFieldDriveName;
    private JTextField textFieldPhone;
    private JTextField textFieldExp;
    private JTextField textFieldModel;
    private JTextField textFieldCarNumb;
    private JTextField textFieldColor;

    private JButton buttonAddDriv;

    String name;
    String phone;
    String exp;
    String model;
    String carNumb;
    String color;

    SQLDataBase sqlDataBase;

    public AddDriverForm(){

        super("Add new driver");
        this.setSize(300,230);
        setContentPane(rootpanel);
        this.setVisible(true);
         this.setResizable(false);
        this.setLocationRelativeTo(null);

        sqlDataBase = new SQLDataBase();



    buttonAddDriv.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            addNewDriver();
        }
    });



    }

    public void addNewDriver(){
        name = textFieldDriveName.getText().toString();
        phone = textFieldPhone.getText().toString();
        exp = textFieldExp.getText().toString();
        model = textFieldModel.getText().toString();
        carNumb = textFieldCarNumb.getText().toString();
        color = textFieldColor.getText().toString();

        sqlDataBase.SQLAddNewDriver(name,phone,exp,model,carNumb,color);
    }


}
