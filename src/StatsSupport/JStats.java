/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatsSupport;

import java.util.ArrayList;

/**
 *
 * @author 23554853
 */
public class JStats {
    public static double sumArrayList(ArrayList<Integer> a){
        double temp = 0.0;
        for(Integer num : a){
            temp += num;
        }
        return temp;
    }
    public static double muArrayList(ArrayList<Integer> a){
        double temp = sumArrayList(a);
        int counter = 0;
        for(Integer num : a){
            counter++;
            
        }
        temp = temp / counter;
        
        return temp;
    }
    public static double sigma2ArrayList(ArrayList<Integer> a){
        double temp = sigmaArrayList(a);
        temp = Math.pow(temp, 2);
        return temp;
    }
    public static double sigmaArrayList(ArrayList<Integer> a){
        double temp = muArrayList(a);
        double temp2 = 0.0;
        for(Integer num : a){
            temp2 += Math.pow((num - temp), 2);
        }
        int counter = 0;
        for(Integer num : a){
            counter++;
        }
        temp2 = temp2 / counter;
        
        temp2 = Math.sqrt(temp2);
        
        return temp2;
    }
    
}
