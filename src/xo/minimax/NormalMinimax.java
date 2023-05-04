/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xo.minimax;

/**
 *
 * @author Fadio
 */
public class NormalMinimax {
    
    
    public int[] BestMove(char table[][]){
        int bestscore = -1;
        int bestmove[] = new int[2];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(table[i][j] == ' '){
                    table[i][j] = 'X';
                    int rs = minimax(table, -1);
                    table[i][j] = ' ';
                    if(rs > bestscore){
                        bestscore = rs;
                        bestmove = new int[]{i, j};
                    }
                }

            }
        }
        return bestmove;
    }

    public int minimax(char[][] table, int isMax){

        JeuXO jeu = new JeuXO();
        jeu.table = table;

        if(jeu.isWinner() >= 0 ){
            return -1*isMax* jeu.isWinner();
        }
         // Le joueur MAX ( AI )
              if(isMax == 1){
            int bestscore = -1;
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    if(table[i][j] == ' '){
                        table[i][j] = 'X';
                        int rs = minimax(table, -1);
                        table[i][j] = ' ';
                        if(rs > bestscore){
                            bestscore = rs;
                        }
                    }
                }
            }
            return bestscore;
        }
          
               // Le joueur Min 
        else if(isMax == -1){
            int bestscore = 1;
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    if(table[i][j] == ' '){
                        table[i][j] = 'O';
                        int rs = minimax(table, 1);
                        table[i][j] = ' ';
                        if(rs < bestscore){
                            bestscore = rs;
                        }
                    }
                }
            }
            return bestscore;
        }
        return 0;
    }
}
