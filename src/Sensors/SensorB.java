/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensors;

import Environment.Particle;
import GeoLocation.Location;
import Globals.NodeStatus;
import Globals.SensorRanges;
import Globals.SensorTypes;
import java.util.ArrayList;

/**
 *
 * @author 23554853
 */
public class SensorB extends Sensor{

    public SensorB(String IDNumber, SensorTypes sensorType, NodeStatus sensorStatus, Location location, ArrayList<Particle> detectedParticles, ArrayList<Integer> decodedParticles) {
        super(IDNumber, sensorType, sensorStatus, location, detectedParticles, decodedParticles);
    }

    

    @Override
    public void detectParticle(Particle[] p) {
        for(int i = 0; i < p.length; i++){
            if(p[i].getPCode().charAt(0) == 'B'){
                if(this.getLocation().euclidean(p[i].getLocation()) < SensorRanges.Sensor_B){
                    this.getDetectedParticles().add(p[i]);
                    this.setTransmittingAuthority(true);
                }
            }
        }
    }

    @Override
    public void decodeParticle() {
        for(Particle p : this.getDetectedParticles()){
            switch(p.getPCode()){
                case("BBBB"):
                    this.getDecodedParticles().add(4);
                    break;
                case("BBBX"):
                    this.getDecodedParticles().add(3);
                    break;
                case("BBXB"):
                    this.getDecodedParticles().add(2);
                    break;
                case("BXBB"):
                    this.getDecodedParticles().add(1);
                    break;
            }
        }
    }
    
}
