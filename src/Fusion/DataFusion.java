/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fusion;

import GeoLocation.Location;
import Globals.Fusionable;
import Globals.NodeStatus;
import java.util.ArrayList;

/**
 *
 * @author 23554853
 */
public abstract class DataFusion implements Fusionable{
    private String NodeID;
    private NodeStatus sensorStatus;
    private Location location;
    private ArrayList<ArrayList<Integer>> codeBuffer;
    private ArrayList<Integer> fusedBuffer;

    public DataFusion(String NodeID, Location location, ArrayList<ArrayList<Integer>> codeBuffer, ArrayList<Integer> fusedBuffer) {
        this.NodeID = NodeID;
        this.location = location;
        this.codeBuffer = codeBuffer;
        this.fusedBuffer = fusedBuffer;
        this.sensorStatus = NodeStatus.ONLINE;
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

    public NodeStatus getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(NodeStatus sensorStatus) {
        this.sensorStatus = sensorStatus;
    }

    public ArrayList<ArrayList<Integer>> getCodeBuffer() {
        return codeBuffer;
    }

    public void setCodeBuffer(ArrayList<ArrayList<Integer>> codeBuffer) {
        this.codeBuffer = codeBuffer;
    }

    public ArrayList<Integer> getFusedBuffer() {
        return fusedBuffer;
    }

    public void setFusedBuffer(ArrayList<Integer> fusedBuffer) {
        this.fusedBuffer = fusedBuffer;
    }
    
    public void processSensorData(){
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^DATA FUSION^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Data Fusion Process Beginning at Data Fusion Node " + this.getNodeID());
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        for(ArrayList<Integer> cb : this.getCodeBuffer()){
            for(Integer cbdp : cb){
                this.getFusedBuffer().add(cbdp);
                
            }
        }
        
        this.writeDataToFile();
    }
}
