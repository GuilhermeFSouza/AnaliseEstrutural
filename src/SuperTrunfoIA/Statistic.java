package SuperTrunfoIA;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author alexandre
 */



public class Statistic {
    
    private final int ZERO      = 0;
    private final double CEM    = 100.0;
    private final double ZEROD  = 0.0;
    private final int SIZEARRAY = 6; 
    
    public int [] sourtListCalcProb(Queue que, String year) {
        
        int out[] = new int[SIZEARRAY];
        int size         = que.getSizeGameQueue();
        int match        = ZERO;
        int win          = ZERO;
        int def          = ZERO;
        int sco          = ZERO;
        int con          = ZERO;
        double matchTot  = ZEROD;
        double winTot    = ZEROD;        
        double defTot    = ZEROD;       
        double scoTot    = ZEROD;        
        double conTot    = ZEROD;
        double total     = size - 1;
        
        ArrayList<Card> localQue = que.getGameQueue();
        Card aux = new Card();
                
        for (int i = 0; i < size; i++) {
            
            aux = localQue.get(i);
            
            if (aux.getCardName().equals(year)) {
                
                match = aux.getMatchNumber();
                win   = aux.getWinNumber();
                def   = aux.getDefeatNumber();
                sco   = aux.getGoalScoredNumber();
                con   = aux.getGoalConcededNumber();
                break;
                
            }
            
        }   
        
        for (int i = 0; i < size; i++) {
            
            aux = localQue.get(i);
            
            if (!aux.getCardName().equals(year) && match >= aux.getMatchNumber()) {
                matchTot++;
            }
            
            if (!aux.getCardName().equals(year) && win >= aux.getWinNumber()) {
                winTot++;
            }
            
            if (!aux.getCardName().equals(year) && def <= aux.getDefeatNumber()) {
                defTot++;
            }
            
            if (!aux.getCardName().equals(year) && sco >= aux.getGoalScoredNumber()) {
                scoTot++;
            }
            
            if (!aux.getCardName().equals(year) && con <= aux.getGoalConcededNumber()) {
                conTot++;
            }
            
        }
        
        out[0]  = (int)(matchTot/total * CEM);
        out[1]  = (int)(winTot/total   * CEM);
        out[2]  = (int)(defTot/total   * CEM);
        out[3]  = (int)(scoTot/total   * CEM);
        out[4]  = (int)(conTot/total   * CEM);       
            
       return out;
       
    }
    

    
}
