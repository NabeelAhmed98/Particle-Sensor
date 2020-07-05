/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Analysis.DataAnalytics;
import DBSupport.DBConnection;
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
public class DataAnalysisNodeFactory {
    public static DataAnalytics[] createDBAnalysisNodes() throws SQLException, ClassNotFoundException{
        int counter = 0; int count = 0;
        
        DBConnection db = new DBConnection();
        Connection con = db.establishDBConnection();
        Statement useS = con.createStatement();
        useS.executeQuery("USE tachyon");
       
        String countQuery = "SELECT COUNT(ANode) AS COUNT from analysisnodes;";
        Statement countS = con.createStatement();
        ResultSet queryCount = countS.executeQuery(countQuery);
        while(queryCount.next()){
            count = queryCount.getInt("COUNT");
        }
        
        String ANodeRetrievalQuery = "SELECT *\n" +
                                      "FROM analysisnodes\n" +
                                      "ORDER BY ANode;";
        
        Statement queryStatement = con.createStatement();
        ResultSet queryResult = queryStatement.executeQuery(ANodeRetrievalQuery);
        
        DataAnalytics[] tempAnalyticsList = new DataAnalytics[count];
        
        while(queryResult.next()){
            String IDNumber = queryResult.getString("ANode");
            int x = queryResult.getInt("XCoord");
            int y = queryResult.getInt("YCoord");
            int z = queryResult.getInt("ZCoord");
            
            Location loc = new Location(x, y, z);
            
            tempAnalyticsList[counter] = new DataAnalytics(IDNumber, loc, new ArrayList(), new double[4]) {
                @Override
                public void readFusedData() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void AnalyzeFusedData() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void writeDataToFile() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            
            counter++;
        }
        
        return tempAnalyticsList;
        
    }
    
    public static void displayAnalysisNodes() throws SQLException, ClassNotFoundException{
        System.out.println("^^^FUSION NODES^^^");
        System.out.println("ID\t\tLocation");
        System.out.println("_______________________________");
        DataAnalytics[] temp = createDBAnalysisNodes();
        for(int i = 0; i < temp.length; i++){
            System.out.println("NodeID: " + temp[i].getNodeID() + " Location: " + 
            "(" + temp[i].getLocation().getX()
            + "," + temp[i].getLocation().getY() + "," + temp[i].getLocation().getZ()
            + ")");
        }
    }
}
