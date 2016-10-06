package HeuristicaDistanciaEuclidiana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author ns
 */
public class AEstrela {

    public AEstrela() {
    }
    
    public static void main(String[] args) {
        Puzzle puzz = new Puzzle();

        String[][] puzzleIni = new String[3][3];
        puzzleIni = puzz.puzzleInicio();
        double peçasForaDoLugar = 0.0;
        int quantidadeExpansoes = 0;

        ArrayList<String[][]> puzzlePercorrido = new ArrayList<>();
        puzzlePercorrido.add(puzzleIni);

        expandePuzzle(puzzleIni, puzzlePercorrido, peçasForaDoLugar, quantidadeExpansoes);
    }

    /*
    Método responsável por receber um puzzle e expandir todas as suas possibilidade.
    Ele deve verificar se as expansões ja foram repetidas.
     */
    public static void expandePuzzle(String puzzle[][], ArrayList<String[][]> puzzlePercorrido, double peçasForaDoLugar, int quantidadeExpansoes) {
        Metodos metodos = new Metodos();

        String valor;
        String[][] filhoPuzzle1 = new String[3][3];
        String[][] filhoPuzzle2 = new String[3][3];
        String[][] filhoPuzzle3 = new String[3][3];
        String[][] filhoPuzzle4 = new String[3][3];

        ArrayList<String[][]> puzzleFilhos = new ArrayList<>();

        //salva em cada filho e o puzzlePercorrido o puzzle atual
        for (int i = 0; i < metodos.getTamMaximoPuzzle(); i++) {
            for (int j = 0; j < metodos.getTamMaximoPuzzle(); j++) {
                filhoPuzzle1[i][j] = puzzle[i][j];
                filhoPuzzle2[i][j] = puzzle[i][j];
                filhoPuzzle3[i][j] = puzzle[i][j];
                filhoPuzzle4[i][j] = puzzle[i][j];

            }
        }

        //expansão dos filhos
        for (int i = 0; i < metodos.getTamMaximoPuzzle(); i++) {
            for (int j = 0; j < metodos.getTamMaximoPuzzle(); j++) {
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

        corPuzzleFilhos1 = metodos.adicionaCores(filho1, puzzlePercorrido);
        corPuzzleFilhos2 = metodos.adicionaCores(filho2, puzzlePercorrido);
        corPuzzleFilhos3 = metodos.adicionaCores(filho3, puzzlePercorrido);
        corPuzzleFilhos4 = metodos.adicionaCores(filho4, puzzlePercorrido);

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

        //Chama fhunção que encontra a melhor expansao
        AEstrela aEstrela = new AEstrela();
        aEstrela.encontraValorHeuritica(puzzleFilhos, puzzlePercorrido, peçasForaDoLugar, quantidadeExpansoes);
    }

    /*Método responsável por receber uma lista contendo uma
    expasão do puzzle e encontrar qual é a melhor expansão para se usar
     */
    public void encontraValorHeuritica(ArrayList<String[][]> puzzleFilhos, ArrayList<String[][]> puzzlePercorrido, double peçasForaDoLugar, int quantidadeExpansoes) {
        Metodos metodos = new Metodos();
        ExpandePuzzleHeuristicaIgual expandePuzzleHeuristicaIgual = new ExpandePuzzleHeuristicaIgual();

        double menorValorHeuristica = 0.0, valorPeçasForaDoLugar;
        String[][] puzzle = new String[3][3];

        Map<String[][], Double> puzzleEheuristica = new HashMap<>();
        Map<String[][], Double> puzzleEheuristicaIguais = new HashMap<>();

        ArrayList<Double> heuristica = new ArrayList<>();
        ArrayList<Double> heuristicasIguais = new ArrayList<>();

        valorPeçasForaDoLugar = peçasForaDoLugar;
        //calcular o valor da heuristica de cada puzzle
        for (String[][] i : puzzleFilhos) {
            peçasForaDoLugar = valorPeçasForaDoLugar;
            peçasForaDoLugar = peçasForaDoLugar + metodos.calculaDistanciaEuclidiana(i);
            puzzleEheuristica.put(i, peçasForaDoLugar);
            heuristica.add(peçasForaDoLugar);
        }

        //-------------------------------------------------------------------------
        //valores da heuristica iguais
        double ehHeuristicaIgual;

        if (puzzleEheuristica.size() == 1) {
            for (Map.Entry<String[][], Double> peh : puzzleEheuristica.entrySet()) {
                menorValorHeuristica = peh.getValue();
                puzzle = peh.getKey();
            }

        } else if (puzzleEheuristica.size() == 2) {
            ehHeuristicaIgual = metodos.verificaIgualdadeHeuristica(heuristica);
            if (ehHeuristicaIgual == 0) {
                menorValorHeuristica = metodos.encontraMenor(heuristica);
                puzzle = metodos.encontraPuzzleDaHeuristica(puzzleEheuristica, menorValorHeuristica);

            } else {
                for (Map.Entry<String[][], Double> peh : puzzleEheuristica.entrySet()) {
                    if (peh.getValue() == ehHeuristicaIgual) {
                       double novoValor;
                        valorPeçasForaDoLugar = ehHeuristicaIgual;
                        novoValor = expandePuzzleHeuristicaIgual.expandeBuscaAEstrela(peh.getKey(), puzzlePercorrido, valorPeçasForaDoLugar);
                        puzzleEheuristicaIguais.put(peh.getKey(), novoValor);
                        heuristicasIguais.add(novoValor);
                        
                        System.out.println("NOVO VALOR: " +novoValor);
                    
                    }
                }
                menorValorHeuristica = metodos.encontraMenor(heuristicasIguais);

                for (Map.Entry<String[][], Double> pehi : puzzleEheuristicaIguais.entrySet()) {
                    if (pehi.getValue() == menorValorHeuristica) {
                        puzzle = pehi.getKey();
                    }
                }
                menorValorHeuristica = ehHeuristicaIgual;
            }//else

        } else {
            ehHeuristicaIgual = metodos.verificaIgualdadeHeuristica(heuristica);
            if (ehHeuristicaIgual == 0) {
                menorValorHeuristica = metodos.encontraMenor(heuristica);
                puzzle = metodos.encontraPuzzleDaHeuristica(puzzleEheuristica, menorValorHeuristica);

            } else {
                double valorDiferente = metodos.encontraValorDiferente(heuristica, ehHeuristicaIgual);
               
                if (valorDiferente < ehHeuristicaIgual) {
                    menorValorHeuristica = valorDiferente;
                    puzzle = metodos.encontraPuzzleDaHeuristica(puzzleEheuristica, menorValorHeuristica);

                } else {
                    //expande
                    for (Map.Entry<String[][], Double> peh : puzzleEheuristica.entrySet()) {
                        if (peh.getValue() == ehHeuristicaIgual) {
                            double novoValor;
                            valorPeçasForaDoLugar = ehHeuristicaIgual;

                            novoValor = expandePuzzleHeuristicaIgual.expandeBuscaAEstrela(peh.getKey(), puzzlePercorrido, valorPeçasForaDoLugar);
                            puzzleEheuristicaIguais.put(peh.getKey(), novoValor);
                            heuristicasIguais.add(novoValor);
                            
                            System.out.println("NOVO VALOR: " +novoValor);
                            
                        } else {
                            puzzleEheuristicaIguais.put(peh.getKey(), peh.getValue());
                            heuristicasIguais.add(peh.getValue());
                        }
                    }//for
                    
                    menorValorHeuristica = metodos.encontraMenor(heuristicasIguais);
                    for (Map.Entry<String[][], Double> pehi : puzzleEheuristicaIguais.entrySet()) {
                        if (pehi.getValue() == menorValorHeuristica) {
                            puzzle = pehi.getKey();
                        }
                    }
                    if(menorValorHeuristica != valorDiferente) 
                        menorValorHeuristica = ehHeuristicaIgual;

                }//else

            }//else heuristicas iguais
        }//fim das comparações

        //-------------------------------------------------------------------------
        //adiciona o que ja foi percorrido;
        puzzlePercorrido.add(puzzle);

        //Atualiza o valor de h
        peçasForaDoLugar = menorValorHeuristica;

        quantidadeExpansoes = quantidadeExpansoes + 1;
        //verifica se o puzzle é o meta, se não expande novamente os filhos e 
        int ehPuzzleFInal;
        ehPuzzleFInal = metodos.comparaPuzzleFinal(puzzle);

        if (ehPuzzleFInal == 0) {
            System.out.println("Quantidade de expansoes: " + quantidadeExpansoes);
            metodos.imprimePuzzle(puzzle);
            System.out.println("valor heuristica: " + menorValorHeuristica);
            System.out.println("\n");
            expandePuzzle(puzzle, puzzlePercorrido, peçasForaDoLugar, quantidadeExpansoes);

        } else {
            System.out.println("Puzzle final obtido! ");
            metodos.imprimePuzzle(puzzle);
            System.out.println("\n");
        }
    }

    
}
