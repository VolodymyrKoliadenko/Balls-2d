package animation;

import static animation.Ball.checkIn;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    public static Ball b1;
    public static Ball b2;
    Random rand = new Random();
    static int nx = Animation.nx;
    static int ny = Animation.ny;
    static int r = 50;

    public MainPanel() {
        super();
        b1 = new Ball(r + rand.nextDouble() * (nx - 4 * r),
                r + rand.nextDouble() * (ny - 4 * r), r);
        b2 = new Ball(r + rand.nextDouble() * (nx - 4 * r),
                r + rand.nextDouble() * (ny - 4 * r), r);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;
        super.paintComponent(g);

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        gr2d.setRenderingHints(rh);

        gr2d.draw(b1);
        gr2d.setColor(Color.red);
        gr2d.draw(b2);
    }

    public void start() {
        while (true) {
            reAnimation();
            repaint();
            try {
                Thread.sleep(33);
            } catch (InterruptedException ex) {
            }
        }
    }

    void reAnimation() {
        checkIn(b1, b2);
        b1.step(3);
        b2.step(3);
    }
}
