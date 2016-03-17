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
public class SuperTrunfoIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue que = new Queue();   
        Dealer de = new Dealer(); 
        Game   ga = new Game();
                
        //que.buildGameQueue("/home/alexandre/Dropbox/netbeansproject/SuperTrunfoIA/palmeiras"); 
        que.buildGameQueue("/home/guilherme/SuperTrunfo");
        de.biuldHand(que);
        ga.controlRound(que);
        
        
    }
    
}
