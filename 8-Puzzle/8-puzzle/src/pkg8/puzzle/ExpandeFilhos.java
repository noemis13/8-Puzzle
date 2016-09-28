/*
Classe responsável por receber um puzzle e expandir todas as suas possibilidade.
Ele deve verificar se as expansões ja foram repetidas.
 */
package pkg8.puzzle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ns
 */
public class ExpandeFilhos {

    private int tamMaximoPuzzle = 3;

    public ExpandeFilhos() {
    }

    public int getTamMaximoPuzzle() {
        return tamMaximoPuzzle;
    }


    public void expandePuzzle(String puzzle[][], ArrayList<String[][]> puzzlePercorrido) {
        BuscaGulosa buscaGulosa = new BuscaGulosa();
        
        String valor;
        String[][] filhoPuzzle1 = new String[3][3];
        String[][] filhoPuzzle2 = new String[3][3];
        String[][] filhoPuzzle3 = new String[3][3];
        String[][] filhoPuzzle4 = new String[3][3];

                
        ArrayList<String[][]> puzzleFilhos = new ArrayList<>();

        //salva em cada filho e o puzzlePercorrido o puzzle atual
        for (int i = 0; i < tamMaximoPuzzle; i++) {
            for (int j = 0; j < tamMaximoPuzzle; j++) {
                filhoPuzzle1[i][j] = puzzle[i][j];
                filhoPuzzle2[i][j] = puzzle[i][j];
                filhoPuzzle3[i][j] = puzzle[i][j];
                filhoPuzzle4[i][j] = puzzle[i][j];

            }
        }
        
        //expansão dos filhos
        for (int i = 0; i < tamMaximoPuzzle; i++) {
            for (int j = 0; j < tamMaximoPuzzle; j++) {
                if (puzzle[i][j].equals("_")) {
                    //Condições para a posição do espaço vazio
                    if ((i == 0) && (j == 0)) {
                        valor = puzzle[i][j];

                        filhoPuzzle1[i][j] = puzzle[0][1];
                        filhoPuzzle1[0][1] = valor;

                        filhoPuzzle2[i][j] = puzzle[1][0];
                        filhoPuzzle2[1][0] = valor;

                    } else if ((i == 0) && (j == 1)) {
                        valor = puzzle[i][j];

                        filhoPuzzle1[i][j] = puzzle[0][0];
                        filhoPuzzle1[0][0] = valor;

                        filhoPuzzle2[i][j] = puzzle[0][2];
                        filhoPuzzle2[0][2] = valor;

                        filhoPuzzle3[i][j] = puzzle[1][1];
                        filhoPuzzle3[1][1] = valor;

                    } else if ((i == 0) && (j == 2)) {
                        valor = puzzle[i][j];

                        filhoPuzzle1[i][j] = puzzle[0][1];
                        filhoPuzzle1[0][1] = valor;

                        filhoPuzzle2[i][j] = puzzle[1][2];
                        filhoPuzzle2[1][2] = valor;

                    } else if ((i == 1) && (j == 0)) {
                        valor = puzzle[i][j];
                        filhoPuzzle1[i][j] = puzzle[0][0];
                        filhoPuzzle1[0][0] = valor;

                        filhoPuzzle2[i][j] = puzzle[1][1];
                        filhoPuzzle2[1][1] = valor;

                        filhoPuzzle3[i][j] = puzzle[2][0];
                        filhoPuzzle3[2][0] = valor;

                    } else if ((i == 1) && (j == 1)) {
                        valor = puzzle[i][j];

                        filhoPuzzle1[i][j] = puzzle[0][1];
                        filhoPuzzle1[0][1] = valor;

                        filhoPuzzle2[i][j] = puzzle[1][0];
                        filhoPuzzle2[1][0] = valor;

                        filhoPuzzle3[i][j] = puzzle[1][2];
                        filhoPuzzle3[1][2] = valor;

                        filhoPuzzle4[i][j] = puzzle[2][1];
                        filhoPuzzle4[2][1] = valor;

                    } else if ((i == 1) && (j == 2)) {
                        valor = puzzle[i][j];

                        filhoPuzzle1[i][j] = puzzle[0][2];
                        filhoPuzzle1[0][2] = valor;

                        filhoPuzzle2[i][j] = puzzle[1][1];
                        filhoPuzzle2[1][1] = valor;

                        filhoPuzzle3[i][j] = puzzle[2][2];
                        filhoPuzzle3[2][2] = valor;

                    } else if ((i == 2) && (j == 0)) {
                        valor = puzzle[i][j];
                        filhoPuzzle1[i][j] = puzzle[1][0];
                        filhoPuzzle1[1][0] = valor;

                        filhoPuzzle2[i][j] = puzzle[2][1];
                        filhoPuzzle2[2][1] = valor;

                    } else if ((i == 2) && (j == 1)) {
                        valor = puzzle[i][j];

                        filhoPuzzle1[i][j] = puzzle[1][1];
                        filhoPuzzle1[1][1] = valor;

                        filhoPuzzle2[i][j] = puzzle[2][0];
                        filhoPuzzle2[2][0] = valor;

                        filhoPuzzle3[i][j] = puzzle[2][2];
                        filhoPuzzle3[2][2] = valor;

                    } else if ((i == 2) && (j == 2)) {
                        valor = puzzle[i][j];

                        filhoPuzzle1[i][j] = puzzle[1][2];
                        filhoPuzzle1[1][2] = valor;

                        filhoPuzzle2[i][j] = puzzle[2][1];
                        filhoPuzzle2[2][1] = valor;
                    }
                }
            }//2º for
        }//1º for

        //verifica se expansão já foi feita        
        ArrayList<String[][]> filho1 = new ArrayList<>();
        ArrayList<String[][]> filho2 = new ArrayList<>();
        ArrayList<String[][]> filho3 = new ArrayList<>();
        ArrayList<String[][]> filho4 = new ArrayList<>();
        
        filho1.add(filhoPuzzle1);
        filho2.add(filhoPuzzle2);
        filho3.add(filhoPuzzle3);
        filho4.add(filhoPuzzle4);
        
        String corPuzzleFilhos1, corPuzzleFilhos2, corPuzzleFilhos3, corPuzzleFilhos4 = new String();
        
        corPuzzleFilhos1 = adicionaCores(filho1, puzzlePercorrido);
        corPuzzleFilhos2 = adicionaCores(filho2, puzzlePercorrido);
        corPuzzleFilhos3 = adicionaCores(filho3, puzzlePercorrido);
        corPuzzleFilhos4 = adicionaCores(filho4, puzzlePercorrido);
        
        //adiciona aos filhos somente valores que nao foram percorridos
        if(corPuzzleFilhos1.equals("azul"))
            puzzleFilhos.add(filhoPuzzle1);
        
        if(corPuzzleFilhos2.equals("azul"))
            puzzleFilhos.add(filhoPuzzle2);
        
        if(corPuzzleFilhos3.equals("azul"))
            puzzleFilhos.add(filhoPuzzle3);

        if(corPuzzleFilhos4.equals("azul"))
            puzzleFilhos.add(filhoPuzzle4);
        
        //Chama fhunção que encontra a melhor expansao
        buscaGulosa.encontraValorHeuritica(puzzleFilhos, puzzlePercorrido);
    }

    /*
    Método que adiciona uma cor ao filho
    se vermelho, o filho é uma expansão que já foi feita.
    se azul, o filho é válido.
     */
    public String adicionaCores(ArrayList<String[][]> filhoPuzzle, ArrayList<String[][]> puzzlePercorrido) {
        String cor = "azul";

        for (String[][] i : puzzlePercorrido) {
            for (String[][] j: filhoPuzzle) {
                if(Arrays.deepToString(i).equals(Arrays.deepToString(j))){
                    cor = "vermelho";
                }
            }
            
        }
        return cor;
    }
    

}
