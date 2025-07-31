import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Listado_cursos {
    private JPanel Panel1;
    private JTable table1;
    private JComboBox Escuelacombo;
    private JButton cerrarButton;
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultComboBoxModel combo = new DefaultComboBoxModel();
    private String[] Relleno = new String[]{"Nombre","Descripcion"};
    private String Institucion;
    private Connection con;
    private Statement Statement;
    private int numerorow;
    private int numerocolum;
    private String SelectNombre;
    private String SelectDescripcion;

    private String idcurso;

    public Listado_cursos(){

        Conexion();
        selectfilter();
        Select();
        selectcombo();
        JFrame frame = new JFrame();
        frame.setContentPane(Panel1);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        Escuelacombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectfilter();
                Select();
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                numerorow = table1.getSelectedRow();
                numerocolum = table1.getSelectedColumn();
                int cantidad = table1.getRowCount();
                System.out.println("seleccionaste "+dtm.getValueAt(numerorow,numerocolum));
                SelectNombre = (String) dtm.getValueAt(numerorow,0);
                SelectDescripcion =(String) dtm.getValueAt(numerorow,1);

                //hh.out.println("row nombre" +selectorrows.get(0));
                update();



            }
        });
        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {



                if(e.getType() == TableModelEvent.UPDATE ){
                    int fila = e.getFirstRow();
                    int columna = e.getColumn();
                    System.out.println("row: "+numerorow+"colum: "+numerocolum);
                    if(fila>=0&&columna>=0){
                        Object valor = dtm.getValueAt(fila,columna);
                        System.out.println("se actualizo el valor de la fila "+fila+"columna"+":"+valor);
                        SelectNombre = (String) dtm.getValueAt(numerorow,0);
                        SelectDescripcion =(String) dtm.getValueAt(numerorow,1);


                        update();

                    }
                }


            }
        });


        table1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                e.consume();// evita el salto de linea al consumir evento predeterminado
                char c = e.getKeyChar();
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println("presionaste enter");

                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectDescripcion =(String) dtm.getValueAt(numerorow,1);

                    update();
                }
                else if(e.getKeyCode() == KeyEvent.VK_TAB){
                    System.out.println("presionaste tab");
                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectDescripcion =(String) dtm.getValueAt(numerorow,1);

                    update();
                    int fila= table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    if (columna<table1.getColumnCount()-1){
                        table1.setRowSelectionInterval(fila,fila);
                        table1.setColumnSelectionInterval(columna+1,columna+1);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    System.out.println("presionaste left");
                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectDescripcion =(String) dtm.getValueAt(numerorow,1);

                    update();
                    int fila= table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    if (columna>0){
                        table1.setRowSelectionInterval(fila,fila);
                        table1.setColumnSelectionInterval(columna-1,columna-1);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    System.out.println("presionaste right");
                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectDescripcion =(String) dtm.getValueAt(numerorow,1);

                    update();
                    int fila= table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    if (columna<table1.getColumnCount()-1){
                        table1.setRowSelectionInterval(fila,fila);
                        table1.setColumnSelectionInterval(columna+1,columna+1);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_UP){
                    System.out.println("presionaste up");
                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectDescripcion =(String) dtm.getValueAt(numerorow,1);

                    update();
                    int fila= table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    System.out.println("la fila es"+fila);
                    if (fila>0){
                        table1.setRowSelectionInterval(fila-1,fila-1);
                        table1.setColumnSelectionInterval(columna,columna);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    int fila= table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    System.out.println("presionaste down");
                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectDescripcion =(String) dtm.getValueAt(numerorow,1);

                    update();
                    fila= table1.getSelectedRow();
                    columna = table1.getSelectedColumn();
                    if (fila<table1.getRowCount()-1){
                        table1.setRowSelectionInterval(fila+1,fila+1);
                        table1.setColumnSelectionInterval(columna,columna);
                    }

                }
                else if(e.getKeyCode() == KeyEvent.VK_DELETE){
                    e.consume();
                    int respuesta = JOptionPane.showConfirmDialog(null,"¿Estas seguro que deseas eliminar la fila");

                    if(respuesta == JOptionPane.OK_OPTION){
                        System.out.println("presionaste suprimir");
                        int fila= table1.getSelectedRow();
                        int columna = table1.getSelectedColumn();
                        if (fila>0){
                            if (dtm.getRowCount()>1){
                                table1.setRowSelectionInterval(fila-1,fila-1);
                                table1.setColumnSelectionInterval(columna,columna);}

                        }
                        else if(fila == dtm.getRowCount()){
                            System.out.println("iguales");
                        }


                        SelectNombre = (String) dtm.getValueAt(numerorow,0);
                        SelectDescripcion =(String) dtm.getValueAt(numerorow,1);

                        update();
                        update_delete();

                        numerorow--;
                        dtm.removeRow(fila);
                        fila= table1.getSelectedRow();
                        columna = table1.getSelectedColumn();
                    }
                    else{
                        System.out.println("contiamos");
                    }




                }

            }

        });
        table1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c= e.getKeyChar();
                if(Character.isLetterOrDigit(c)){
                    int fila =table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    if(fila>=0 && columna >=0){
                        table1.editCellAt(fila,columna);
                        SwingUtilities.invokeLater(()-> {
                            Component editor = table1.getEditorComponent();
                            if(editor instanceof JTextComponent){
                                ((JTextComponent)editor).setText("");
                                ((JTextComponent)editor).requestFocus();
                                ((JTextComponent)editor).setCaretPosition(0);
                                ((JTextComponent)editor).setText(String.valueOf(c));
                                ((JTextComponent)editor).setCaretPosition(1);
                            }
                        });
                    }
                }
            }
        });
    }


    public void Conexion(){
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/escuela";
        String user = "root";
        String pass = "";

        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(url,user,pass);
            if(!con.isClosed()){
                System.out.println("exito");

            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Select(){

        if (table1.getRowCount()>0){
            dtm.setRowCount(0);
        }
        String mysqlprod = "select a.Nombre,a.Descripcion from cursos a inner join institucion b on a.id_institucion = b.id_institucion  where a.id_ciclo > 0 && b.id_institucion = '"+ Institucion+"' && a.Visible = 1";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(mysqlprod);
            rs = ps.executeQuery();
            ResultSetMetaData resul = rs.getMetaData();
            int cantidad_columnas = resul.getColumnCount();
            dtm.setColumnIdentifiers(Relleno);
            while(rs.next()){
                Object [] filas = new Object[cantidad_columnas];
                for (int i = 0 ;i<cantidad_columnas;i++){
                    filas[i] = rs.getObject(i+1);
                }
                dtm.addRow(filas);
            }
            table1.setModel(dtm);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void selectcombo(){
        String mysqlprod = "select Nombre from institucion where Visible = 1";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(mysqlprod);
            rs = ps.executeQuery();
            ResultSetMetaData resul = rs.getMetaData();
            while(rs.next()){
                    combo.addElement(rs.getString(1));

                }
            Escuelacombo.setModel(combo);
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void selectfilter(){
        String mysqlprod = "select id_institucion from institucion where Nombre = '" + Escuelacombo.getSelectedItem()+"'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(mysqlprod);
            rs = ps.executeQuery();
            ResultSetMetaData resul = rs.getMetaData();
            while(rs.next()){
                Institucion = rs.getString(1);
                System.out.println(Institucion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void select_updatte() {
        String sqlprod = "select id_cursos from cursos where Nombre = '" + SelectNombre + "'&& Descripcion = '" + SelectDescripcion+ "'";

        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;

        try {
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            while (rs.next()) {
                idcurso = rs.getString(1);
                // System.out.println("select: " + idestudiante);
                // }

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void update(){
        select_updatte();

        try{
            PreparedStatement ps = null;

            ps = con.prepareStatement("UPDATE cursos SET Nombre = ?,Descripcion = ? where id_cursos ='"+idcurso+"'");
            String valor = (String) dtm.getValueAt(numerorow,numerocolum);

            System.out.println("updaterow: "+numerorow+"updtcolum"+numerocolum);
            ps.setString(1,SelectNombre);
            ps.setString(2,SelectDescripcion);

            ps.executeUpdate();
            update_delete(); //preuba

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void update_delete(){

        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("UPDATE cursos SET Visible = ? where id_cursos ='"+idcurso+"'");
            ps.setInt(1,0);
            ps.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}



