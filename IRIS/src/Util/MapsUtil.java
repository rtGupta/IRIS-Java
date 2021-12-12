/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolTip;
import javax.swing.event.MouseInputListener;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.cache.FileBasedLocalCache;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;

/**
 *
 * @author akshatajadhav
 */
public class MapsUtil {

    public static Color tabColor = Color.MAGENTA;
    
    public static JPanel mapWayPoint(double latitude, double longitude) {
        final JXMapKit jXMapKit = new JXMapKit();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapKit.setTileFactory(tileFactory);

        //location of Java
        final GeoPosition gp = new GeoPosition(latitude, longitude);

        final JToolTip tooltip = new JToolTip();
        tooltip.setTipText("Name");
        tooltip.setComponent(jXMapKit.getMainMap());
        jXMapKit.getMainMap().add(tooltip);

        jXMapKit.setZoom(3);
        jXMapKit.setAddressLocation(gp);

        jXMapKit.getMainMap().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // ignore
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                JXMapViewer map = jXMapKit.getMainMap();

                // convert to world bitmap
                Point2D worldPos = map.getTileFactory().geoToPixel(gp, map.getZoom());

                // convert to screen
                Rectangle rect = map.getViewportBounds();
                int sx = (int) worldPos.getX() - rect.x;
                int sy = (int) worldPos.getY() - rect.y;
                Point screenPos = new Point(sx, sy);

                // check if near the mouse
                if (screenPos.distance(e.getPoint()) < 20) {
                    screenPos.x -= tooltip.getWidth() / 2;

                    tooltip.setLocation(screenPos);
                    tooltip.setVisible(true);
                } else {
                    tooltip.setVisible(false);
                }
            }
        });

        return jXMapKit;
    }

    public static JPanel mapWayPointWithLocationName(String locationName, double latitude, double longitude) {
        final JXMapKit jXMapKit = new JXMapKit();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapKit.setTileFactory(tileFactory);

        //location of Java
        final GeoPosition gp = new GeoPosition(latitude, longitude);

        final JToolTip tooltip = new JToolTip();
        tooltip.setTipText(locationName);
        tooltip.setComponent(jXMapKit.getMainMap());
        jXMapKit.getMainMap().add(tooltip);

        jXMapKit.setZoom(3);
        jXMapKit.setAddressLocation(gp);

        jXMapKit.getMainMap().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // ignore
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                JXMapViewer map = jXMapKit.getMainMap();

                // convert to world bitmap
                Point2D worldPos = map.getTileFactory().geoToPixel(gp, map.getZoom());

                // convert to screen
                Rectangle rect = map.getViewportBounds();
                int sx = (int) worldPos.getX() - rect.x;
                int sy = (int) worldPos.getY() - rect.y;
                Point screenPos = new Point(sx, sy);

                // check if near the mouse
                if (screenPos.distance(e.getPoint()) < 20) {
                    screenPos.x -= tooltip.getWidth() / 2;

                    tooltip.setLocation(screenPos);
                    tooltip.setVisible(true);
                } else {
                    tooltip.setVisible(false);
                }
            }
        });

        return jXMapKit;
    }
    
    public static JPanel publishMap(double location[], List<double []> police, List<double []> firefighter, List<double []> paramedics){
        TileFactoryInfo info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);

        // Setup local file cache
        File cacheDir = new File(System.getProperty("user.home") + File.separator + ".jxmapviewer2");
        tileFactory.setLocalCache(new FileBasedLocalCache(cacheDir, false));

        // Setup JXMapViewer
        JXMapViewer mapViewer = new JXMapViewer();
        mapViewer.setTileFactory(tileFactory);

        GeoPosition youLocation = new GeoPosition(location);

        // Set the focus
        mapViewer.setZoom(7);
        mapViewer.setAddressLocation(youLocation);

        // Add interactions
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));

        // Create waypoints from the geo-positions
        Set<CustomWayPoint> waypoints = new HashSet<CustomWayPoint>(Arrays.asList(
                new CustomWayPoint("C", "white", youLocation)
                ));
        
        for (double[] loc: police){
            waypoints.add(new CustomWayPoint("P", "blue", new GeoPosition(loc)));
        }
        for (double[] loc: firefighter){
            waypoints.add(new CustomWayPoint("F", "red", new GeoPosition(loc)));
        }
        for (double[] loc: paramedics){
            waypoints.add(new CustomWayPoint("+", "yellow", new GeoPosition(loc)));
        }
        // Create a waypoint painter that takes all the waypoints
        WaypointPainter<CustomWayPoint> waypointPainter = new WaypointPainter<CustomWayPoint>();
        waypointPainter.setWaypoints(waypoints);
        waypointPainter.setRenderer(new CustomWayPointRenderer());

        mapViewer.setOverlayPainter(waypointPainter);
        return mapViewer;
    }
    
    public static JPanel publishMap(double location[], List<double []> paramedics){
        TileFactoryInfo info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);

        // Setup local file cache
        File cacheDir = new File(System.getProperty("user.home") + File.separator + ".jxmapviewer2");
        tileFactory.setLocalCache(new FileBasedLocalCache(cacheDir, false));

        // Setup JXMapViewer
        JXMapViewer mapViewer = new JXMapViewer();
        mapViewer.setTileFactory(tileFactory);

        GeoPosition youLocation = new GeoPosition(location);

        // Set the focus
        mapViewer.setZoom(6);
        mapViewer.setAddressLocation(youLocation);

        // Add interactions
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));

        // Create waypoints from the geo-positions
        Set<CustomWayPoint> waypoints = new HashSet<CustomWayPoint>(Arrays.asList(
                new CustomWayPoint("C", "white", youLocation)
                ));
        for (double[] loc: paramedics){
            waypoints.add(new CustomWayPoint("+", "yellow", new GeoPosition(loc)));
        }
        // Create a waypoint painter that takes all the waypoints
        WaypointPainter<CustomWayPoint> waypointPainter = new WaypointPainter<CustomWayPoint>();
        waypointPainter.setWaypoints(waypoints);
        waypointPainter.setRenderer(new CustomWayPointRenderer());

        mapViewer.setOverlayPainter(waypointPainter);
        return mapViewer;
    }
    
    public static JPanel defaultMap() {
        final JXMapViewer mapViewer = new JXMapViewer();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);

        final GeoPosition gp = new GeoPosition(42.339755, -71.089390);

        mapViewer.setZoom(10);
        mapViewer.setAddressLocation(gp);

        return mapViewer;
    }

    public static JPanel defaultMap(double latitude, double longitude) {
        final JXMapViewer mapViewer = new JXMapViewer();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);

        final GeoPosition gp = new GeoPosition(latitude, longitude);

        mapViewer.setZoom(10);
        mapViewer.setAddressLocation(gp);

        return mapViewer;
    }

    public static double[] getGeoPointFromAddress(String locationAddress) {
        double[] location = new double[2];
        String locationAddres = locationAddress.replaceAll(" ", "%20");
        final String API_KEY = "40187b1ef383146c3f34ebc1bba4deda";
        URL url = null;
        try {
            url = new URL("http://api.positionstack.com/v1/forward?access_key=" + API_KEY
                    + "&query=" + locationAddres
                    + "&limit=1&output=json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            if (con.getResponseCode() != 200) {
                return location;
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
            String output = "", full = "";
            while ((output = br.readLine()) != null) {
                full += output;
            }
            JSONObject json;
            json = new JSONObject(full);
            JSONArray jarr = json.getJSONArray("data");
            json = jarr.getJSONObject(0);
            location[0] = json.getDouble("latitude");
            location[1] = json.getDouble("longitude");
        } catch (MalformedURLException ex) {
            Logger.getLogger(MapsUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MapsUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return location;
    }
    
    public static double distance(double latitude1, double longitude1, double latitude2, double longitude2){
        double p = 0.017453292519943295;
        double hav = 0.5 - Math.cos((latitude1-latitude2)*p)/2;
        hav+= Math.cos(latitude1*p)* Math.cos(latitude2*p) * (1-Math.cos((longitude2-longitude1)*p)) / 2;
        return 12742 * Math.asin(Math.sqrt(hav));
    }
}
