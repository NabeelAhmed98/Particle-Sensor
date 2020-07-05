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
public class SensorC extends Sensor{

    public SensorC(String IDNumber, SensorTypes sensorType, NodeStatus sensorStatus, Location location, ArrayList<Particle> detectedParticles, ArrayList<Integer> decodedParticles) {
        super(IDNumber, sensorType, sensorStatus, location, detectedParticles, decodedParticles);
    }

    

    @Override
    public void detectParticle(Particle[] p) {
        for(int i = 0; i < p.length; i++){
            if(p[i].getPCode().charAt(0) == 'C'){
                if(this.getLocation().euclidean(p[i].getLocation()) < SensorRanges.Sensor_C){
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
                case("CCCC"):
                    this.getDecodedParticles().add(4);
                    break;
                case("CCCX"):
                    this.getDecodedParticles().add(3);
                    break;
                case("CCXC"):
                    this.getDecodedParticles().add(2);
                    break;
                case("CXCC"):
                    this.getDecodedParticles().add(1);
                    break;
            }
        }
    }
    
}
