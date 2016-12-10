package Kurs;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TableModelOrders implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Orders> ordersList;

    public TableModelOrders(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 8;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "id";
            case 1:
                return "Start";
            case 2:
                return "Finish";
            case 3:
                return "Price";
            case 4:
                return "NameCust";
            case 5:
                return "NameDriv";
            case 6:
                return "NameProd";
            case 7:
                return "Weight";
        }
        return "";
    }

    public int getRowCount() {
        return ordersList.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Orders ordersList = this.ordersList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ordersList.getId();
            case 1:
                return ordersList.getStart_address();
            case 2:
                return ordersList.getFinish_address();
            case 3:
                return ordersList.getPrice();
            case 4:
                return ordersList.getName_cust();
            case 5:
                return ordersList.getName_driv();
            case 6:
                return ordersList.getName_prod();
            case 7:
                return ordersList.getWeight();
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