package animation;

import javax.swing.JFrame;

/**
 *
 * @author Администратор
 */
public class Animation {
    
    static int nx = 690;
    static int ny = 690;
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(nx, ny);
        
        MainPanel mPan  = new MainPanel();
        frame.add(mPan);
        frame.setVisible(true);
        
        mPan.start();
    }
    
}
