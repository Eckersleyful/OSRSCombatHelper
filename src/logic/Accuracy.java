/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Ilmari
 */
public class Accuracy {
    
    
    public static double calculateMeleeAccuracy(double meleeBonus, double meleeDefence){
        if(meleeBonus<meleeDefence){
            return (meleeBonus/(2*meleeDefence+1));
        }
        else{
            return (1-(meleeDefence/(2*meleeBonus+1)));
        }
    }
    public static double calculateRangeAccuracy(double rangeBonus, double rangeDefence){
        if(rangeBonus<rangeDefence){
            return (rangeBonus/(2*rangeDefence+1));
        }
        else{
            return (1-(rangeDefence/(2*rangeBonus+1)));
        }
    }
    public static double calculateMagicAccuracy(double mageBonus, double mageDefence, double magicAttack){
        return 1;
    }
    
}
