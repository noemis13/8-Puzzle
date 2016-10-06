/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeuristicaDistanciaEuclidiana;

/**
 *
 * @author ns
 */
public class Puzzle {
   public Puzzle() {
    }
 
    public String[][] estadoMeta(){
        String[][] puzzleMeta = new String[3][3];
        
        puzzleMeta[0][0] = "1";
        puzzleMeta[0][1]= "2";
        puzzleMeta[0][2]= "3";
        
        puzzleMeta[1][0]= "4";
        puzzleMeta[1][1]= "5";
        puzzleMeta[1][2]= "6";
        
        puzzleMeta[2][0]= "7";
        puzzleMeta[2][1]= "8";
        puzzleMeta[2][2]= "_";
                
        return puzzleMeta;
    }
    public static String[][] puzzleInicio(){
        String[][] puzzleIni = new String[3][3];
        puzzleIni[0][0] = "2";
        puzzleIni[0][1] = "3";
        puzzleIni[0][2] = "1";
        
        puzzleIni[1][0] = "_";
        puzzleIni[1][1] = "5";
        puzzleIni[1][2] = "6";
       
        puzzleIni[2][0] = "4";
        puzzleIni[2][1] = "7";
        puzzleIni[2][2] = "8";
        
        
        return puzzleIni;
    }
     
}
