/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperTrunfoIA;

/**
 *
 * @author alexandre
 */
public class Card {
    
    public Card(){
        
        cardKey            = 0;
        cardName           = null;
        winNumber          = 0;
        matchNumber        = 0;
        defeatNumber       = 0;
        goalScoredNumber   = 0;
        goalConcededNumber = 0;
        
    }
    
    private int    cardKey;
    private String cardName;
    private int    matchNumber;
    private int    winNumber;
    private int    defeatNumber;
    private int    goalScoredNumber;
    private int    goalConcededNumber;
    
    public int getCardKey(){
        
        return cardKey;
        
    }
    
    public void setCardKey(int key){
        
        cardKey = key;
        
    }    
    
    public String getCardName(){
        
        return cardName;
        
    }
    
    public void setCardName(String str){
        
        cardName = str;
        
    }    
    
    public int getMatchNumber(){
        
        return matchNumber;
        
    }
    
    public void setMatchNumber(int num){
        
        matchNumber = num;
        
    }
    
    public int getWinNumber(){
        
        return winNumber;
        
    }
    
    public void setWinNumber(int num){
        
        winNumber = num;
        
    }
    
    public int getDefeatNumber(){
        
        return defeatNumber;
        
    }
    
    public void setDefeatNumber(int num){
        
        defeatNumber = num;
        
    }
    
    public int getGoalScoredNumber(){
        
        return goalScoredNumber;
        
    }
    
    public void setGoalScoredNumber(int num){
        
        goalScoredNumber = num;
        
    }
    
    public int getGoalConcededNumber(){
        
        return goalConcededNumber;
        
    }
    
    public void setGoalConcededNumber(int num){
        
        goalConcededNumber = num;
        
    }
    
}
