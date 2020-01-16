import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class SortingVisual implements ActionListener, KeyListener {
    public static SortingVisual visual;
    JFrame jFrame;
    RenderPanel renderpanel;
    Timer tim = new Timer(10, this);
    public int points = 500, X,Y, ticks = 0;
    public Point[] p = new Point[points];
    public Point tmpP = new Point();
    public boolean start = false;

    public SortingVisual() {
        renderpanel = new RenderPanel();
        Random rand = new Random();
        for (int i = 0; i < points; i++) {
            p[i] = new Point();
        }
        for (int i = 0; i < points; i++) {
            X = rand.nextInt(800);
            Y = rand.nextInt(590);
            for (int j = 0; j < points; j++) {
                if (p[j].x == X) {
                    X = rand.nextInt(600);
                }
                if (p[j].x > p[j].y) {
                    Y = rand.nextInt(560);
                }
            }

            p[i].x = X;
            p[i].y = Y;

        }
        jFrame = new JFrame("SortingVisualized");
        jFrame.setSize(800,600);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(renderpanel);
        jFrame.setVisible(true);
        jFrame.addKeyListener(this);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        renderpanel.repaint();
        tim.start();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        ticks++;
        //sort them
        if (start) {
            for (int i = 0; i < points; i++) {
                for (int j = 1; j < (points - i); j++) {
                    if (ticks % 20 == 0) {
                        if (p[j-1].y < p[j].y) {
                            tmpP.y = p[j-1].y;
                            p[j-1].y = p[j].y;
                            p[j].y = tmpP.y;
                        }

                        if (p[j-1].x > p[j].x) {
                            tmpP.x = p[j].x;
                            p[j].x = p[j-1].x;
                            p[j-1].x = tmpP.x;
                        }
                        renderpanel.repaint();
                    }
                    ticks++;
                }
            }
        }


    }
    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();

        if (i == KeyEvent.VK_SPACE) {
            start = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        visual = new SortingVisual();
    }

}
