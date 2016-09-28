package pkg8.puzzle;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ns
 */
public class BuscaAestrela {

    /*Método responsável por pegr o puzzle inicial e expandir suas probabilidades*/
    public void calculaProbabilidades(String[][] puzzle) {
        int distanciaManhattan1, distanciaManhattan2, distanciaManhattan3, distanciaManhattan;
        String[][] filhoPuzzle1 = new String[3][3];
        String[][] filhoPuzzle2 = new String[3][3];
        String[][] filhoPuzzle3 = new String[3][3];
        String valor;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                filhoPuzzle1[i][j] = puzzle[i][j];
                filhoPuzzle2[i][j] = puzzle[i][j];
                filhoPuzzle3[i][j] = puzzle[i][j];
            }
        }

        //-------------------------------------------------------
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (puzzle[i][j].equals("_")) {

                    //Condições para a posição do espaço vazio
                    if ((i == 0) && (j == 0)) {

                    } else if ((i == 0) && (j == 1)) {

                    } else if ((i == 0) && (j == 2)) {

                    } else if ((i == 1) && (j == 0)) {
                        valor = filhoPuzzle1[i][j];
                        filhoPuzzle1[i][j] = puzzle[0][0];
                        filhoPuzzle1[0][0] = valor;

                        filhoPuzzle2[i][j] = puzzle[1][1];
                        filhoPuzzle2[1][1] = valor;

                        filhoPuzzle3[i][j] = puzzle[2][0];
                        filhoPuzzle3[2][0] = valor;

                    } else if ((i == 1) && (j == 1)) {

                    } else if ((i == 1) && (j == 2)) {

                    } else if ((i == 2) && (j == 0)) {

                    } else if ((i == 2) && (j == 1)) {

                    } else if ((i == 2) && (j == 2)) {

                    }
                }
            }//2º for
        }//1º for

        //Encontrar o valor da heurística
        distanciaManhattan1 = calculaPecasForaDoLugar(filhoPuzzle1);

        //distanciaManhattan2 = calculaPecasForaDoLugar(filhoPuzzle2);
        //distanciaManhattan3 = calculaPecasForaDoLugar(filhoPuzzle3);
    }//calculaProbabilidades

    /*método responsável por receber uma expansão (filho) do puzzle,
    calcular a quantidade de peças fora do lugar = Distancia de Manhattan*/
    public int calculaPecasForaDoLugar(String[][] puzzle) {
        int distanciaManhattan = 0;
        String valor;
        int[] posCorreta = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!puzzle[i][j].equals("_")) {
                    valor = puzzle[i][j];
                    //distanciaManhattan = distanciaManhattan + contaPosCorreta(i, j, valor);
                    contaPosCorreta(i, j, valor);

                }
            }
        }

        return distanciaManhattan;
    }

    /* Método que complementa calculaPecasForaDoLugar
    ele é responsável por contar quantas casas o valor está fora do lugar*/
    public int contaPosCorreta(int i, int j, String valor) {
        int distanciaManhattan = 0;
        int posLinha = 0, posColuna = 0;
        
        Puzzle puzz = new Puzzle();
        String[][] puzzleMeta = new String[3][3];
        puzzleMeta = puzz.estadoMeta();

        for (int conti = 0; conti < 3; conti++) {
            for (int contj = 0; contj < 3; contj++) {
                if (puzzleMeta[i][j].equals(valor)) {
                    posLinha = conti;
                    posColuna = contj;
                }
            }
        }

        if (i == posLinha && j != posColuna) {
            distanciaManhattan = Math.abs(posColuna - j); //módulo
            

        } else if (i != posLinha && j == posColuna) {
            distanciaManhattan = Math.abs(posLinha - i);
        } else if (i == posLinha && j == posColuna) {
            distanciaManhattan = 0;

        }/* else {
            if ((i == 0 && posLinha != 0) && (j != 0 && posColuna == 0)) {
                distanciaManhattan = j + posLinha;
            } else if ((i != 0 && posLinha == 0) && (j == 0 && posColuna != 0)) {
                distanciaManhattan = i + posColuna;
            } else if ((i == 0 && j == 0) && (posLinha != 0 && posColuna != 0)) {
                distanciaManhattan = posLinha + posColuna;
            } else if ((i == 0 && j != 0) && (posLinha != 0 && posColuna != 0)) {
                distanciaManhattan = i + j;
            } else if ((i != 0 && j == 0) && (posLinha != 0 && posColuna != 0)) {
                distanciaManhattan = i + j;
            } else if (((i != 0 && j != 0) && (posLinha == 0 && posColuna != 0)) || ((i != 0 && j != 0) && (posLinha != 0 && posColuna == 0))) {
                distanciaManhattan = posLinha + posColuna;
            }
        }*/
       return distanciaManhattan;
    }

    /*Método responsável por encontrar o menor valor
    utilizando a heurística da distâcia de Manhattan*/
    public int encontraMenor(int distanciaManhattan1, int distanciaManhattan2, int distanciaManhattan3) {
        int distanciaManhattan;

        if ((distanciaManhattan1 < distanciaManhattan2) && (distanciaManhattan1 < distanciaManhattan3)) {
            distanciaManhattan = distanciaManhattan1;
        } else if ((distanciaManhattan2 < distanciaManhattan1) && (distanciaManhattan2 < distanciaManhattan3)) {
            distanciaManhattan = distanciaManhattan2;
        } else {
            distanciaManhattan = distanciaManhattan3;
        }

        return distanciaManhattan;
    }

    public void puzzleInicio() {
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

        calculaProbabilidades(puzzleIni);

    }

    public void imprimePuzzle(String[][] puzzle) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(puzzle[i][j]);
            }
            System.out.print("\n");
        }
    }

    /*public static void main(String[] args) {
        BuscaAestrela aEstrtela = new BuscaAestrela();
        aEstrtela.puzzleInicio();
    }*/
}
