/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperTrunfoIA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author alexandre
 */
public class Queue {
    
    private final ArrayList<Card> gameQueue     = new ArrayList<>();
    private final ArrayList<Card> playerQueue   = new ArrayList<>();
    private final ArrayList<Card> computerQueue = new ArrayList<>();
    
    public void buildGameQueue(String path) {
        
        File fil = new File(path);
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(fil));
            int cont = 0;
            int key  = 0;
            String line;
            Card cr = new Card();           

            
            while(br.ready()){                
                
                
                line = br.readLine();
                
                switch (cont) {
                    
                    case 0: cr.setCardName(line);
                            cr.setCardKey(key);
                            key++;
                            cont++;
                            break;
                        
                    case 1: cr.setMatchNumber(Integer.parseInt(line));
                            cont++;
                            break;
                    
                    case 2: cr.setWinNumber(Integer.parseInt(line));
                            cont++;
                            break;
                    
                    case 3: cr.setDefeatNumber(Integer.parseInt(line));
                            cont++;
                            break;  
                        
                    case 4: cr.setGoalScoredNumber(Integer.parseInt(line));
                            cont++;
                            break; 
                    
                    case 5: cr.setGoalConcededNumber(Integer.parseInt(line));
                            gameQueue.add(cr); 
                            cr = new Card();
                            cont = 0;
                            break;
                    
                }            
                             
                
            }         
            
            
        } catch (FileNotFoundException ex) {
            
            System.out.println("File not found " + ex);
            
        } catch (IOException ex) {
            
           System.out.println("Line error " + ex);
           
        }
        
        
    }
    
    public void buildPlayerQueue(Card cr) {
        
        playerQueue.add(cr);
        
    }
    
       
    public void buildComputerQueue(Card cr) {
        
        computerQueue.add(cr);
        
    }
    
    public boolean checkGameQueue(Card cr) {
        
        return gameQueue.contains(cr);        
        
    }
    
    public boolean checkPlayerQueue(Card cr) {
        
        return playerQueue.contains(cr);        
        
    }
    
     public boolean checkComputerQueue(Card cr) {
        
        return computerQueue.contains(cr);        
        
    }
     
    public int getSizeGameQueue() {
        
        return gameQueue.size();
        
    }
    
     public int getSizePlayerQueue() {
        
        return playerQueue.size();
        
    }
     
     public int getSizeComputerQueue() {
        
        return computerQueue.size();
        
    }
    
    public Card getGameQueueElement(int index) {
        
        return gameQueue.get(index);
        
    }
    
    public ArrayList getGameQueue() {
        
        return gameQueue;
        
    }
    
     public ArrayList getPlayerQueue() {
        
        return playerQueue;
        
    }
    
    public ArrayList getComputerQueue() {
        
        return computerQueue;
        
    }
    
}
