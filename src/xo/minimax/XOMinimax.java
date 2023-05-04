/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xo.minimax;

/**
 *
 * @author Fadio
 */
public class XOMinimax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       JeuXO J = new JeuXO();
//        J.AfficherTable();       
        do{           
            J.ai();
            J.AfficherTable();
            if( J.isWinner() != 0 && J.isWinner() != 1){
            J.Joueur();
            }
            J.AfficherTable();
        }while (J.isWinner() == -1); // Aucun gagnant et existe encore des cases vides
        System.out.println(" The End");
    }
    
}
