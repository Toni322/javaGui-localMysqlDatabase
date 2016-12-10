package Kurs;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TableModelDrivers implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<DriversCars> driversCarss;

    public TableModelDrivers(List<DriversCars> driversCarss) {
        this.driversCarss = driversCarss;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 7;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Driver name";
            case 2:
                return "Phone number";
            case 3:
                return "Driving experience";
            case 4:
                return "Car Model";
            case 5:
                return "Car number";
            case 6:
                return "Color";
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
                return driversCars.getId();
            case 1:
                return driversCars.getName_driv();
            case 2:
                return driversCars.getPhone_number();
            case 3:
                return driversCars.getDriving_experience();
            case 4:
                return driversCars.getModel();
            case 5:
                return driversCars.getCar_number();
            case 6:
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