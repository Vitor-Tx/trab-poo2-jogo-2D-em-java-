package entities;

import entities.auxiliars.Movimento;
import entities.estado.impl.EstadoMorto;

import javax.swing.*;
import java.awt.*;

public class Jogo extends JPanel {

    private Personagem p1;

    private Inimigo i1;

    private Movimento movimento;

    public static final int largura = 700;
    public static final int altura = 600;

    public static final String hurtUrl = System.getProperty("user.dir") + "/hurt.wav";

    public Jogo() {
        movimento = new Movimento(largura, altura);
        addKeyListener(movimento);
        setFocusable(true);
    }

    public void iniciar(Jogo game) throws InterruptedException {
        JFrame frame = new JFrame("O Jogo");
        frame.add(game);
        frame.setSize(largura, altura);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarPersonagens();

        while (true) {
            if (p1.getEstado() instanceof EstadoMorto) {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja reiniciar o jogo?", "Confirma\u00e7\u00e3o",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    inicializarPersonagens();
                } else {
                    System.exit(0);
                }
            } else {
                p1.mostraPos();
                movimento.realizarMovimento();
            }
            game.repaint();
            Thread.sleep(50);
        }
    }

    public void paint(Graphics g) {
        super.paint(g); // Limpa a tela

        Graphics2D g2d = (Graphics2D) g;

//      Faz as bordas ficarem esmaecidas
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (p1 != null) {
            g2d.setColor(Color.BLACK);
            g2d.fillOval(p1.getPosicao().getX(), p1.getPosicao().getY(), 20, 20);
        }

        if (i1 != null) {
            g2d.setColor(Color.RED);
            g2d.fillOval(i1.getPosicao().getX(), i1.getPosicao().getY(), 20, 20);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void inicializarPersonagens() {
        p1 = new Personagem(20, 20);
        movimento.setP(p1);

        i1 = new Inimigo(300, 300, 20, 20);
        p1.addObserver(i1);
    }
}
