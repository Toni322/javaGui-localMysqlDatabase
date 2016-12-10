package Kurs;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TableModelCustomers implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Customers> customerss;

    public TableModelCustomers(List<Customers> customerss) {

        this.customerss = customerss;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 3;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Customer name";
            case 2:
                return "Phone number";


        }
        return "";
    }

    public int getRowCount() {
        return customerss.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
      Customers customers = customerss.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return customers.getId();
            case 1:
                return customers.getNameCustomer();
            case 2:
                return customers.getPhoneCust();

        }
        return "";
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }
}