
package Util;

import java.awt.Color;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

/**
 * A waypoint that also has a color and a label
 * @author akshatajadhav
 */
public class CustomWayPoint extends DefaultWaypoint
{
    private final String label;
//    private final Color color;
    private final String image;

    public CustomWayPoint(String label, String image, GeoPosition coord)
    {
        super(coord);
        this.label = label;
        this.image = image;
    }

    public String getLabel()
    {
        return label;
    }
    public String getImage() {
        return image;
    }

}
