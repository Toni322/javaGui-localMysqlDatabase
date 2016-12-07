package Kurs;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<DriversCars> driversCarss;

    public MyTableModel(List<DriversCars> driversCarss) {
        this.driversCarss = driversCarss;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 6;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Driver name";
            case 1:
                return "Phone";
            case 2:
                return "Exp";
            case 3:
                return "Model";
            case 4:
                return "CarNum";
            case 5:
                return "Col";
        }
        return "";
    }

    public int getRowCount() {
        return driversCarss.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        DriversCars driversCars = driversCarss.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return driversCars.getName_driv();
            case 1:
                return driversCars.getPhone_number();
            case 2:
                return driversCars.getDriving_experience();
            case 3:
                return driversCars.getModel();
            case 4:
                return driversCars.getCar_number();
            case 5:
                return driversCars.getColor();
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