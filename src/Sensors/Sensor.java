/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensors;

import Environment.Particle;
import Fusion.DataFusion;
import GeoLocation.Location;
import Globals.Detectable;
import Globals.NodeStatus;
import Globals.SensorTypes;
import java.util.ArrayList;

/**
 *
 * @author 23554853
 */
public abstract class Sensor implements Detectable{
    private String IDNumber;
    private SensorTypes sensorType;
    private NodeStatus sensorStatus;
    private Location location;
    private boolean transmittingAuthority;
    private ArrayList<Particle> detectedParticles;
    private ArrayList<Integer> decodedParticles;

    public Sensor(String IDNumber, SensorTypes sensorType, NodeStatus sensorStatus, Location location, ArrayList<Particle> detectedParticles, ArrayList<Integer> decodedParticles) {
        this.IDNumber = IDNumber;
        this.sensorType = sensorType;
        this.sensorStatus = sensorStatus;
        this.location = location;
        this.transmittingAuthority = false;
        this.detectedParticles = detectedParticles;
        this.decodedParticles = decodedParticles;
    }

    

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public SensorTypes getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorTypes sensorType) {
        this.sensorType = sensorType;
    }

    public NodeStatus getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(NodeStatus sensorStatus) {
        this.sensorStatus = sensorStatus;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isTransmittingAuthority() {
        return transmittingAuthority;
    }

    public void setTransmittingAuthority(boolean transmittingAuthority) {
        this.transmittingAuthority = transmittingAuthority;
    }

    public ArrayList<Particle> getDetectedParticles() {
        return detectedParticles;
    }

    public void setDetectedParticles(ArrayList<Particle> detectedParticles) {
        this.detectedParticles = detectedParticles;
    }

    public ArrayList<Integer> getDecodedParticles() {
        return decodedParticles;
    }

    public void setDecodedParticles(ArrayList<Integer> decodedParticles) {
        this.decodedParticles = decodedParticles;
    }
    
    
    
    public void displayDetectedParticles(){
        System.out.println("SENSOR: " + this.getIDNumber() + " HAS DETECTED " + this.getDetectedParticles().size() + " PARTICLES");
        for(int i = 0; i < this.getDetectedParticles().size(); i++){
            System.out.print(this.getDetectedParticles().get(i).getIDNumber() + "\t");
            if((i + 1) % 5 == 0){
                System.out.println();
            }
        }
        System.out.println("\n____________________________________________________");
    }
    
    public void displayDecodedParticles(){
        
    }
    
    @Override
    public void sendDataToFusionNode(DataFusion df){
        df.getCodeBuffer().add(this.getDecodedParticles());
        System.out.println(this.getIDNumber() + " has transmitted data to Data Fusion " + df.getNodeID());
    }
}
