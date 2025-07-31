import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel Panel1;


    private JPanel PanelBotones;
    private JPanel PanelResultados;
    private JButton button1;
    private JButton Button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton button_igual;
    private JButton buttonpunto;
    private JButton button_mas;
    private JButton button_guion;
    private JButton button_multi;
    private JButton button_division;
    private JButton button_AC;
    private JTextField Texto_resultado;
    private JLabel Label;

    public void teclas(String p_valor_enviado){ //ponla por separada
        String valor_base = Texto_resultado.getText();
        if (valor_base.isEmpty()){
            valor_base = "0";
        }


        System.out.println(valor_base);
        String valor_enviado = "e";

        if (valor_base.equals("0")){
            System.out.println("tiene cero");
            Texto_resultado.setText("");
            valor_enviado =  p_valor_enviado;
        }
        else {
            valor_enviado = valor_base + p_valor_enviado;
        }
        Texto_resultado.setText(valor_enviado);

    }

    public void operadores(char signo){
        String operador = Texto_resultado.getText();
        char operador_detectar = signo;
        for (int i=0;i<operador.length();i++){
            if(operador.charAt(i)==operador_detectar){
                System.out.println(operador);

            }

        }

    }

    public void resultado(){



    }

    public Main() {

        String predeterminado = "0";

        Texto_resultado.setText(predeterminado);
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teclas("0");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teclas("1");

            }
        });
        button_AC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valor_base = Texto_resultado.getText();
                System.out.println(valor_base);
                String valor_enviado = "0";
                Texto_resultado.setText(valor_enviado);
            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teclas("2");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teclas("3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teclas("4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teclas("5");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teclas("6");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teclas("7");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teclas("8");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teclas("9");
            }
        });
        button_mas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char signo = '+';
                String operador = Texto_resultado.getText();
                Texto_resultado.setText(operador+"+");
                operadores(signo);
            }
        });
        button_guion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char signo = '-';
                String operador = Texto_resultado.getText();
                Texto_resultado.setText(operador+"-");
                operadores(signo);
            }
        });
        button_multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char signo = '*';
                String operador = Texto_resultado.getText();
                Texto_resultado.setText(operador+"*");
                operadores(signo);
            }
        });
        button_division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char signo = '/';
                String operador = Texto_resultado.getText();
                Texto_resultado.setText(operador+"/");
                operadores(signo);
            }
        });
        button_igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String operador = Texto_resultado.getText();
                char operador_detectar_suma = '+';
                char operador_detectar_resta= '-';
                char operador_detectar_multiplicacion = '*';
                char operador_detectar_division = '/';
                int detector_suma = 0;
                int detector_resta=0;
                int detector_multiplicacion=0;
                int detector_division=0;
                int i = 0;
                for (i=0;i<operador.length();i++){
                    if(operador.charAt(i)==operador_detectar_suma){
                        System.out.println(operador);
                        detector_suma = detector_suma+1;
                        System.out.println("detecto suma" + detector_suma);
                    }

                }

                for (i=0;i<operador.length();i++){
                    if(operador.charAt(i)==operador_detectar_resta){
                        System.out.println(operador);
                        detector_resta = detector_resta+1;
                        System.out.println("detecto resta"+detector_resta);
                    }

                }

                for (i=0;i<operador.length();i++){
                    if(operador.charAt(i)==operador_detectar_multiplicacion){
                        System.out.println(operador);
                        detector_multiplicacion = detector_multiplicacion+1;
                        System.out.println(detector_multiplicacion);
                    }

                }
                for (i=0;i<operador.length();i++){
                    if(operador.charAt(i)==operador_detectar_division){
                        System.out.println(operador);
                        detector_division = detector_division+1;
                        System.out.println(detector_division);
                    }

                }

            }
        });
        button_division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

}
