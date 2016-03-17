 
package SuperTrunfoIA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandre
 */


public class Game {
    
    private final int ZERO = 0;
    
    public void controlRound(Queue qu) {
        
        Runtime run = Runtime.getRuntime();
        Scanner input = new Scanner (System.in);
        ArrayList<Card> playerDeck = qu.getPlayerQueue();
        ArrayList<Card> computDeck = qu.getComputerQueue();
        Card auxPlayer = new Card();
        Card auxComput = new Card();
        boolean player = false;
        boolean comp = false;
        boolean win  = false;
        boolean lose = false;
        int[] prob   = new int[5];
        String choose = "";
        int round = 1;
                
        if (Game.startGame()) {
            player = true;
        } else {
            comp = true;
        }
        
        System.out.println("Começa o jogo...");
        
        while(playerDeck.size() > 0 && computDeck.size() > 0) {
            
            if(player) {
                
                System.out.println("Rodade " + round);
                round++;
                System.out.println("Jogador...");
                System.out.println("Numero de cartas Jogador " + playerDeck.size());
                System.out.println("Numero de cartas Computador " + computDeck.size());
                auxPlayer = playerDeck.get(ZERO);
                auxComput = computDeck.get(ZERO);
                
                System.out.println("Carta Jogador");
                System.out.println("Ano        =>"     + auxPlayer.getCardName());
                System.out.println("Partida  1 =>"     + auxPlayer.getMatchNumber());
                System.out.println("Vitorias 2 =>"     + auxPlayer.getWinNumber());
                System.out.println("Derrotas 3 =>"     + auxPlayer.getDefeatNumber());
                System.out.println("Gols Pro 4 =>"     + auxPlayer.getGoalScoredNumber());
                System.out.println("Gols Con 5 =>"     + auxPlayer.getGoalConcededNumber());
                System.out.print("Digite sua escolha: ");
                choose = input.nextLine();
                try {
                    run.exec("clear");
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(choose.equals("1")) {
                    
                    if (auxPlayer.getMatchNumber() < auxComput.getMatchNumber()) {
                        
                        System.out.println("Computador joga - Partidas " + auxComput.getMatchNumber());
                        System.out.println("Jogador joga - Partidas " + auxPlayer.getMatchNumber());
                        System.out.println("Computador Vence - Partidas ");
                        System.out.print("Digite enter para continuar: ");
                        choose = input.nextLine();
                        playerDeck.remove(auxPlayer);
                        computDeck.remove(auxComput);
                        computDeck.add(auxPlayer);
                        computDeck.add(auxComput);
                        comp = true;
                        player = false;
                        
                    } else {
                        
                        if (auxPlayer.getMatchNumber() > auxComput.getMatchNumber()) {
                            
                            System.out.println("Computador joga - Partidas " + auxComput.getMatchNumber());
                        System.out.println("Jogador joga - Partidas " + auxPlayer.getMatchNumber());
                        System.out.println("Jogador Vence - Partidas ");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            playerDeck.add(auxComput);
                            comp = false;
                            player = true;                            
                            
                        } else {
                            
                            System.out.println("Computador joga - Partidas " + auxComput.getMatchNumber());
                            System.out.println("Jogador joga - Partidas " + auxPlayer.getMatchNumber());
                            System.out.println("Empate " + auxComput.getMatchNumber());
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            computDeck.add(auxComput);
                            comp   = false;
                            player = true;
                            
                        }                   
                        
                    }
                    
                }
                
                if(choose.equals("2")) {
                    
                    if (auxPlayer.getWinNumber() < auxComput.getWinNumber()) {
                        
                        System.out.println("Computador joga - Vitorias " + auxComput.getWinNumber());
                        System.out.println("Jogador joga    - Vitorias " + auxPlayer.getWinNumber());
                        System.out.println("Computador Vence ");
                        playerDeck.remove(auxPlayer);
                        computDeck.remove(auxComput);
                        computDeck.add(auxPlayer);
                        computDeck.add(auxComput);
                        comp = true;
                        player = false;
                        
                    } else {
                        
                        if (auxPlayer.getWinNumber() > auxComput.getWinNumber()) {
                            
                            System.out.println("Computador joga - Vitorias " + auxComput.getWinNumber());
                            System.out.println("Jogador joga    - Vitorias " + auxPlayer.getWinNumber());
                            System.out.println("Jogador Vence ");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            playerDeck.add(auxComput);
                            comp = false;
                            player = true;                            
                            
                        } else {
                            
                            System.out.println("Computador joga - Vitorias " + auxComput.getWinNumber());
                            System.out.println("Jogador joga    - Vitorias " + auxPlayer.getWinNumber());
                            System.out.println("Empate " );
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            computDeck.add(auxComput);
                            comp   = false;
                            player = true;
                        }                   
                        
                    }
                    
                }
                
                if(choose.equals("3")) {
                    
                    if (auxPlayer.getDefeatNumber() > auxComput.getDefeatNumber()) {
                        
                        System.out.println("Computador joga - Derrotas " + auxComput.getDefeatNumber());
                        System.out.println("Jogador joga    - Derrotas " + auxPlayer.getDefeatNumber());
                        System.out.println("Computador Vence");
                        playerDeck.remove(auxPlayer);
                        computDeck.remove(auxComput);
                        computDeck.add(auxPlayer);
                        computDeck.add(auxComput);
                        comp = true;
                        player = false;
                        
                    } else {
                        
                        if (auxPlayer.getDefeatNumber() < auxComput.getDefeatNumber()) {
                            
                            System.out.println("Computador joga - Derrotas " + auxComput.getDefeatNumber());
                            System.out.println("Jogador joga    - Derrotas " + auxPlayer.getDefeatNumber());
                            System.out.println("Jogador Vence");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            playerDeck.add(auxComput);
                            comp = false;
                            player = true;                            
                            
                        } else {
                            
                            System.out.println("Computador joga - Derrotas " + auxComput.getDefeatNumber());
                            System.out.println("Jogador joga    - Derrotas " + auxPlayer.getDefeatNumber());
                            System.out.println("Empate " + auxComput.getDefeatNumber());
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            computDeck.add(auxComput);
                            comp   = false;
                            player = true;
                        }                   
                        
                    }
                    
                }
                
                if(choose.equals("4")) {
                    
                    if (auxPlayer.getGoalScoredNumber() < auxComput.getGoalScoredNumber()) {
                        
                        System.out.println("Computador joga - Gols pro " + auxComput.getGoalScoredNumber());
                        System.out.println("Jogador joga    - Gols pro " + auxPlayer.getGoalScoredNumber());
                        System.out.println("Computador Vence");
                        playerDeck.remove(auxPlayer);
                        computDeck.remove(auxComput);
                        computDeck.add(auxPlayer);
                        computDeck.add(auxComput);
                        comp = true;
                        player = false;
                        
                    } else {
                        
                        if (auxPlayer.getGoalScoredNumber() > auxComput.getGoalScoredNumber()) {
                            
                            System.out.println("Computador joga - Gols pro " + auxComput.getGoalScoredNumber());
                        System.out.println("Jogador joga    - Gols pro " + auxPlayer.getGoalScoredNumber());
                        System.out.println("Jogador Vence");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            playerDeck.add(auxComput);
                            comp = false;
                            player = true;                            
                            
                        } else {
                            
                            System.out.println("Computador joga - Gols pro " + auxComput.getGoalScoredNumber());
                            System.out.println("Jogador joga    - Gols pro " + auxPlayer.getGoalScoredNumber());
                            System.out.println("Empate  " );
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            computDeck.add(auxComput);
                            comp   = false;
                            player = true;
                        }                   
                        
                    }
                    
                }
                
                if(choose.equals("5")) {
                    
                    if (auxPlayer.getGoalConcededNumber() > auxComput.getGoalConcededNumber()) {
                        
                        System.out.println("Computador joga - Gols Contra " + auxComput.getGoalConcededNumber());
                        System.out.println("Jogador joga    - Gols Contra " + auxPlayer.getGoalConcededNumber());
                        System.out.println("Computador Vence");
                        playerDeck.remove(auxPlayer);
                        computDeck.remove(auxComput);
                        computDeck.add(auxPlayer);
                        computDeck.add(auxComput);
                        comp = true;
                        player = false;
                        
                    } else {
                        
                        if (auxPlayer.getGoalConcededNumber() < auxComput.getGoalConcededNumber()) {
                            
                            System.out.println("Computador joga - Gols Contra " + auxComput.getGoalConcededNumber());
                        System.out.println("Jogador joga    - Gols Contra " + auxPlayer.getGoalConcededNumber());
                        System.out.println("Jogador Vence");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            playerDeck.add(auxComput);
                            comp = false;
                            player = true;                            
                            
                        } else {
                            
                            System.out.println("Computador joga - Gols Contra " + auxComput.getGoalConcededNumber());
                        System.out.println("Jogador joga    - Gols Contra " + auxPlayer.getGoalConcededNumber());
                        System.out.println("Empate " );
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            computDeck.add(auxComput);
                            comp   = false;
                            player = true;
                        }                   
                        
                    }
                    
                }
                
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                
            } 
            
            if(comp) {
                
                Statistic stat = new Statistic();
                //Queue que = new Queue();
                int max;
                int index = 0;
                auxPlayer = playerDeck.get(ZERO);
                auxComput = computDeck.get(ZERO);
                
                prob = stat.sourtListCalcProb(qu, auxComput.getCardName());
                max = prob[0];
                
                System.out.println("Rodade " + round);
                round++;
                System.out.println("Computador...");
                System.out.println("Numero de cartas Computador " + computDeck.size());
                System.out.println("Carta Computador");
                System.out.println("Ano        =>"     + auxComput.getCardName());
                System.out.println("Partida  1 =>"     + auxComput.getMatchNumber());
                System.out.println("Vitorias 2 =>"     + auxComput.getWinNumber());
                System.out.println("Derrotas 3 =>"     + auxComput.getDefeatNumber());
                System.out.println("Gols Pro 4 =>"     + auxComput.getGoalScoredNumber());
                System.out.println("Gols Con 5 =>"     + auxComput.getGoalConcededNumber());
                
                System.out.println("Carta Jogador");
                System.out.println("Numero de cartas Jogador " + playerDeck.size());
                System.out.println("Ano        =>"     + auxPlayer.getCardName());
                System.out.println("Partida  1 =>"     + auxPlayer.getMatchNumber());
                System.out.println("Vitorias 2 =>"     + auxPlayer.getWinNumber());
                System.out.println("Derrotas 3 =>"     + auxPlayer.getDefeatNumber());
                System.out.println("Gols Pro 4 =>"     + auxPlayer.getGoalScoredNumber());
                System.out.println("Gols Con 5 =>"     + auxPlayer.getGoalConcededNumber());               
                
                
                for(int i =0; i < prob.length; i++) {
                    
                    if(max < prob[i]) {
                        index = i;
                        max = prob[i];
                    }                   
                    
                }
                
                choose = String.valueOf(index + 1);
                
                if(choose.equals("1")) {
                    
                    if (auxPlayer.getMatchNumber() < auxComput.getMatchNumber()) {
                        
                        System.out.println("Computador joga - Partidas " + auxComput.getMatchNumber());
                        System.out.println("Jogador joga - Partidas " + auxPlayer.getMatchNumber());
                        System.out.println("Computador Vence - Partidas ");
                        playerDeck.remove(auxPlayer);
                        computDeck.remove(auxComput);
                        computDeck.add(auxPlayer);
                        computDeck.add(auxComput);
                        comp = true;
                        player = false;
                        
                    } else {
                        
                        if (auxPlayer.getMatchNumber() > auxComput.getMatchNumber()) {
                            
                            System.out.println("Computador joga - Partidas " + auxComput.getMatchNumber());
                            System.out.println("Jogador joga    - Partidas " + auxPlayer.getMatchNumber());
                            System.out.println("Jogador Vence - Partidas ");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            playerDeck.add(auxComput);
                            comp = false;
                            player = true;                            
                            
                        } else {
                            
                            System.out.println("Computador joga - Partidas " + auxComput.getMatchNumber());
                            System.out.println("Jogador joga    - Partidas " + auxPlayer.getMatchNumber());
                            System.out.println("Empate ");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            computDeck.add(auxComput);
                            comp   = false;
                            player = true;
                            
                        }                   
                        
                    }
                    
                }
                
                if(choose.equals("2")) {
                    
                    if (auxPlayer.getWinNumber() < auxComput.getWinNumber()) {
                        
                        System.out.println("Computador joga - Vitorias " + auxComput.getWinNumber());
                        System.out.println("Jogador joga    - Vitorias " + auxPlayer.getWinNumber());
                        System.out.println("Computador Vence ");
                        playerDeck.remove(auxPlayer);
                        computDeck.remove(auxComput);
                        computDeck.add(auxPlayer);
                        computDeck.add(auxComput);
                        comp = true;
                        player = false;
                        
                    } else {
                        
                        if (auxPlayer.getWinNumber() > auxComput.getWinNumber()) {
                            
                            System.out.println("Computador joga - Vitorias " + auxComput.getWinNumber());
                            System.out.println("Jogador joga    - Vitorias " + auxPlayer.getWinNumber());
                            System.out.println("Jogador Vence ");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            playerDeck.add(auxComput);
                            comp = false;
                            player = true;                            
                            
                        } else {
                            
                            System.out.println("Computador joga - Vitorias " + auxComput.getWinNumber());
                            System.out.println("Jogador joga    - Vitorias " + auxPlayer.getWinNumber());
                            System.out.println("Empate " );
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            computDeck.add(auxComput);
                            comp   = false;
                            player = true;
                        }                   
                        
                    }
                    
                }
                
                if(choose.equals("3")) {
                    
                    if (auxPlayer.getDefeatNumber() > auxComput.getDefeatNumber()) {
                        
                        System.out.println("Computador joga - Derrotas " + auxComput.getDefeatNumber());
                        System.out.println("Jogador joga    - Derrotas " + auxPlayer.getDefeatNumber());
                        System.out.println("Computador Vence");
                        playerDeck.remove(auxPlayer);
                        computDeck.remove(auxComput);
                        computDeck.add(auxPlayer);
                        computDeck.add(auxComput);
                        comp = true;
                        player = false;
                        
                    } else {
                        
                        if (auxPlayer.getDefeatNumber() < auxComput.getDefeatNumber()) {
                            
                            System.out.println("Computador joga - Derrotas " + auxComput.getDefeatNumber());
                            System.out.println("Jogador joga    - Derrotas " + auxPlayer.getDefeatNumber());
                            System.out.println("Jogador Vence");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            playerDeck.add(auxComput);
                            comp = false;
                            player = true;                            
                            
                        } else {
                            
                            System.out.println("Computador joga - Derrotas " + auxComput.getDefeatNumber());
                            System.out.println("Jogador joga    - Derrotas " + auxPlayer.getDefeatNumber());
                            System.out.println("Empate ");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            computDeck.add(auxComput);
                            comp   = false;
                            player = true;
                        }                   
                        
                    }
                    
                }
                
                if(choose.equals("4")) {
                    
                    if (auxPlayer.getGoalScoredNumber() < auxComput.getGoalScoredNumber()) {
                        
                        System.out.println("Computador joga - Gols pro " + auxComput.getGoalScoredNumber());
                        System.out.println("Jogador joga    - Gols pro " + auxPlayer.getGoalScoredNumber());
                        System.out.println("Computador Vence");
                        playerDeck.remove(auxPlayer);
                        computDeck.remove(auxComput);
                        computDeck.add(auxPlayer);
                        computDeck.add(auxComput);
                        comp = true;
                        player = false;
                        
                    } else {
                        
                        if (auxPlayer.getGoalScoredNumber() > auxComput.getGoalScoredNumber()) {
                            
                            System.out.println("Computador joga - Gols pro " + auxComput.getGoalScoredNumber());
                            System.out.println("Jogador joga    - Gols pro " + auxPlayer.getGoalScoredNumber());
                            System.out.println("Jogador Vence");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            playerDeck.add(auxComput);
                            comp = false;
                            player = true;                            
                            
                        } else {
                            
                            System.out.println("Computador joga - Gols pro " + auxComput.getGoalScoredNumber());
                            System.out.println("Jogador joga    - Gols pro " + auxPlayer.getGoalScoredNumber());
                            System.out.println("Empate  ");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            computDeck.add(auxComput);
                            comp   = false;
                            player = true;
                        }                   
                        
                    }
                    
                }
                
                if(choose.equals("5")) {
                    
                    if (auxPlayer.getGoalConcededNumber() > auxComput.getGoalConcededNumber()) {
                        
                        System.out.println("Computador joga - Gols Contra " + auxComput.getGoalConcededNumber());
                        System.out.println("Jogador joga    - Gols Contra " + auxPlayer.getGoalConcededNumber());
                        System.out.println("Computador Vence");
                        playerDeck.remove(auxPlayer);
                        computDeck.remove(auxComput);
                        computDeck.add(auxPlayer);
                        computDeck.add(auxComput);
                        comp = true;
                        player = false;
                        
                    } else {
                        
                        if (auxPlayer.getGoalConcededNumber() < auxComput.getGoalConcededNumber()) {
                            
                            System.out.println("Computador joga - Gols Contra " + auxComput.getGoalConcededNumber());
                        System.out.println("Jogador joga    - Gols Contra " + auxPlayer.getGoalConcededNumber());
                        System.out.println("Jogador Vence");
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            playerDeck.add(auxComput);
                            comp = false;
                            player = true;                            
                            
                        } else {
                            
                            System.out.println("Computador joga - Gols Contra " + auxComput.getGoalConcededNumber());
                            System.out.println("Jogador joga    - Gols Contra " + auxPlayer.getGoalConcededNumber());
                            System.out.println("Empate " + auxComput.getGoalConcededNumber());
                            playerDeck.remove(auxPlayer);
                            computDeck.remove(auxComput);
                            playerDeck.add(auxPlayer);
                            computDeck.add(auxComput);
                            comp   = false;
                            player = true;
                        }                   
                        
                    }
                    
                }
                
                System.out.println("Digite enter para contiuar: ");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                choose = input.nextLine();
                try {
                    run.exec("clear");
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
                               
                
            }
           
        }
        
        if (playerDeck.isEmpty()) {
            System.out.println("Computador venceu");
        } else {
            System.out.println("Jogador venceu");
        }
        
    }
    
    public static boolean startGame() {
        
        int coin = (int) (Math.random()*101);
        
        if (coin >= 50) return true;
        return false;
        
    }
    
}
