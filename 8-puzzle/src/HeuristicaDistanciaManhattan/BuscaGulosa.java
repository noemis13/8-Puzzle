package HeuristicaDistanciaManhattan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

        int quantidadeExpansoes = 0;
        expandePuzzle(puzzleIni, puzzlePercorrido, quantidadeExpansoes);
    }

    /*
    responsável por receber um puzzle e expandir todas as suas possibilidade.
    Ele deve verificar se as expansões ja foram repetidas.
     */
    public static void expandePuzzle(String puzzle[][], ArrayList<String[][]> puzzlePercorrido, int quantidadeExpansoes) {
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
        buscaGulosa.encontraValorHeuritica(puzzleFilhos, puzzlePercorrido, quantidadeExpansoes);
    }

    /*Método responsável por receber uma lista contendo uma
    expasão do puzzle e encontrar qual é a melhor expansão para se usar
     */
    public void encontraValorHeuritica(ArrayList<String[][]> puzzleFilhos, ArrayList<String[][]> puzzlePercorrido, int quantidadeExpansoes) {
        Metodos metodos = new Metodos();
        ExpandePuzzleHeuristicaIgual expandePuzzleHeuristicaIgual = new ExpandePuzzleHeuristicaIgual();

        int menorValorHeuristica = 0, contExpansoesIguais = 0;
        String[][] puzzle = new String[3][3];

        int peçasForaDoLugar;
        Map<String[][], Integer> puzzleEheuristica = new HashMap<>();
        Map<String[][], Integer> puzzleEheuristicaIguais = new HashMap<>();

        ArrayList<Integer> heuristica = new ArrayList<>();
        ArrayList<Integer> heuristicasIguais = new ArrayList<>();

        //calcular o valor da heuristica de cada puzzle
        for (String[][] i : puzzleFilhos) {
            peçasForaDoLugar = calculaDistanciaManhattan(i);
            puzzleEheuristica.put(i, peçasForaDoLugar);
            heuristica.add(peçasForaDoLugar);
        }

        for (Map.Entry<String[][], Integer> peh : puzzleEheuristica.entrySet()){
            System.out.println(Arrays.deepToString(peh.getKey()));
            System.out.println("Heuristica: "+peh.getValue());
        }
        
        //-------------------------------------------------------------------------
        //valores da heuristica iguais
        int ehHeuristicaIgual;
        
        if (puzzleEheuristica.size() == 1) {
            for (Map.Entry<String[][], Integer> peh : puzzleEheuristica.entrySet()) {
                menorValorHeuristica = peh.getValue();
                puzzle = peh.getKey();
            }

        } else if (puzzleEheuristica.size() == 2) {
            ehHeuristicaIgual = verificaIgualdadeHeuristica(heuristica);
           
            if (ehHeuristicaIgual == 0) {
                menorValorHeuristica = encontraMenor(heuristica);
                puzzle = encontraPuzzleDaHeuristica(puzzleEheuristica, menorValorHeuristica);

            } else {
                for (Map.Entry<String[][], Integer> peh : puzzleEheuristica.entrySet()) {
                    if (peh.getValue() == ehHeuristicaIgual) {
                        int novoValor;
                        novoValor = expandePuzzleHeuristicaIgual.expandeBuscaGulosa(peh.getKey(), puzzlePercorrido, ehHeuristicaIgual, contExpansoesIguais);
                        puzzleEheuristicaIguais.put(peh.getKey(), novoValor);
                        heuristicasIguais.add(novoValor);
                    }
                }//for                   
                    
                menorValorHeuristica = encontraMenor(heuristicasIguais);
                for (Map.Entry<String[][], Integer> pehi : puzzleEheuristicaIguais.entrySet()) {
                    if (pehi.getValue() == menorValorHeuristica) {
                        puzzle = pehi.getKey();
                    }
                }
            }//else

        } else {
            ehHeuristicaIgual = verificaIgualdadeHeuristica(heuristica);
            if(ehHeuristicaIgual == 0) {
                menorValorHeuristica = encontraMenor(heuristica);
                puzzle = encontraPuzzleDaHeuristica(puzzleEheuristica, menorValorHeuristica);
            
            }else {
                int menor = encontraMenor(heuristica);
                if(menor != ehHeuristicaIgual) {
                    menorValorHeuristica = menor;
                    puzzle = encontraPuzzleDaHeuristica(puzzleEheuristica, menorValorHeuristica);
                
                }else {
                    
                    for (Map.Entry<String[][], Integer> pehi : puzzleEheuristica.entrySet()) {
                        if(pehi.getValue() == ehHeuristicaIgual){
                           
                            int novoValorHeuristica;
                            novoValorHeuristica = expandePuzzleHeuristicaIgual.expandeBuscaGulosa(pehi.getKey(), puzzlePercorrido, ehHeuristicaIgual, contExpansoesIguais);
                            puzzleEheuristicaIguais.put(pehi.getKey(), novoValorHeuristica);
                            heuristicasIguais.add(novoValorHeuristica);
                     
                        
                        }else{
                            puzzleEheuristicaIguais.put(pehi.getKey(), pehi.getValue());
                            heuristicasIguais.add(pehi.getValue());
                           
                        }
                    }//for
                    menorValorHeuristica = encontraMenor(heuristicasIguais);
                    puzzle = encontraPuzzleDaHeuristica(puzzleEheuristicaIguais, menorValorHeuristica);
                    
                }//else
            }
            
        }//fim das comparações

        //-------------------------------------------------------------------------
        //adiciona o que ja foi percorrido;
        puzzlePercorrido.add(puzzle);

        quantidadeExpansoes = quantidadeExpansoes + 1;
        //verifica se o puzzle é o meta, se não expande novamente os filhos e 
        int ehPuzzleFInal;
        ehPuzzleFInal = metodos.comparaPuzzleFinal(puzzle);
            
        if (ehPuzzleFInal == 0) {
            metodos.imprimePuzzle(puzzle);
            System.out.println("valor heuristica: " + menorValorHeuristica);
            System.out.println("\n");
            System.out.println("Quantidade de expansoes: "+quantidadeExpansoes);
            expandePuzzle(puzzle, puzzlePercorrido, quantidadeExpansoes);
            
        } else {
            System.out.println("Puzzle final obtido! ");
            metodos.imprimePuzzle(puzzle);     
            System.out.println("\n");
        }
    }

    /*
    Método responsável por varificar se os valores das heuristicas são iguais
     */
    public int verificaIgualdadeHeuristica(ArrayList<Integer> heuristica) {
        int tamHeuristica = heuristica.size();
        int valorIgual = 0; //nao igual
        
        for (int h = 0; h < heuristica.size(); h++) {
            if ((h + 1) < tamHeuristica) {
                if (Objects.equals(heuristica.get(h), heuristica.get(h + 1))) {
                    valorIgual = heuristica.get(h); //armazena qual valor igual é
                }
            }
        }
        
        if(valorIgual == 0 && tamHeuristica >= 3){
            valorIgual = heuristica.get(0);
            for (int h = 1; h < heuristica.size(); h++){
                if(heuristica.get(h) == valorIgual) {
                    valorIgual = heuristica.get(h);
                }else {
                    valorIgual = 0;
                }
            }
        }
        return valorIgual;
    }


    /*
    Método responsável por encontrar puzzle da menor heuristica
     */
    public String[][] encontraPuzzleDaHeuristica(Map<String[][], Integer> puzzleEheuristica, int menorValorHeuristica) {
        String[][] puzzle = new String[3][3];

        for (Map.Entry<String[][], Integer> peh : puzzleEheuristica.entrySet()) {
            if (peh.getValue() == menorValorHeuristica) {
                puzzle = peh.getKey();
            }
        }

        return puzzle;
    }

    /*
    Método responsável por receber heuristicas com valores iguas e um diferente
    retornar esse valor diferente
     */
    public int encontraValorDiferente(ArrayList<Integer> heuristica, int ehHeuristicaIgual) {
        int valorDiferente = ehHeuristicaIgual;
        for (Integer h : heuristica) {
            if (h != ehHeuristicaIgual) {
                valorDiferente = h;
            }
        }
        
        return valorDiferente;
    }

    /*método responsável por receber uma expansão (filho) do puzzle,
    calcular heuristica */
    public int calculaDistanciaManhattan(String[][] puzzle) {
        Metodos metodos = new Metodos();

        String[][] puzzleMeta = new String[3][3];
        puzzleMeta = metodos.referenciaPuzzleMeta();

        int peçasForaDoLugar = 0, posLinhaPuzzleMeta, posColunaPuzzleMeta;
        
        for (int i = 0; i < metodos.getTamMaximoPuzzle(); i++) {
            for (int j = 0; j < metodos.getTamMaximoPuzzle(); j++) {
                if(!puzzle[i][j].equals("_")) {
                    if(!puzzle[i][j].equals(puzzleMeta[i][j])) {
                        posLinhaPuzzleMeta = encontraPosLinhaPuzzle(puzzle[i][j], puzzleMeta);
                        posColunaPuzzleMeta = encontraPosColunaPuzzle(puzzle[i][j], puzzleMeta);
                        //quadrado = (int) (Math.pow((i-posLinhaPuzzleMeta), 2) + Math.pow((j-posColunaPuzzleMeta), 2));
                       peçasForaDoLugar = peçasForaDoLugar + (Math.abs(i-posLinhaPuzzleMeta) + Math.abs(j-posColunaPuzzleMeta));
           
                    }
                }
            }//for
        }//for
        
        return peçasForaDoLugar;
    }
    
    /*
    encontraPosLinhaPuzzle e enencontraPosColunaPuzzle são método que complementa o método da heuristica.
    Sua finalidade é achar a posição onde está o elemento atual do puzzle no puzzleMeta
    e retornar essa posição
    */
    public int encontraPosLinhaPuzzle(String valorPuzzle, String[][] puzzleMeta) {
        int posLinhaPuzzleMeta = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(puzzleMeta[i][j].equals(valorPuzzle)){
                    posLinhaPuzzleMeta = i;
                }
            }
        }
        return posLinhaPuzzleMeta;
    }
    
    public int encontraPosColunaPuzzle(String valorPuzzle, String[][] puzzleMeta) {
        int posLinhaPuzzleMeta = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(puzzleMeta[i][j].equals(valorPuzzle)){
                    posLinhaPuzzleMeta = j;
                }
            }
        }
        return posLinhaPuzzleMeta;
    }


    /*Método responsável por encontrar o menor valor
    utilizando a heurística de peças fora do lugar,
     */
    public int encontraMenor(ArrayList<Integer> heuristica) {
        int menorValor = 10000000;
        for (Integer pfd : heuristica) {
            if (pfd < menorValor) {
                menorValor = pfd;
            }
        }
        return menorValor;
    }

}
