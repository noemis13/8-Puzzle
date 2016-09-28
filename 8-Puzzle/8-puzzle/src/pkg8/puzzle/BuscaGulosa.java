package pkg8.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author ns
 */
public class BuscaGulosa {

    public BuscaGulosa() {
    }

    public static void main(String[] args) {
        Puzzle puzz = new Puzzle();

        String[][] puzzleIni = new String[3][3];
        puzzleIni = puzz.puzzleInicio();

        ArrayList<String[][]> puzzlePercorrido = new ArrayList<>();
        puzzlePercorrido.add(puzzleIni);

        expandePuzzle(puzzleIni, puzzlePercorrido);
    }

    /*
    responsável por receber um puzzle e expandir todas as suas possibilidade.
    Ele deve verificar se as expansões ja foram repetidas.
     */
    public static void expandePuzzle(String puzzle[][], ArrayList<String[][]> puzzlePercorrido) {
        BuscaGulosa buscaGulosa = new BuscaGulosa();
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
        buscaGulosa.encontraValorHeuritica(puzzleFilhos, puzzlePercorrido);
    }

    /*Método responsável por receber uma lista contendo uma
    expasão do puzzle e encontrar qual é a melhor expansão para se usar
     */
    public void encontraValorHeuritica(ArrayList<String[][]> puzzleFilhos, ArrayList<String[][]> puzzlePercorrido) {
        Metodos metodos = new Metodos();

        int menorValorHeuristica = 0, peçasFLugar;
        String[][] puzzle = new String[3][3];
        ArrayList<Integer> peçasForaDoLugar = new ArrayList<>();

        //calcular o valor da heuristica de cada puzzle
        for (String[][] i : puzzleFilhos) {
            peçasForaDoLugar.add(calculaPecasForaDoLugar(i));
        }

        System.out.println("heuristica antes: " + peçasForaDoLugar);
        
        //-------------------------------------------------------------------------
        //valores da heuristica iguais
        int tamPeçasForaDoLugar = peçasForaDoLugar.size();
        int valorIgual, novoValorHeuristica;

        if (tamPeçasForaDoLugar == 1) {
            menorValorHeuristica = encontraMenor(peçasForaDoLugar);

        } else if (tamPeçasForaDoLugar == 2) {
            //verifica se é uma lista de valores iguais ou nao
            valorIgual = verificaIgualdadeHeuristica(peçasForaDoLugar, tamPeçasForaDoLugar);
            //lista nao igual
            if (valorIgual == 1) {
                menorValorHeuristica = encontraMenor(peçasForaDoLugar);

            } else {
                //descobre o puzzle e expande
                novoValorHeuristica = expandePuzzleDeMesmaHeuristica(valorIgual, puzzleFilhos, puzzlePercorrido);
                menorValorHeuristica = novoValorHeuristica;
            }

        } else if (tamPeçasForaDoLugar >= 3) {
            valorIgual = verificaIgualdadeHeuristica(peçasForaDoLugar, tamPeçasForaDoLugar);
            if (valorIgual == 1) {
                menorValorHeuristica = encontraMenor(peçasForaDoLugar);

            } else {
                int valorDiferente;
                valorDiferente = encontraValorDiferente(peçasForaDoLugar, valorIgual);
                if(valorDiferente < valorIgual) {
                    menorValorHeuristica = valorDiferente;
                
                }else{
                    novoValorHeuristica = expandePuzzleDeMesmaHeuristica(valorIgual, puzzleFilhos, puzzlePercorrido);
                    //valor diferente melhor que novo valor encontrado
                    if(novoValorHeuristica < valorDiferente) {
                        menorValorHeuristica = novoValorHeuristica;
                    }else {
                        menorValorHeuristica = valorDiferente;
                    }
                    
                }
            }
        }

        //-------------------------------------------------------------------------
        System.out.println("Heuristica sem repetição: " + peçasForaDoLugar);

        //descobrir a qual matriz o menor valor pertenece
        for (String[][] pf : puzzleFilhos) {
            peçasFLugar = calculaPecasForaDoLugar(pf);
            if (peçasFLugar == menorValorHeuristica) {
                puzzle = pf;
                break;
            }
        }
        //adiciona o que ja foi percorrido;
        puzzlePercorrido.add(puzzle);

        //-------------------------------------------------------------------
        //verifica se o puzzle é o meta, se não expande novamente os filhos e 
        //salva em uma lista os nós expadidos
        ArrayList<String[][]> puzzleExpandidos = new ArrayList<>();
        puzzleExpandidos.add(puzzle);

        int ehPuzzleFInal;
        ehPuzzleFInal = metodos.comparaPuzzleFinal(puzzle);

        if (ehPuzzleFInal == 0) {
            metodos.imprimePuzzle(puzzle);
            //System.out.println("valor heuristica" + menorValorHeuristica);
            System.out.println("\n");
            expandePuzzle(puzzle, puzzlePercorrido);
        } else {
            System.out.println("Puzzle final obtido \n");

        }
    }

    /*
    Método responsável por varificar se os valores das heuristicas são iguais
     */
    public int verificaIgualdadeHeuristica(ArrayList<Integer> peçasForaDoLugar, int tamPeçasForaDoLugar) {
        int valorIgual = 1; //nao igual

        for (int pfd = 0; pfd < peçasForaDoLugar.size(); pfd++) {
            if ((pfd + 1) < tamPeçasForaDoLugar) {
                if (Objects.equals(peçasForaDoLugar.get(pfd), peçasForaDoLugar.get(pfd + 1))) {
                    valorIgual = peçasForaDoLugar.get(pfd); //armazena qual valor igual é
                }
            }
        }

        return valorIgual;
    }

    /*
    Método responsável por encontrar a matriz no qual existe o valor heuristica igual
    expandir essa matriz e retornar um novo valor aplicável.
     */
    public int expandePuzzleDeMesmaHeuristica(int valorIgual, ArrayList<String[][]> puzzleFilhos, ArrayList<String[][]> puzzlePercorrido) {
        //encontrar o puzzle para o valorIgual
        ArrayList<String[][]> puzzleHeuristicaIguais = new ArrayList<>();

        for (String[][] pf : puzzleFilhos) {
            int peçasFl = calculaPecasForaDoLugar(pf);
            if (peçasFl == valorIgual) {
                puzzleHeuristicaIguais.add(pf);
            }
        }
        
        //Expandir os puzzle encontrados
        ExpandePuzzleHeuristicaIgual expandePuzzleHeuristicaIgual = new ExpandePuzzleHeuristicaIgual();
        ArrayList<Integer> novoValorHeuristica = new ArrayList<>();

        for (String[][] phi : puzzleHeuristicaIguais) {
            int expande = expandePuzzleHeuristicaIgual.expande(phi, puzzlePercorrido, valorIgual);
            novoValorHeuristica.add(expande);
        }
        
        //encontra Menor valor
        int menorValorHeuristica;
        menorValorHeuristica = encontraMenor(novoValorHeuristica);

        return menorValorHeuristica;
    }

    /*
    Método responsável por receber uma lista de heuristica contendo alguns valores iguais e outro diferent
    Ele deve retornar esse valor diferente na lista.
    */
    public int encontraValorDiferente(ArrayList<Integer> peçasForaDoLugar, int valorIgual) {
        int valorDiferente = valorIgual;
        for (Integer pfd : peçasForaDoLugar) {
            if (pfd != valorIgual) {
                valorDiferente = pfd;
            }
        }
        return valorDiferente;
    }

    /*método responsável por receber uma expansão (filho) do puzzle,
    calcular a quantidade de peças fora do lugar */
    public int calculaPecasForaDoLugar(String[][] puzzle) {
        Metodos metodos = new Metodos();

        String[][] puzzleMeta = new String[3][3];
        puzzleMeta = metodos.referenciaPuzzleMeta();
        int peçasForaDoLugar = 0;
        String valor;
        int[] posCorreta = new int[2];

        for (int i = 0; i < metodos.getTamMaximoPuzzle(); i++) {
            for (int j = 0; j < metodos.getTamMaximoPuzzle(); j++) {
                if (!puzzle[i][j].equals("_")) {
                    if (!puzzle[i][j].equals(puzzleMeta[i][j])) {
                        peçasForaDoLugar = peçasForaDoLugar + 1;
                    }
                }
            }
        }
        return peçasForaDoLugar;
    }

    /*Método responsável por encontrar o menor valor
    utilizando a heurística de peças fora do lugar,
     */
    public int encontraMenor(ArrayList<Integer> peçasForaDoLugar) {

        int menorValor = 100;
        for (Integer pfd : peçasForaDoLugar) {
            if (pfd < menorValor) {
                menorValor = pfd;
            }
        }
        return menorValor;
    }

}
