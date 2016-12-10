package Kurs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Roma on 08.12.2016.
 */
public class DeleteDriverForm extends  JFrame{
    private JPanel rootpanel;
    private JTextField textFieldDeleteId;
    private JButton deleteButton;

    SQLDataBase sqlDataBase;
    String id;

    public DeleteDriverForm(){
        super("Delete driver");
        this.setSize(250,100);
        setContentPane(rootpanel);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        sqlDataBase = new SQLDataBase();

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFomDrivers();
            }
        });

    }

    private void deleteFomDrivers(){
        id = textFieldDeleteId.getText().toString();
        sqlDataBase.SQLDeleteDriver(id);
    }

}
