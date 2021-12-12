package Util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.WaypointRenderer;

/**
 * @author akshatajadhav
 */
public class CustomWayPointRenderer implements WaypointRenderer<CustomWayPoint> {
//    private static final Log log = LogFactory.getLog(CustomWayPoint.class);

    private final Map<Color, BufferedImage> map = new HashMap<Color, BufferedImage>();

    private final Font font = new Font("Lucida Sans", Font.BOLD, 10);

    private BufferedImage origImage;

    public CustomWayPointRenderer() {

    }


    @Override
    public void paintWaypoint(Graphics2D g, JXMapViewer viewer, CustomWayPoint w) {
        g = (Graphics2D) g.create();

        URL resource = getClass().getResource("/Resource/waypoint_white.png");

        try {
            origImage = ImageIO.read(resource);
        } catch (Exception ex) {

        }
        BufferedImage myImg = origImage;
        Point2D point = viewer.getTileFactory().geoToPixel(w.getPosition(), viewer.getZoom());

        int x = (int) point.getX();
        int y = (int) point.getY();

        g.drawImage(myImg, x - myImg.getWidth() / 2, y - myImg.getHeight(), null);

        String label = w.getLabel();

        FontMetrics metrics = g.getFontMetrics();
        int tw = metrics.stringWidth(label);
        int th = 1 + metrics.getAscent();

        g.drawString(label, x - tw / 2, y + th - myImg.getHeight());

        g.dispose();
    }
}
