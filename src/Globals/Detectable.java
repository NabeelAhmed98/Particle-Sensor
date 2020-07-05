/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globals;

import Environment.Particle;
import Fusion.DataFusion;

/**
 *
 * @author 23554853
 */
public interface Detectable {
    
    public void detectParticle(Particle[] p);
    public void decodeParticle();
    public void sendDataToFusionNode(DataFusion df);
}
