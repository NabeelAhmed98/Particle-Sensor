/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fusion;

import GeoLocation.Location;
import Globals.Fusionable;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 23554853
 */
public class DataFusionB extends DataFusion{

    public DataFusionB(String NodeID, Location location, ArrayList<ArrayList<Integer>> codeBuffer, ArrayList<Integer> fusedBuffer) {
        super(NodeID, location, codeBuffer, fusedBuffer);
    }

    

    @Override
    public void writeDataToFile() {
        try {
            int counter  = 0;
            BufferedWriter bw = new BufferedWriter(new FileWriter(Fusionable.FILEB));
           for(int i = 0; i < this.getFusedBuffer().size(); i++){
                counter++;
                int temp = getFusedBuffer().get(i);
                bw.write(temp + " ");
                
                
                if((counter) % 10 == 0){
                    bw.write("\n");
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(DataFusionA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
