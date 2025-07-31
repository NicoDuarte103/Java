import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio_sesion {
    private JTextField Url_inicio_sesion;
    private JTextField Usuario_inicio_sesion;
    private JButton iniciarSesionButton;
    private JPanel Panel1;
    private JTextField Pass_iniciar_sesion;
    public String url_confirm;
    public String user_confirm;
    public String pass_confirm;

    public Inicio_sesion(){


        Get_set_conexion conex = new Get_set_conexion();
        JFrame frame = new JFrame();
        frame.setContentPane(Panel1);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();





        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                url_confirm = "jdbc:mysql://"+Url_inicio_sesion.getText();
                user_confirm = Usuario_inicio_sesion.getText();
                pass_confirm = Pass_iniciar_sesion.getText();
                System.out.println(url_confirm);
                System.out.println(user_confirm);
                System.out.println(pass_confirm);
                conex.setUrl(url_confirm);
                conex.setUser(user_confirm);
                if (pass_confirm.length()>0){
                conex.setPass(pass_confirm);}
                else if (pass_confirm == null){
                    conex.setPass("");
                }
                else{
                    conex.setPass("");
                }
                System.out.println("ini"+conex.getUser());
                Gestion_inscripciones ges = new Gestion_inscripciones(url_confirm,user_confirm,pass_confirm);
            }
        });


    }
}
