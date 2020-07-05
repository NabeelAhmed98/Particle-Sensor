/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analysis;

import GeoLocation.Location;
import Globals.Analyzable;
import java.util.ArrayList;

/**
 *
 * @author 23554853
 */
public abstract class DataAnalytics implements Analyzable{
    private String NodeID;
    private Location location;
    private ArrayList<Integer> filebuffer;
    private double[] analysisValues;

    public DataAnalytics(String NodeID, Location location, ArrayList<Integer> filebuffer, double[] analysisValues) {
        this.NodeID = NodeID;
        this.location = location;
        this.filebuffer = filebuffer;
        this.analysisValues = analysisValues;
    }

    public ArrayList<Integer> getFilebuffer() {
        return filebuffer;
    }

    public void setFilebuffer(ArrayList<Integer> filebuffer) {
        this.filebuffer = filebuffer;
    }

    public double[] getAnalysisValues() {
        return analysisValues;
    }

    public void setAnalysisValues(double[] analysisValues) {
        this.analysisValues = analysisValues;
    }

    

    public String getNodeID() {
        return NodeID;
    }

    public void setNodeID(String NodeID) {
        this.NodeID = NodeID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
}
