/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeoLocation;

/**
 *
 * @author 23554853
 */
public class Location {
    private int X, Y, Z;

    public Location(int X, int Y, int Z) {
        this.X = X;
        this.Y = Y;
        this.Z = Z;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getZ() {
        return Z;
    }

    public void setZ(int Z) {
        this.Z = Z;
    }
    
    
    
    public double euclidean(Location L){
        int tempX = this.getX() - L.getX();
        int tempY = this.getY() - L.getY();
        int tempZ = this.getZ() - L.getZ();
        
        double x2 = Math.pow(tempX, 2);
        double y2 = Math.pow(tempY, 2);
        double z2 = Math.pow(tempZ, 2);
        
        double total = x2 + y2 + z2;
        
        double euclidean = Math.sqrt(total);
        
        return euclidean;
    }
    
    public static double euclidean3D(Location L1, Location L2){
        int tempX = L2.getX() - L1.getX();
        int tempY = L2.getY() - L1.getY();
        int tempZ = L2.getZ() - L1.getZ();
        
        double x2 = Math.pow(tempX, 2);
        double y2 = Math.pow(tempY, 2);
        double z2 = Math.pow(tempZ, 2);
        
        double total = x2 + y2 + z2;
        
        double euclidean = Math.sqrt(total);
        
        return euclidean;
    }
}
