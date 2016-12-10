package Kurs;

import javax.swing.*;

/**
 * Created by Roma on 11.12.2016.
 */
public class DeleteOrderForm extends JFrame{
    private JPanel rootpanel;
    private JTextField textField1;
    private JButton deleteButton;

    public DeleteOrderForm(){
        super("Hello, its me");
        this.setSize(280,120);
        setContentPane(rootpanel);
        //    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }
}
