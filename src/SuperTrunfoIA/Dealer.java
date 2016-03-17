/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperTrunfoIA;

import java.util.ArrayList;

/**
 *
 * @author alexandre
 */
public class Dealer {
    
    private final int ZERO = 0;
    
    public void biuldHand(Queue qu) {       
        
        
        ArrayList<Card> localListCard = new ArrayList<>();
        ArrayList<String>  indexSet        = new ArrayList<String>();
        Card aux = new Card();
        int randNumber  = ZERO;
        boolean insert = true;
        
        localListCard = qu.getGameQueue();
        
        while (indexSet.size() < qu.getSizeGameQueue()) {
            
            randNumber = (int) (Math.random()*32);
            
            if(insert) {
                
                if (!indexSet.contains(String.valueOf(randNumber))) {
                    
                    indexSet.add(String.valueOf(randNumber));
                    qu.buildPlayerQueue(qu.getGameQueueElement(randNumber));
                    aux = qu.getGameQueueElement(randNumber);
                    insert = false;
                    
                }
                
                
            } else {
                
                if (!indexSet.contains(String.valueOf(randNumber))) {
                    
                    indexSet.add(String.valueOf(randNumber));
                    qu.buildComputerQueue(qu.getGameQueueElement(randNumber));
                    aux = qu.getGameQueueElement(randNumber);
                    insert = true;
                    
                }
                
                
            }  
            
        }    
                
    }
    
}
