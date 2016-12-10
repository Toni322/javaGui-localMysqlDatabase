package Kurs;

import javax.swing.*;

/**
 * Created by Roma on 08.12.2016.
 */
public class AddOrderForm extends JFrame{
    private JPanel rootpanel;
    private JTextField textField1;
    private JTextField textField2;

    public AddOrderForm(){
       super("Hello, its me");
       this.setSize(300,230);
       setContentPane(rootpanel);
       //    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setResizable(false);
       this.setLocationRelativeTo(null);
   }
}
