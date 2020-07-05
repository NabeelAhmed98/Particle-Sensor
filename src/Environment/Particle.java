/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment;

import GeoLocation.Location;

/**
 *
 * @author 23554853
 */
public class Particle {
    private String IDNumber;
    private String PCode;
    private Location location;

    public Particle(String IDNumber, String PCode, Location location) {
        this.IDNumber = IDNumber;
        this.PCode = PCode;
        this.location = location;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getPCode() {
        return PCode;
    }

    public void setPCode(String PCode) {
        this.PCode = PCode;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
}
