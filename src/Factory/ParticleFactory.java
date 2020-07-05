/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DBSupport.DBConnection;
import Environment.Particle;
import GeoLocation.Location;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 23554853
 */
public class ParticleFactory {
    public static Particle[] createDBParticles() throws SQLException, ClassNotFoundException{
        int counter = 0; int count = 0;
        
        DBConnection db = new DBConnection();
        Connection con = db.establishDBConnection();
        Statement useS = con.createStatement();
        useS.executeQuery("USE tachyon");
       
        String countQuery = "SELECT COUNT(IDNumber) AS COUNT from particles;";
        Statement countS = con.createStatement();
        ResultSet queryCount = countS.executeQuery(countQuery);
        while(queryCount.next()){
            count = queryCount.getInt("COUNT");
        }
        
        String particleRetrievalQuery = "SELECT particles.IDNumber, particles.PCode, particle_location.XCoord, particle_location.YCoord, particle_location.ZCoord\n" +
                                      "FROM particles\n" +
                                      "INNER JOIN particle_location ON particles.IDNumber = particle_location.IDNumber\n" +
                                      "ORDER BY particles.IDNumber;";
        
        Statement queryStatement = con.createStatement();
        ResultSet queryResult = queryStatement.executeQuery(particleRetrievalQuery);
        
        Particle[] tempParticleList = new Particle[count];
        
        while(queryResult.next()){
            String IDNumber = queryResult.getString("IDNumber");
            String PCode = queryResult.getString("PCode");
            int x = queryResult.getInt("XCoord");
            int y = queryResult.getInt("YCoord");
            int z = queryResult.getInt("ZCoord");
            
            Location loc = new Location(x, y, z);
            
            tempParticleList[counter] = new Particle(IDNumber, PCode, loc);
            
            counter++;
        }
        
        return tempParticleList;
    }
    
    public static void displayParticles() throws SQLException, ClassNotFoundException{
        System.out.println("^^^PARTICLES^^^");
        System.out.println("ID\tPCODE\tLocation");
        System.out.println("_______________________________");
        Particle[] temp = createDBParticles();
        for(int i = 0; i < temp.length; i++){
            if(i % 5 == 0){
                System.out.println();
            }
            System.out.print(temp[i].getIDNumber() + "\t" + temp[i].getPCode() 
            + "\t(" + temp[i].getLocation().getX()
            + "," + temp[i].getLocation().getY() + "," + temp[i].getLocation().getZ()
            + ")\t");
            
        }
        System.out.println();
    }
}
