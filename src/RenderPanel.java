import javax.swing.*;
import java.awt.*;

public class RenderPanel extends JPanel {

    @Override
    public  void paintComponent(Graphics g) {

        super.paintComponent(g);
        SortingVisual v = SortingVisual.visual;

        for (int i = 0 ; i < v.points - 1; i++) {

            if (v.p[i].y < 70) {
                    g.setColor(Color.red);
                }
            if (v.p[i].y >= 80 && v.p[i].y < 160) {
                g.setColor(Color.orange);
            }
            if (v.p[i].y >= 160 && v.p[i].y < 240) {
                g.setColor(Color.yellow);
            }
            if (v.p[i].y >= 240 && v.p[i].y < 320) {
                g.setColor(Color.green);
            }
            if (v.p[i].y >= 320 && v.p[i].y < 400) {
                g.setColor(Color.blue);
            }
            if (v.p[i].y >= 400 && v.p[i].y < 480) {
                g.setColor(Color.cyan);
            }
            if (v.p[i].y >= 480 && v.p[i].y < 560) {
                g.setColor(Color.MAGENTA);
            }
                g.fillRect(v.p[i].x,v.p[i].y,2,600);
            }

    }

}
