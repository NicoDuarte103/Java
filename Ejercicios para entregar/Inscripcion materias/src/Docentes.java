import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class Docentes {
    private JTextField NombreDocente;
    private JTextField ApellidoDocente;
    private JTextField DniDocente;
    private JCheckBox lunesCheckBox;
    private JCheckBox martesCheckBox;
    private JCheckBox miercolesCheckBox;
    private JCheckBox juevesCheckBox;
    private JCheckBox viernesCheckBox;
    private JCheckBox sabadoCheckBox;
    private JCheckBox domingoCheckBox;
    private JComboBox HorarioInicio;
    private JComboBox HorarioFin;
    private JComboBox comboBoxCursos;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel PanelDocente;
    private JLabel Resultado;
    private JTextField Fecha_Nacimiento;
    private JTextField Domicilio;
    private JTextField Telefono;
    private JTextField Email;
    private JTextField Localidad;
    private JTextField Nacionalidad;
    private JComboBox Institucion;
    private JComboBox cicloLectivo;
    private Connection con;
    private Statement statement;
    //private DefaultComboBoxModel comboCursos = new DefaultComboBoxModel<>();
    //private DefaultComboBoxModel comboinstitucion = new DefaultComboBoxModel<>();
    private int id_cursos;
    private ArrayList <Object> Listado = new ArrayList <>();
    private ArrayList <Object> ListadoString = new ArrayList <>();
    private DefaultComboBoxModel combo = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel comboinst = new DefaultComboBoxModel();
    private DefaultComboBoxModel combociclo = new DefaultComboBoxModel();
    private String Item;
    private int indexciclo;

    private String seleccioncursos;
    private int seleccionciclo;
    private String seleccioninstitucion;


    public Docentes(){


        Conexion();
        selectciclo();
        selectinsti();
        select();


        select_insert_institucion();


        //SeleccionCursos.setModel(comboCursos);

        DefaultComboBoxModel comboHorarios = new DefaultComboBoxModel<>();
        comboHorarios.addElement("8:00");
        comboHorarios.addElement("8:30");
        comboHorarios.addElement("9:00");
        comboHorarios.addElement("9:30");
        comboHorarios.addElement("10:00");
        comboHorarios.addElement("10:30");
        comboHorarios.addElement("11:00");
        comboHorarios.addElement("11:30");
        comboHorarios.addElement("12:00");
        comboHorarios.addElement("12:30");
        comboHorarios.addElement("13:00");
        comboHorarios.addElement("13:30");
        comboHorarios.addElement("14:00");
        comboHorarios.addElement("14:00");
        comboHorarios.addElement("14:30");
        comboHorarios.addElement("15:00");
        comboHorarios.addElement("15:30");
        comboHorarios.addElement("16:00");
        comboHorarios.addElement("16:30");
        comboHorarios.addElement("17:00");
        comboHorarios.addElement("17:30");
        comboHorarios.addElement("18:00");
        comboHorarios.addElement("18:30");
        comboHorarios.addElement("19:00");
        comboHorarios.addElement("19:30");
        comboHorarios.addElement("20:00");
        comboHorarios.addElement("20:30");
        comboHorarios.addElement("21:00");
        comboHorarios.addElement("21:30");
        comboHorarios.addElement("22:00");

        DefaultComboBoxModel comboHorarios2= new DefaultComboBoxModel<>();
        comboHorarios2.addElement("8:00");
        comboHorarios2.addElement("8:30");
        comboHorarios2.addElement("9:00");
        comboHorarios2.addElement("9:30");
        comboHorarios2.addElement("10:00");
        comboHorarios2.addElement("10:30");
        comboHorarios2.addElement("11:00");
        comboHorarios2.addElement("11:30");
        comboHorarios2.addElement("12:00");
        comboHorarios2.addElement("12:30");
        comboHorarios2.addElement("13:00");
        comboHorarios2.addElement("13:30");
        comboHorarios2.addElement("14:00");
        comboHorarios2.addElement("14:00");
        comboHorarios2.addElement("14:30");
        comboHorarios2.addElement("15:00");
        comboHorarios2.addElement("15:30");
        comboHorarios2.addElement("16:00");
        comboHorarios2.addElement("16:30");
        comboHorarios2.addElement("17:00");
        comboHorarios2.addElement("17:30");
        comboHorarios2.addElement("18:00");
        comboHorarios2.addElement("18:30");
        comboHorarios2.addElement("19:00");
        comboHorarios2.addElement("19:30");
        comboHorarios2.addElement("20:00");
        comboHorarios2.addElement("20:30");
        comboHorarios2.addElement("21:00");
        comboHorarios2.addElement("21:30");
        comboHorarios2.addElement("22:00");

        HorarioInicio.setModel(comboHorarios);
        HorarioFin.setModel(comboHorarios2);

        Listado.add(0);
        Listado.add(0);
        Listado.add(0);
        Listado.add(0);
        Listado.add(0);
        Listado.add(0);
        Listado.add(0);
        ListadoString.add("");
        ListadoString.add("");
        ListadoString.add("");
        ListadoString.add("");
        ListadoString.add("");
        ListadoString.add("");
        ListadoString.add("");







        JFrame frame = new JFrame("Inscripcion Docentes");
        frame.setContentPane(PanelDocente);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int NombreTamanio = NombreDocente.getText().length();
                int ApellidoTamanio = ApellidoDocente.getText().length();
                int DniTamanio = DniDocente.getText().length();
                if ((NombreTamanio>1 && ApellidoTamanio >1)&&DniTamanio==8){
                    Resultado.setForeground(Color.GREEN);
                    Resultado.setText("Inscripcion Exitosa");

                }
                else {
                    Resultado.setForeground(Color.RED);
                    Resultado.setText("Error");

                }


            }
        });
        lunesCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lunesCheckBox.isSelected()){
                    System.out.println("Lunes"); //hacer un pdf con palomita o x
                    Listado.set(0,1);}
                else {
                    Listado.set(0,0);
                }
                System.out.println(Listado);
            }
        });
        martesCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(martesCheckBox.isSelected()){
                    System.out.println("Martes"); //hacer un pdf con palomita o x
                    Listado.set(1,2);}
                else {
                    Listado.set(1,0);
                }
                System.out.println(Listado);
            }
        });
        miercolesCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(miercolesCheckBox.isSelected()){
                    System.out.println("Miercoles"); //hacer un pdf con palomita o x
                    Listado.set(2,3);}
                else {
                    Listado.set(2,0);
                }
                System.out.println(Listado);
            }
        });
        juevesCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(juevesCheckBox.isSelected()){
                    System.out.println("Jueves"); //hacer un pdf con palomita o x
                    Listado.set(3,4);}
                else {
                    Listado.set(3,0);
                }
                System.out.println(Listado);
            }
        });
        viernesCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(viernesCheckBox.isSelected()){
                    System.out.println("Viernes"); //hacer un pdf con palomita o x
                    Listado.set(4,5);}
                else {
                    Listado.set(4,0);
                }
                System.out.println(Listado);
            }
        });
        sabadoCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sabadoCheckBox.isSelected()){
                    System.out.println("Sabado"); //hacer un pdf con palomita o x
                    Listado.set(5,6);}
                else {
                    Listado.set(5,0);
                }
                System.out.println(Listado);
            }
        });
        domingoCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(domingoCheckBox.isSelected()){
                System.out.println("Domingo"); //hacer un pdf con palomita o x
                Listado.set(6,7);}
                else {
                    Listado.set(6,0);
                }
                System.out.println(Listado);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insert();


            }
        });

        cicloLectivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectciclo();
                select();
                selectinsti();
            }
        });
        comboBoxCursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectinsti();

            }
        });
        Institucion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectinsertciclo();
                select_insert_institucion();
                select_insert_cursos();

            }
        });
    }



    public void Conexion() {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/escuela";
        String user = "root";
        String pass = "";
        //Connection con;
        //Statement statement;

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass);
            if(!con.isClosed()){
                System.out.println("conexion exitosa");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void select(){
        if (combo.getSize() > 0){
            combo.removeAllElements();
        }
        //indexciclo = cicloLectivo.getSelectedIndex()+1;
        System.out.print("indexciclo "+ indexciclo);
        String sqlprod = "select a.Nombre from cursos a inner join ciclo_lectivo b on a.id_ciclo = b.id_ciclo where a.id_ciclo = "+indexciclo;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            ResultSetMetaData resul = rs.getMetaData();
            if (combo.getSize() < 1){
                while (rs.next()){
                    System.out.println("tito");
                    combo.addElement(rs.getString("Nombre"));
                    System.out.println(rs.getString("Nombre"));
                }
                comboBoxCursos.setModel(combo);}

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void selectinsti(){
        if (comboinst.getSize() > 0){
            comboinst.removeAllElements();
        }
        Item = (String) comboBoxCursos.getSelectedItem();
        indexciclo = cicloLectivo.getSelectedIndex()+1;

        String sqlprod = "select a.Nombre from institucion a inner join cursos b on a.id_institucion = b.id_institucion  where (b.Nombre = '" +
                Item +"' && b.id_ciclo = "+indexciclo+")";



        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;

        try{
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            resul = rs.getMetaData();
            while(rs.next()){
                comboinst.addElement(rs.getString(1));

            }
            Institucion.setModel(comboinst);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void selectciclo(){

        String sqlprod = "select anio from ciclo_lectivo";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;
        try{
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            resul = rs.getMetaData();
            if (combociclo.getSize() < 1){

                while(rs.next()){

                    combociclo.addElement(rs.getString(1));


                }
                cicloLectivo.setModel(combociclo);}


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void selectinsertciclo(){
        seleccionciclo = cicloLectivo.getSelectedIndex()+1; //where id ciclo sea igual a esto
        System.out.println("ciclo lectivo select: "+seleccionciclo);
    }
    public void select_insert_institucion(){
        String seleccioninstitucion_proto = (String)Institucion.getSelectedItem();

        //seleccionciclo = cicloLectivo.getSelectedIndex(); //where id ciclo sea igual a esto
        //seleccioninstitucion = "select id_institucion where Nombre = 'CFP 403'"; //getselecteditem
        //seleccioncursos = "select id_cursos from cursos where id_institucion = 3 && id_ciclo = 1 && Nombre = 'Programacion'; " //parametros y getselecteditem
        //String sqlprod= "select id_curso from cursos where id_ciclo = && id_institucion = " //getselectedindex,
        String sqlprod = "select id_institucion from institucion where Nombre = '"+ seleccioninstitucion_proto +"'";

        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;
        try {
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            resul = rs.getMetaData();
            while(rs.next()){
                seleccioninstitucion = rs.getString(1);
            }
            System.out.println("seleccion insti: " +seleccioninstitucion);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void select_insert_cursos (){
        //seleccioncursos = "select id_cursos from cursos where id_institucion = 3 && id_ciclo = 1 && Nombre = 'Programacion'; " //parametros y getselecteditem
        String seleccion_nombre_curso = (String) comboBoxCursos.getSelectedItem();
        String sqlprod = "select id_cursos from cursos where id_institucion = "+seleccioninstitucion+ "  && id_ciclo =" + seleccionciclo + " && Nombre = '"+seleccion_nombre_curso+"'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;
        try{
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            resul = rs.getMetaData();
            while(rs.next()){
                seleccioncursos = rs.getString(1);

            }
            System.out.println("seleccion cursos: "+seleccioncursos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void insert(){
        ArrayList <Object> Listadofinal = new ArrayList <>();
        for (int i = 0;i<Listado.size();i++){
            if((int) Listado.get(i) == 1){
                ListadoString.set (i,"Lunes");
            }
            else if((int) Listado.get(i) == 2){
                ListadoString.set (i,"Martes");
            }
            else if((int) Listado.get(i) == 3){
                ListadoString.set (i,"Miercoles");
            }
            else if((int) Listado.get(i) == 4){
                ListadoString.set (i,"Jueves");
            }
            else if((int) Listado.get(i) == 5){
                ListadoString.set (i,"Viernes");
            }
            else if((int) Listado.get(i) == 6){
                ListadoString.set (i,"Sabado");
            }
            else if((int) Listado.get(i) == 7){
                ListadoString.set (i,"Domingo");
            }
            else {
                ListadoString.set(i,"");
            }
        }
        for (int i = 0;i<7;i++){
            if(!ListadoString.get(i).equals("")){
                Listadofinal.add(ListadoString.get(i));}}
        System.out.println(Listadofinal);

        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("INSERT INTO docentes (Nombre,Apellido,Dni,Fecha_Nacimiento,Domicilio,Telefono,Email,Localidad,Nacionalidad,id_curso,Dias,Horario_inicio,Horario_fin,id_institucion,Visible) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

            ps.setString(1,NombreDocente.getText());
            ps.setString(2,ApellidoDocente.getText());
            ps.setString(3,DniDocente.getText());
            ps.setString(4,Fecha_Nacimiento.getText());
            ps.setString(5,Domicilio.getText());
            ps.setString(6,Telefono.getText());
            ps.setString(7,Email.getText());
            ps.setString(8,Localidad.getText());
            ps.setString(9,Nacionalidad.getText());
            ps.setString(10,seleccioncursos);//que sean numeros
            ps.setString(11,String.valueOf(Listadofinal));
            ps.setString(12,String.valueOf(HorarioInicio.getSelectedItem()));
            ps.setString(13,String.valueOf(HorarioFin.getSelectedItem()));
            ps.setString(14,seleccioninstitucion);
            ps.setString(15,"1");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
