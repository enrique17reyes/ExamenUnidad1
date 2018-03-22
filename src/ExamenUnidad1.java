import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.Scanner;

//JOSE ENRIQUE REYES HUERTA
public class ExamenUnidad1 extends JFrame {



    private JButton btnAceptar;

    private JTextField distancia;

    private JTextField tiempo ;
    private JTextField velocidad;

    private int intentos = 0;
    private JButton btnCancelar;



    public ExamenUnidad1(String titulo, Color colorfondo) {

        Scanner in = new Scanner(System.in);

        this.setTitle(titulo);
        Container panelPrincipal = this.getContentPane();

        panelPrincipal.setBackground(colorfondo);
        panelPrincipal.setLayout(null);

        JLabel instruc = new JLabel("Digite un (0) en la casilla del parametro que se desea calcular ");
        instruc.setBounds(10, 20, 500, 30);
        panelPrincipal.add(instruc);


        JLabel dist = new JLabel("Ingresa la distancia (km): ");
        dist.setBounds(10, 50, 300, 30);
        panelPrincipal.add(dist);
        distancia = new JTextField();
        distancia.setBounds(170, 50, 150, 30);
        panelPrincipal.add(distancia);


        JLabel tiemp = new JLabel("Ingresa el tiempo (hrs): ");
        tiemp.setBounds(10, 90, 300, 30);
        panelPrincipal.add(tiemp);
        tiempo = new JTextField();
        tiempo.setBounds(170, 90, 150, 30);
        panelPrincipal.add(tiempo);

        JLabel vel = new JLabel("Ingresa la velocidad (k/hr): ");
        vel.setBounds(10, 130, 300, 30);
        panelPrincipal.add(vel);
        velocidad = new JTextField();
        velocidad.setBounds(170, 130, 150, 30);
        panelPrincipal.add(velocidad);


        btnAceptar = new JButton("Calcular");
        btnAceptar.setBounds(150, 180, 100, 30);
        panelPrincipal.add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(150, 180, 100, 30);
        //panelPrincipal.add(btnCancelar);



        //Creación de objetos oyentes
        AccionBoton oyenteBtnAceptar = new AccionBoton();
        AccionBoton oyenteBtnCancelar = new AccionBoton();


        //Vincular los oyentes a los objetos que generan el evento
        btnAceptar.addActionListener(oyenteBtnAceptar);
        btnCancelar.addActionListener(oyenteBtnCancelar);

    }


    //Declaración de clase interna
    class AccionBoton implements ActionListener {

        //Método controlador del evento ActionEvent
        @Override
        public void actionPerformed(ActionEvent e) {
            double valorDistancia = Double.parseDouble(distancia.getText());
            double valortiempo = Double.parseDouble(tiempo.getText());
            double valorvelocidad = Double.parseDouble(velocidad.getText());

            System.out.println("Haz presionado el botón "
                    + ((JButton) e.getSource()).getText() );


            if ((JButton) e.getSource()== btnAceptar) {
                if (valorvelocidad == 0) {
                    valorvelocidad= valorDistancia/valortiempo;
                    System.out.println("");
                    JOptionPane.showMessageDialog(null,
                            "la velocidad es de :" + valorvelocidad , "se realizo el calculo de la velocidad ",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                if(valortiempo == 0) {
                    valortiempo= valorDistancia*valorvelocidad;
                    System.out.println("");
                    JOptionPane.showMessageDialog(null,
                            "El tiempo es de  :" + valortiempo , "se realizo el calculo del tiempo ",
                            JOptionPane.INFORMATION_MESSAGE);

                }

                if(valorDistancia==0){
                    valorDistancia= valorvelocidad*valortiempo;
                    System.out.println("");
                    JOptionPane.showMessageDialog(null,
                            "la distancia  es de  :" + valorDistancia , "se realizo el calculo de la distancia ",
                            JOptionPane.INFORMATION_MESSAGE);

                }



            }

        }



    } //Class AccionBoton

    public static void main (String[] args)
    {
        ExamenUnidad1 f = new ExamenUnidad1("Programa de calculo de valores para v,d y t", Color.blue);
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);

    }




}//Class MiVentana


