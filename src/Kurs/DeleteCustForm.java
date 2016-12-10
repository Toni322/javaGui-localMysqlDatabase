package Kurs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Roma on 10.12.2016.
 */
public class DeleteCustForm extends CustomerForm {
    private JPanel rootpanel;
    private JButton buttonDelete;
    private JTextField textFieldDeleteId;

    SQLDataBase sqlDataBase;

    public DeleteCustForm(){
        this.setSize(250,100);
        setContentPane(rootpanel);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        sqlDataBase = new SQLDataBase();

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCust();
            }
        });
    }

        private void deleteCust(){
            String id = textFieldDeleteId.getText().toString();
            sqlDataBase.SQLDeleteCust(id);
            textFieldDeleteId.setText("");
        }

}
