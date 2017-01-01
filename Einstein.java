import java.applet.Applet;
import java.awt.*;

/**
 * Created by Devang on 14-Dec-16.
 */
public class Einstein extends Applet {

    public void paint(Graphics page){
        page.drawRect(50, 50, 40, 40);      // Square
        page.drawRect(60, 80, 225, 30);     // Rectangle
        page.setColor(Color.red);
        page.fillRect(61, 81, 223, 28);     // Rectangle
        page.setColor(Color.black);
        page.drawOval(75, 65, 20, 20);      // Circle
        page.drawLine(35, 60, 100, 120);        // Line

        page.drawString("Out of clutter, find simplicity.", 110, 70);
        page.drawString("-- Albert Einstein", 130, 100);
    }
}
