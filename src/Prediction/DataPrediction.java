/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prediction;

import Analysis.DataAnalytics;
import Globals.Predictions;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author 23554853
 */
public class DataPrediction {
    public static void predictParticleAggregation(DataAnalytics da){
        if(da.getAnalysisValues()[0] > 0 && da.getAnalysisValues()[0] <= 1000){
            Predictions temp1 = Predictions.Prediction1;
            
            JFrame jfrm1 = new JFrame("PARTICLE PREDICTION");
            jfrm1.getContentPane().setLayout(new FlowLayout());
            jfrm1.setSize(500, 100);
                        
            JTextArea text = new JTextArea("Detected Particles are expected to have " +
                    temp1.getClassification() +"\n" + temp1.getValue() + " particle aggregate "
                            + "per cubic meter");
            jfrm1.getContentPane().add(text);
            jfrm1.setVisible(true);
            
        }else if(da.getAnalysisValues()[0] > 1000 && da.getAnalysisValues()[0] <= 2000){
            Predictions temp2 = Predictions.Prediction2;
            
            JFrame jfrm2 = new JFrame("PARTICLE PREDICTION");
            jfrm2.getContentPane().setLayout(new FlowLayout());
            jfrm2.setSize(500, 100);
                        
            JTextArea text = new JTextArea("Detected Particles are expected to have " +
                    temp2.getClassification() +"\n" + temp2.getValue() + " particle aggregate "
                            + "per cubic meter");
            jfrm2.getContentPane().add(text);
            jfrm2.setVisible(true);
            
        }else if(da.getAnalysisValues()[0] > 2000){
            Predictions temp3 = Predictions.Prediction3;
            
            JFrame jfrm3 = new JFrame("PARTICLE PREDICTION");
            jfrm3.getContentPane().setLayout(new FlowLayout());
            jfrm3.setSize(500, 100);
                        
            JTextArea text = new JTextArea("Detected Particles are expected to have " +
                    temp3.getClassification() +"\n" + temp3.getValue() + " particle aggregate "
                            + "per cubic meter");
            jfrm3.getContentPane().add(text);
            jfrm3.setVisible(true);
        }
    }
}
