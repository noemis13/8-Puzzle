package pkg8.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author ns
 */
public class ExpandePuzzle {

    /*
    Método que recebe um puzzle que possui heuristica igual a de ouro puzzle
    ele deve verificar os filhos desse puzzle e retornar o menor valor da expansão
     */
    public int expande(String[][] puzzle, ArrayList<String[][]> puzzlePercorrido, int valorHeurisrica) {
        ExpandeFilhos expandeFilhos = new ExpandeFilhos();
        BuscaGulosa buscaGulosa = new BuscaGulosa();

        String valor;
        String[][] filhoPuzzle1 = new String[3][3];
        String[][] filhoPuzzle2 = new String[3][3];
        String[][] filhoPuzzle3 = new String[3][3];
        String[][] filhoPuzzle4 = new String[3][3];

        ArrayList<String[][]> puzzleFilhos = new ArrayList<>();

        //salva em cada filho e o puzzlePercorrido o puzzle atual
        for (int i = 0; i < expandeFilhos.getTamMaximoPuzzle(); i++) {
            for (int j = 0; j < expandeFilhos.getTamMaximoPuzzle(); j++) {
                filhoPuzzle1[i][j] = puzzle[i][j];
                filhoPuzzle2[i][j] = puzzle[i][j];
                filhoPuzzle3[i][j] = puzzle[i][j];
                filhoPuzzle4[i][j] = puzzle[i][j];

            }
        }

        //expansão dos filhos
        for (int i = 0; i < expandeFilhos.getTamMaximoPuzzle(); i++) {
            for (int j = 0; j < expandeFilhos.getTamMaximoPuzzle(); j++) {
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

        //Adiciona o puzzle expandido para puzzlePerocorrido
        puzzlePercorrido.add(puzzle);

        corPuzzleFilhos1 = expandeFilhos.adicionaCores(filho1, puzzlePercorrido);
        corPuzzleFilhos2 = expandeFilhos.adicionaCores(filho2, puzzlePercorrido);
        corPuzzleFilhos3 = expandeFilhos.adicionaCores(filho3, puzzlePercorrido);
        corPuzzleFilhos4 = expandeFilhos.adicionaCores(filho4, puzzlePercorrido);

        //adiciona aos filhos somente valores que nao foram percorridos
        if (corPuzzleFilhos1.equals("azul")) {
            puzzleFilhos.add(filhoPuzzle1);
        }
        if (corPuzzleFilhos2.equals("azul")) {
            puzzleFilhos.add(filhoPuzzle2);
        }
        if (corPuzzleFilhos3.equals("azul")) {
            puzzleFilhos.add(filhoPuzzle3);
        }
        if (corPuzzleFilhos4.equals("azul")) {
            puzzleFilhos.add(filhoPuzzle4);
        }

        //------------------------CALCULAR HEURISRICA------------------------
        int menorValorHeuristica = 0, peçasFLugar;
        ArrayList<Integer> peçasForaDoLugar = new ArrayList<>();
        String[][] puzzleHeuristicaIgual = new String[3][3];

        //calcular o valor da heuristica de cada puzzle
        for (String[][] i : puzzleFilhos) {
            peçasForaDoLugar.add(buscaGulosa.calculaPecasForaDoLugar(i));
        }

        
        //calcula menor heurística
        menorValorHeuristica = buscaGulosa.encontraMenor(peçasForaDoLugar);

        //descobrir a qual matriz o menor valor pertenece
        for (String[][] pf : puzzleFilhos) {
            peçasFLugar = buscaGulosa.calculaPecasForaDoLugar(pf);
            if (peçasFLugar == menorValorHeuristica) {
                puzzleHeuristicaIgual = pf;
                break;
            }
        }
        
        if (menorValorHeuristica == valorHeurisrica) {
            expande(puzzleHeuristicaIgual, puzzlePercorrido, menorValorHeuristica);
        }
        System.out.println("menor " + menorValorHeuristica);

        return menorValorHeuristica;
    }

}
