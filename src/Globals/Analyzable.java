/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globals;

/**
 *
 * @author 23554853
 */
public interface Analyzable {
    String FILEAA = "C:\\Users\\nabee\\Documents\\NetBeansProjects\\Nabeel_Ahmed_Exam_2\\src\\DataFiles\\AnalyzedA.txt";
    String FILEAB = "C:\\Users\\nabee\\Documents\\NetBeansProjects\\Nabeel_Ahmed_Exam_2\\src\\DataFiles\\AnalyzedB.txt";
    String FILEAC = "C:\\Users\\nabee\\Documents\\NetBeansProjects\\Nabeel_Ahmed_Exam_2\\src\\DataFiles\\AnalyzedC.txt";
    
    public void readFusedData();
    
    public void AnalyzeFusedData();
    
    public void writeDataToFile();
}
