package ejercicio17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Family extends JFrame {
    private JPanel panelGrafico;
    private JPanel panelCuestionario;
    private JLabel imgPadre;
    private JLabel imgMadre;
    private JLabel imgHijo;
    private JLabel imgHija;
    private JLabel txt1;
    private JLabel txt2;
    private JLabel txt3;
    private JLabel txt4;

    static JLabel pregunta1;
    static JLabel pregunta2;
    static JLabel pregunta3;
    static JLabel pregunta4;
    static JLabel pregunta5;
    static JLabel pregunta6;
    static JLabel pregunta7;
    static JLabel pregunta8;
    static JTextField respuesta1;
    static JTextField respuesta2;
    static JTextField respuesta3;
    static JTextField respuesta4;
    static JTextField respuesta5;
    static JTextField respuesta6;
    static JTextField respuesta7;
    static JTextField respuesta8;
    static JButton resultados;

    public Family() throws HeadlessException {
        this.setTitle("Family");
        this.setSize(400, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
        showQuestionsLetterByLetter();
    }

    private void showQuestionsLetterByLetter() {
        Thread thread = new Thread(() -> {
            showLabelLetterByLetter(pregunta1);
            showLabelLetterByLetter(pregunta2);
            showLabelLetterByLetter(pregunta3);
            showLabelLetterByLetter(pregunta4);
            showLabelLetterByLetter(pregunta5);
            showLabelLetterByLetter(pregunta6);
            showLabelLetterByLetter(pregunta7);
            showLabelLetterByLetter(pregunta8);
        });
        thread.start();
    }

    private void showLabelLetterByLetter(JLabel label) {
        String text = label.getText();
        label.setText("");  // Borra el texto original del JLabel
        char[] chars = text.toCharArray();
        for (char c : chars) {
            try {
                Thread.sleep(100);  // Pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            label.setText(label.getText() + c);  // Agrega cada letra al JLabel gradualmente
        }
    }


    private void initComponents() {
        this.getContentPane().setLayout(null); //Definimos layout en Null
        //inicio de cargar iconos
        ImageIcon iconPadre = new ImageIcon(Toolkit.getDefaultToolkit().getImage
                        (getClass().getResource("padre.png")).
                getScaledInstance(100, 100, Image.SCALE_FAST));


        ImageIcon iconMadre = new ImageIcon(Toolkit.getDefaultToolkit().getImage
                        (getClass().getResource("madre.png")).
                getScaledInstance(100, 100, Image.SCALE_FAST));

        ImageIcon iconHijo = new ImageIcon(Toolkit.getDefaultToolkit().getImage
                        (getClass().getResource("hijo.png")).
                getScaledInstance(100, 100, Image.SCALE_FAST));

        ImageIcon iconHija = new ImageIcon(Toolkit.getDefaultToolkit().getImage
                        (getClass().getResource("hija.png")).
                getScaledInstance(100, 100, Image.SCALE_FAST));
        //fin de cargar iconos

        //inicio crear y dar propiedades a etiquetas
        panelGrafico = new JPanel(null);
        panelGrafico.setBounds(0, 0, 400, 350);
        //panelGrafico.setBackground(Color.CYAN);

        imgPadre = new JLabel("Paul");
        imgPadre.setBounds(10, 10, 100, 120);
        imgPadre.setIcon(iconPadre);
        imgPadre.setVerticalAlignment(JLabel.TOP);
        imgPadre.setHorizontalTextPosition(JLabel.CENTER);
        imgPadre.setVerticalTextPosition(JLabel.TOP);


        imgMadre = new JLabel("Anne");
        imgMadre.setBounds(290, 10, 100, 120);
        imgMadre.setIcon(iconMadre);
        imgMadre.setVerticalAlignment(JLabel.TOP);
        imgMadre.setHorizontalTextPosition(JLabel.CENTER);
        imgMadre.setVerticalTextPosition(JLabel.TOP);


        imgHijo = new JLabel("Jason");
        imgHijo.setBounds(10, 220, 100, 120);
        imgHijo.setIcon(iconHijo);
        imgHijo.setVerticalAlignment(JLabel.BOTTOM);
        imgHijo.setHorizontalTextPosition(JLabel.CENTER);
        imgHijo.setVerticalTextPosition(JLabel.BOTTOM);


        imgHija = new JLabel("Emily");
        imgHija.setBounds(290, 220, 100, 120);
        imgHija.setIcon(iconHija);
        imgHija.setVerticalAlignment(JLabel.BOTTOM);
        imgHija.setHorizontalTextPosition(JLabel.CENTER);
        imgHija.setVerticalTextPosition(JLabel.BOTTOM);

        txt1 = new JLabel("Husband            Wife");
        txt1.setBounds(120, 10, 160, 20);
        txt1.setOpaque(true);
        txt1.setBackground(Color.gray);
        txt1.setHorizontalAlignment(JLabel.CENTER);
        txt1.setVerticalAlignment(JLabel.CENTER);


        txt2 = new JLabel("<html>Father&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mother<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Parents)</html>");
        txt2.setBounds(120, 90, 160, 40);
        txt2.setOpaque(true);
        txt2.setBackground(Color.gray);
        txt2.setHorizontalAlignment(JLabel.CENTER);
        txt2.setVerticalAlignment(JLabel.CENTER);


        txt3 = new JLabel("<html>Son&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Daughter<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Children)</html>");
        txt3.setBounds(120, 220, 160, 40);
        txt3.setOpaque(true);
        txt3.setBackground(Color.gray);
        txt3.setHorizontalAlignment(JLabel.CENTER);
        txt3.setVerticalAlignment(JLabel.CENTER);


        txt4 = new JLabel("Brother            Sister");
        txt4.setBounds(120, 320, 160, 20);
        txt4.setOpaque(true);
        txt4.setBackground(Color.gray);
        txt4.setHorizontalAlignment(JLabel.CENTER);
        txt4.setVerticalAlignment(JLabel.CENTER);


        panelCuestionario = new JPanel(null);
        panelCuestionario.setBounds(0, 350, 400, 220);


        pregunta1 = new JLabel("1. Anne is Paul's");
        pregunta1.setBounds(10, 10, 200, 15);


        respuesta1 = new JTextField();
        respuesta1.setBounds(210, 10, 100, 15);

        pregunta2 = new JLabel("2. Jason and Emily are their");
        pregunta2.setBounds(10, 30, 200, 15);


        respuesta2 = new JTextField();
        respuesta2.setBounds(210, 30, 100, 15);

        pregunta3 = new JLabel("3. Paul is Anne's");
        pregunta3.setBounds(10, 50, 200, 15);


        respuesta3 = new JTextField();
        respuesta3.setBounds(210, 50, 100, 15);

        pregunta4 = new JLabel("4. Jason is Anne's");
        pregunta4.setBounds(10, 70, 200, 15);


        respuesta4 = new JTextField();
        respuesta4.setBounds(210, 70, 100, 15);

        pregunta5 = new JLabel("5. Emily is Paul's");
        pregunta5.setBounds(10, 90, 200, 15);


        respuesta5 = new JTextField();
        respuesta5.setBounds(210, 90, 100, 15);

        pregunta6 = new JLabel("6. Jason is Emily's");
        pregunta6.setBounds(10, 110, 200, 15);


        respuesta6 = new JTextField();
        respuesta6.setBounds(210, 110, 100, 15);

        pregunta7 = new JLabel("7. Emily is Jason's");
        pregunta7.setBounds(10, 130, 200, 15);


        respuesta7 = new JTextField();
        respuesta7.setBounds(210, 130, 100, 15);

        pregunta8 = new JLabel("8. Paul and Anne are Jason's");
        pregunta8.setBounds(10, 150, 210, 15);


        respuesta8 = new JTextField();
        respuesta8.setBounds(220, 150, 100, 15);

        resultados = new JButton("Ver resultados");
        resultados.setBounds(125, 170, 150, 25);
        resultados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                evaluarResultados();
            }
        });


        panelGrafico.add(imgPadre);
        panelGrafico.add(imgMadre);
        panelGrafico.add(imgHijo);
        panelGrafico.add(imgHija);
        panelGrafico.add(txt1);
        panelGrafico.add(txt2);
        panelGrafico.add(txt3);
        panelGrafico.add(txt4);
        this.getContentPane().add(panelGrafico);

        panelCuestionario.add(pregunta1);
        panelCuestionario.add(pregunta2);
        panelCuestionario.add(pregunta3);
        panelCuestionario.add(pregunta4);
        panelCuestionario.add(pregunta5);
        panelCuestionario.add(pregunta6);
        panelCuestionario.add(pregunta7);
        panelCuestionario.add(pregunta8);
        panelCuestionario.add(respuesta1);
        panelCuestionario.add(respuesta2);
        panelCuestionario.add(respuesta3);
        panelCuestionario.add(respuesta4);
        panelCuestionario.add(respuesta5);
        panelCuestionario.add(respuesta6);
        panelCuestionario.add(respuesta7);
        panelCuestionario.add(respuesta8);
        panelCuestionario.add(resultados);
        this.getContentPane().add(panelCuestionario);
    }

    static void evaluarResultados() {
        String[] respuestas = {"wife", "children", "husband", "son", "daughter", "brother", "sister", "parents"};
        int contarRespuestasCorrectas = 0;
        JTextField[] respuestasUsuario = {respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7, respuesta8};
        //validamos cantidad de respuestas correctas
        for (int i = 0; i < respuestas.length; i++) {
            if (respuestasUsuario[i].getText().toLowerCase().equals(respuestas[i])) {
                System.out.println(respuestasUsuario[i].getText().toLowerCase());
                System.out.println(respuestas[i]);
                contarRespuestasCorrectas++;
            }
        }

        JOptionPane.showMessageDialog(null, "Calificacion: " + contarRespuestasCorrectas + "/" + respuestas.length);
    }

    public static void main(String[] args) {
        new Family().setVisible(true);
    }
}
