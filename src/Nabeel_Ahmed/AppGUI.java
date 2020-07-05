/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nabeel_Ahmed;

import Analysis.DataAnalytics;
import Analysis.DataAnalyticsA;
import Analysis.DataAnalyticsB;
import Analysis.DataAnalyticsC;
import Environment.Particle;
import Factory.DataAnalysisNodeFactory;
import Factory.DataFusionNodeFactory;
import Factory.ParticleFactory;
import Sensors.Sensor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import Factory.SensorFactory;
import Fusion.DataFusion;
import Fusion.DataFusionA;
import Fusion.DataFusionB;
import Fusion.DataFusionC;
import Prediction.DataPrediction;
import Sensors.SensorA;
import Sensors.SensorB;
import Sensors.SensorC;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 23554853
 */
public class AppGUI {

    public static void create() throws SQLException, ClassNotFoundException{
        Sensor[] s = SensorFactory.createDBSensors();
        Particle[] p = ParticleFactory.createDBParticles();
        DataFusion[] df = DataFusionNodeFactory.createDBFusionNodes();
        DataAnalytics[] da = DataAnalysisNodeFactory.createDBAnalysisNodes();
        ArrayList<SensorA> AList = new ArrayList(0);
        ArrayList<SensorB> BList = new ArrayList(0);
        ArrayList<SensorC> CList = new ArrayList(0);
        ArrayList<DataFusionA> DFAList = new ArrayList(0);
        ArrayList<DataFusionB> DFBList = new ArrayList(0);
        ArrayList<DataFusionC> DFCList = new ArrayList(0);
        ArrayList<DataAnalyticsA> DAAList = new ArrayList(0);
        ArrayList<DataAnalyticsB> DABList = new ArrayList(0);
        ArrayList<DataAnalyticsC> DACList = new ArrayList(0);
        
        
        for(int i = 0; i < s.length; i++){
            switch(s[i].getSensorType()){
                case Sensor_A:
                    AList.add(new SensorA(s[i].getIDNumber(), s[i].getSensorType(), s[i].getSensorStatus(),
                    s[i].getLocation(),s[i].getDetectedParticles(), s[i].getDecodedParticles()));
                    break;
                case Sensor_B:
                    BList.add(new SensorB(s[i].getIDNumber(), s[i].getSensorType(), s[i].getSensorStatus(),
                    s[i].getLocation(),s[i].getDetectedParticles(), s[i].getDecodedParticles()));
                    break;
                case Sensor_C:
                    CList.add(new SensorC(s[i].getIDNumber(), s[i].getSensorType(), s[i].getSensorStatus(),
                    s[i].getLocation(),s[i].getDetectedParticles(), s[i].getDecodedParticles()));
                    break;
                }
        }
        
        for(int i = 0; i < df.length; i++){
            switch(df[i].getNodeID()){
                case "DFA-1":
                    DFAList.add(new DataFusionA(df[i].getNodeID(), df[i].getLocation(), df[i].getCodeBuffer(),df[i].getFusedBuffer()));
                    break;
                case "DFB-1":
                    DFBList.add(new DataFusionB(df[i].getNodeID(), df[i].getLocation(), df[i].getCodeBuffer(),df[i].getFusedBuffer()));
                    break;
                case "DFC-1":
                    DFCList.add(new DataFusionC(df[i].getNodeID(), df[i].getLocation(), df[i].getCodeBuffer(),df[i].getFusedBuffer()));
                    break;
                }
        }
        
        for(int i = 0; i < da.length; i++){
            switch(da[i].getNodeID()){
                case "DAA-1":
                    DAAList.add(new DataAnalyticsA(da[i].getNodeID(), da[i].getLocation(), da[i].getFilebuffer(),da[i].getAnalysisValues()));
                    break;
                case "DAB-1":
                    DABList.add(new DataAnalyticsB(da[i].getNodeID(), da[i].getLocation(), da[i].getFilebuffer(),da[i].getAnalysisValues()));
                    break;
                case "DAC-1":
                    DACList.add(new DataAnalyticsC(da[i].getNodeID(), da[i].getLocation(), da[i].getFilebuffer(),da[i].getAnalysisValues()));
                    break;
                }
        }
        
        
        JFrame jfrm = new JFrame("SENSOR NETWORK");
        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setSize(1400, 100);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton jbtn1 = new JButton("Display Sensors");
        JButton jbtn2 = new JButton("Display Particles");
        JButton jbtn3 = new JButton("Display Fusion Nodes");
        JButton jbtn4 = new JButton("Display Analysis Nodes");
        JButton jbtn5 = new JButton("Detect Particles");
        JButton jbtn6 = new JButton("Transmit Sensor Data");
        JButton jbtn7 = new JButton("Fuse Sensor Data");
        JButton jbtn8 = new JButton("Analyze Sensor Data");
        JButton jbtn9 = new JButton("PREDICT");
        
        
        jfrm.getContentPane().add(jbtn1);
        jfrm.getContentPane().add(jbtn2);
        jfrm.getContentPane().add(jbtn3);
        jfrm.getContentPane().add(jbtn4);
        jfrm.getContentPane().add(jbtn5);
        jfrm.getContentPane().add(jbtn6);
        jfrm.getContentPane().add(jbtn7);
        jfrm.getContentPane().add(jbtn8);
        jfrm.getContentPane().add(jbtn9);
        jfrm.setVisible(true);
        
        jbtn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                  SensorFactory.displaySensors();
                } catch (SQLException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
        });
        
        jbtn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ParticleFactory.displayParticles();
                } catch (SQLException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        jbtn3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DataFusionNodeFactory.displayFusionNodes();
                } catch (SQLException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        jbtn4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DataAnalysisNodeFactory.displayAnalysisNodes();
                } catch (SQLException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        jbtn5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    for(SensorA a : AList){
                        a.detectParticle(p);
                        a.displayDetectedParticles();
                    }
                    for(SensorB b : BList){
                        b.detectParticle(p);
                        b.displayDetectedParticles();
                    }
                    for(SensorC c : CList){
                        c.detectParticle(p);
                        c.displayDetectedParticles();
                    }
            }
            
        });
        
        jbtn6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(SensorA a : AList){
                    
                    a.decodeParticle();
                    if(a.isTransmittingAuthority()){
                        a.sendDataToFusionNode(DFAList.get(0));
                    }
                }
                for(SensorB b : BList){
                    
                    b.decodeParticle();
                    if(b.isTransmittingAuthority()){
                        b.sendDataToFusionNode(DFBList.get(0));
                    }
                }
                for(SensorC c : CList){
                    
                    c.decodeParticle();
                    if(c.isTransmittingAuthority()){
                        c.sendDataToFusionNode(DFCList.get(0));
                    }
                }
            }
            
        });
        
        jbtn7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(DataFusionA DFA : DFAList){
                    DFA.processSensorData();
                }
                for(DataFusionB DFB : DFBList){
                    DFB.processSensorData();
                }
                for(DataFusionC DFC : DFCList){
                    DFC.processSensorData();
                }
            }
            
        });
        
        jbtn8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(DataAnalyticsA DAA : DAAList){
                    DAA.writeDataToFile();
                }
                for(DataAnalyticsB DAB : DABList){
                    DAB.writeDataToFile();
                }
                for(DataAnalyticsC DAC : DACList){
                    DAC.writeDataToFile();
                }
            }
            
        });
        
        jbtn9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(DataAnalytics d : da){
                    DataPrediction.predictParticleAggregation(d);
                }
            }
            
        });
    }
    
}
