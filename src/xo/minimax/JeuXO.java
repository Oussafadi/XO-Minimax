/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xo.minimax;

import java.util.Scanner;

/**
 *
 * @author Fadio
 */
public class JeuXO {
    
    char[][] table = new char[3][3];
    int position[] = new int[2];


    public JeuXO(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                table[i][j] = ' ';
            }
        }
    }

   
   public void Joueur(){
          while (true) {
          System.out.println(" Ton tour : ");
          Scanner sc = new Scanner(System.in);
          System.out.print("Saisir Ligne (0-2): ");
          int i = sc.nextInt();
          System.out.print("Saisir Colonne (0-2): ");
          int j = sc.nextInt();
            if (PossibleouPas(i,j)) {
               table[i][j] = 'O';  
               break;
            } else {
                System.out.println("Mouvement impossible , veuillez saisir un mouvement valide ");
                continue;
            }
       }
   }
   
   public  void ai(){
         System.out.print("\n");
       System.out.println(" ai played : ");
        NormalMinimax a1 = new NormalMinimax();
        position = a1.BestMove(table);
        table[position[0]][position[1]] = 'X';

    }
   
   public boolean PossibleouPas(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && table[row][col]==' ';
    }

   public int CaseVides(){
        int c = 0;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(table[i][j] == ' ') c++;
            }
        }
        return c;
    }
    public int isWinner(){
        int i;
        // Lignes et colonnes
        for(i=0; i<3; i++){
            if(table[0][i] != ' '){
                if(table[0][i] == table[1][i] && table[1][i] == table[2][i]){
                    return 1;
                }
            }
            if(table[i][0] != ' '){
                if(table[i][0] == table[i][1] && table[i][1] == table[i][2]){
                    return 1;
                }
            }
        }
         // Diagonales 
        if(table[1][1] != ' '){
            if(table[0][0] == table[1][1] && table[1][1] == table[2][2] ) return 1;
            if(table[0][2] == table[1][1] && table[1][1] == table[2][0] ) return 1;
        }
        if(this.CaseVides()== 0) return 0;

        return -1 ;
    }
    public void AfficherTable(){
         System.out.print("\n");
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(table[i][j]  + " ");
            }
            System.out.print("\n");
        }
         System.out.print("\n");
    }
}
