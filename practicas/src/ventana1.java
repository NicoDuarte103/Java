import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana1 {
    private JButton cobrarButton;
    private JTable table1;
    private JComboBox producto;
    private JComboBox Iva;
    private JComboBox cajero1;
    private JTextField textField1;
    private JButton inventarioButton;
    private JButton eliminarItemButton;
    private JButton imprimirTicketButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton buscarButton;
    private JButton imprimirPdfButton;
    private JComboBox comboBox1;
    private JButton transaccionesButton;
    private JPanel panel1;
    private JButton agregarButton;

    DefaultTableModel dtm = new DefaultTableModel();
    String [] titulo = new String[]{"Nombre","Marca","Unidades","P.unit","Descuento","P.total"};


    public ventana1() {

        JFrame frame = new JFrame("ventana_uno");
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        dtm.setColumnIdentifiers(titulo);
        table1.setModel(dtm);
        Mercaderia mercaderia = new Mercaderia(0);
        for (int i = 0; i<mercaderia.Lista_mercaderia.size();i++){

            dtm.addRow(new Object[]{mercaderia.Lista_mercaderia.get(i).getNombre(),mercaderia.Lista_mercaderia.get(i).getMarca(),mercaderia.Lista_mercaderia.get(i).getCantidad(),mercaderia.Lista_mercaderia.get(i).getPrecio_unitario(),mercaderia.Lista_mercaderia.get(i).getPrecio_total(),mercaderia.Lista_mercaderia.get(i).getDescuento()});}
        cobrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                dtm.addRow(new Object[]{mercaderia.Lista_mercaderia.get(i).getNombre(),mercaderia.Lista_mercaderia.get(i).getMarca(),mercaderia.Lista_mercaderia.get(i).getCantidad(),mercaderia.Lista_mercaderia.get(i).getPrecio_unitario(),mercaderia.Lista_mercaderia.get(i).getPrecio_total(),mercaderia.Lista_mercaderia.get(i).getDescuento()});


        }
        });
    }
}
