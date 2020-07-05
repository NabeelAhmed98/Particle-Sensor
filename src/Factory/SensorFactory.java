/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DBSupport.DBConnection;
import Environment.Particle;
import GeoLocation.Location;
import Globals.NodeStatus;
import Globals.SensorTypes;
import Sensors.Sensor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 23554853
 */
public class SensorFactory {
    public static Sensor[] createDBSensors() throws SQLException, ClassNotFoundException{
        NodeStatus Status = null;
        SensorTypes SType = null;
        int counter = 0; int count = 0;
        
        DBConnection db = new DBConnection();
        Connection con = db.establishDBConnection();
        Statement useS = con.createStatement();
        useS.executeQuery("USE tachyon");
       
        String countQuery = "SELECT COUNT(SID) AS COUNT from sensors;";
        Statement countS = con.createStatement();
        ResultSet queryCount = countS.executeQuery(countQuery);
        while(queryCount.next()){
            count = queryCount.getInt("COUNT");
        }
        
        
        String sensorRetrievalQuery = "SELECT sensors.SID, sensors.SType, sensors.Status, sensor_location.XCoord, sensor_location.YCoord, sensor_location.ZCoord\n" +
                                      "FROM sensors\n" +
                                      "INNER JOIN sensor_location ON sensors.SID = sensor_location.SID\n" +
                                      "ORDER BY sensors.SID;";
        
        Statement queryStatement = con.createStatement();
        ResultSet queryResult = queryStatement.executeQuery(sensorRetrievalQuery);
        
        Sensor[] tempSensorList = new Sensor[count];
        
        while(queryResult.next()){
            String IDNumber = queryResult.getString("SID");
            String Type = queryResult.getString("SType");
            String status = queryResult.getString("Status");
            int x = queryResult.getInt("XCoord");
            int y = queryResult.getInt("YCoord");
            int z = queryResult.getInt("ZCoord");
            
            Location loc = new Location(x, y, z);
            
            switch(Type){
                case("Sensor_A"):
                    SType = SensorTypes.Sensor_A;
                    break;
                case("Sensor_B"):
                    SType = SensorTypes.Sensor_B;
                    break;
                case("Sensor_C"):
                    SType = SensorTypes.Sensor_C;
                    break;
            }
            
            switch(status){
                case("Online"):
                    Status = NodeStatus.ONLINE;
                    break;
                case("Offline"):
                    Status = NodeStatus.OFFLINE;
                    break;
            }
            
            tempSensorList[counter] = new Sensor(IDNumber, SType, Status, loc, new ArrayList(0), new ArrayList(0)) {
                @Override
                public void detectParticle(Particle[] p) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void decodeParticle() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            
            counter++;
            
            }
        
        return tempSensorList;
        
    }
    
    public static void displaySensors() throws SQLException, ClassNotFoundException{
        System.out.println("^^^SENSORS^^^");
        System.out.println("ID\tTYPE\t\tSTATUS\tLocation");
        System.out.println("________________________________________");
        Sensor[] temp = createDBSensors();
        for(int i = 0; i < temp.length; i++){
            if(i % 3 == 0){
                System.out.println();
            }
            System.out.print(temp[i].getIDNumber() + "\t" + temp[i].getSensorType() 
            + "\t" + temp[i].getSensorStatus() + "\t(" + temp[i].getLocation().getX()
            + "," + temp[i].getLocation().getY() + "," + temp[i].getLocation().getZ()
            + ")\t");
        }
        System.out.println();
    }
}
