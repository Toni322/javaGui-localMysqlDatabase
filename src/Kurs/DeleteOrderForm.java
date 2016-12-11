package Kurs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Roma on 11.12.2016.
 */
public class DeleteOrderForm extends JFrame{
    private JPanel rootpanel;
    private JTextField textFieldOrdId;
    private JButton deleteButton;
    String id;
    SQLDataBase sqlDataBase;

    public DeleteOrderForm(){
        super("Delete order");
        this.setSize(280,120);
        setContentPane(rootpanel);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        sqlDataBase = new SQLDataBase();

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteOrd();
            }
        });
    }

    private void deleteOrd(){
        id = textFieldOrdId.getText().toString();
        sqlDataBase.SQLDeleteOdrer(id);
        textFieldOrdId.setText("");

    }
}
