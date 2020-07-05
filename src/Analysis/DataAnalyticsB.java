/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analysis;

import GeoLocation.Location;
import Globals.Analyzable;
import Globals.Fusionable;
import static StatsSupport.JStats.muArrayList;
import static StatsSupport.JStats.sigma2ArrayList;
import static StatsSupport.JStats.sigmaArrayList;
import static StatsSupport.JStats.sumArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 23554853
 */
public class DataAnalyticsB extends DataAnalytics{

    public DataAnalyticsB(String NodeID, Location location, ArrayList<Integer> filebuffer, double[] analysisValues) {
        super(NodeID, location, filebuffer, analysisValues);
    }

    

    @Override
    public void readFusedData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(Fusionable.FILEB));
            String line = br.readLine();
            while(line != null){
                int temp = 0;
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) != ' '){
                        temp += Character.getNumericValue(line.charAt(i));
                    }
                }
                getFilebuffer().add(temp);
                line = br.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataAnalyticsA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataAnalyticsA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void AnalyzeFusedData() {
        double[] temp = this.getAnalysisValues();
        temp[0] = sumArrayList(this.getFilebuffer());
        temp[1] = muArrayList(this.getFilebuffer());
        temp[2] = sigmaArrayList(this.getFilebuffer());
        temp[3] = sigma2ArrayList(this.getFilebuffer());
        
        setAnalysisValues(temp);
        
    }

    @Override
    public void writeDataToFile() {
        try {
            readFusedData();
            AnalyzeFusedData();
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(Analyzable.FILEAB));
            bw.write("SENSOR B ANALYSIS\n");
            bw.write("__________________________________________\n");
            bw.write("SENSOR SUM: " + this.getAnalysisValues()[0] + "\n");
            bw.write("SENSOR AVERAGE: " + this.getAnalysisValues()[1] + "\n");
            bw.write("SENSOR VARIANCE: " + this.getAnalysisValues()[3] + "\n");
            bw.write("SENSOR STANDARD DEVIATION: " + this.getAnalysisValues()[2] + "\n");
            bw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(DataAnalyticsA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
}
