package animation;

import java.awt.geom.Ellipse2D;
import static java.lang.Math.pow;
import static java.lang.Math.signum;
import java.util.Random;
import static java.lang.Math.sqrt;

public class Ball extends Ellipse2D.Double {

    Random rand = new Random();
    static int nx = Animation.nx;
    static int ny = Animation.ny;

    double X;
    double Y;
    static double rad;

    double speed = 10;
    double vX;
    double vY;

    public Ball(double x, double y, double r) {
        super(x - r, y - r, r * 2, r * 2);
        X = x;
        Y = y;
        rad = r;

        vX = (rand.nextFloat() - 0.5);
        vY = speed * sqrt(1 - vX * vX);
        vY = vY * signum(rand.nextFloat() - 0.5);
        vX = vX * speed;
    }

    public void step(double dt) {

        if ((X <= rad) || (X >= nx - rad)) {
            vX *= (-1);
        }
        if ((Y <= rad + 30) || (Y >= ny - rad * 2)) {
            vY *= (-1);
        }

        X += vX * dt;
        Y += vY * dt;
        setFrame(X - rad, Y - rad, rad * 2, rad * 2);
    }

    static double dist(double... a) {//x y x y
        return sqrt(pow(a[0] - a[2], 2) + pow(a[1] - a[3], 2));
    }

    static void checkIn(Ball b1, Ball b2) {
        double di = dist(b1.X, b1.Y, b2.X, b2.Y);
        double vecX, vecY;
        if (di <= rad * 2 + 1) {
            vecX = (b1.X - b2.X) / di;
            vecY = (b1.Y - b2.Y) / di;
            double v1 = b1.vX * vecX + b1.vY * vecY;
            double v2 = b2.vX * vecX + b2.vY * vecY;
            //System.out.println(v1 + " " + v2);
            double dv = (v1 - v2);
            b1.vX -= dv * vecX;
            b1.vY -= dv * vecY;
            b2.vX += dv * vecX;
            b2.vY += dv * vecY;
        }
    }

}
