/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DBSupport.DBConnection;
import Fusion.DataFusion;
import GeoLocation.Location;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 23554853
 */
public class DataFusionNodeFactory {
    public static DataFusion[] createDBFusionNodes() throws SQLException, ClassNotFoundException{
        int counter = 0; int count = 0;
        
        DBConnection db = new DBConnection();
        Connection con = db.establishDBConnection();
        Statement useS = con.createStatement();
        useS.executeQuery("USE tachyon");
       
        String countQuery = "SELECT COUNT(FNode) AS COUNT from fusionnodes;";
        Statement countS = con.createStatement();
        ResultSet queryCount = countS.executeQuery(countQuery);
        while(queryCount.next()){
            count = queryCount.getInt("COUNT");
        }
        
        String FNodeRetrievalQuery = "SELECT *\n" +
                                      "FROM fusionnodes\n" +
                                      "ORDER BY FNode;";
        
        Statement queryStatement = con.createStatement();
        ResultSet queryResult = queryStatement.executeQuery(FNodeRetrievalQuery);
        
        DataFusion[] tempDataFusionList = new DataFusion[count];
        
        while(queryResult.next()){
            String IDNumber = queryResult.getString("FNode");
            int x = queryResult.getInt("XCoord");
            int y = queryResult.getInt("YCoord");
            int z = queryResult.getInt("ZCoord");
            
            Location loc = new Location(x, y, z);
            
            tempDataFusionList[counter] = new DataFusion(IDNumber, loc, new ArrayList(0), new ArrayList(0)) {
                @Override
                public void writeDataToFile() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            
            counter++;
        }
        
        return tempDataFusionList;
        
    }
    
    public static void displayFusionNodes() throws SQLException, ClassNotFoundException{
        System.out.println("^^^FUSION NODES^^^");
        System.out.println("ID\t\tLocation");
        System.out.println("_______________________________");
        DataFusion[] temp = createDBFusionNodes();
        for(int i = 0; i < temp.length; i++){
            System.out.println("NodeID: " + temp[i].getNodeID() + " Location: " + 
            "(" + temp[i].getLocation().getX()
            + "," + temp[i].getLocation().getY() + "," + temp[i].getLocation().getZ()
            + ")");
        }
    }
}
