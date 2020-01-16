import javax.swing.*;
import java.awt.*;

public class RenderPanel extends JPanel {

    @Override
    public  void paintComponent(Graphics g) {

        super.paintComponent(g);
        SortingVisual v = SortingVisual.visual;

        for (int i = 0 ; i < v.points - 1; i++) {
                g.setColor(Color.black);
                g.fillRect(v.p[i].x,v.p[i].y,2,600);
            }

    }

}
