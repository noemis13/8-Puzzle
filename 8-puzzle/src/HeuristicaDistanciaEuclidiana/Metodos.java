package HeuristicaDistanciaEuclidiana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author ns
 */
public class Metodos {
    private int tamMaximoPuzzle = 3;

    public Metodos() {
    }

    public int getTamMaximoPuzzle() {
        return tamMaximoPuzzle;
    }

    /*método responsável por receber uma expansão (filho) do puzzle,
    calcular heuristica */
    public int calculaDistanciaEuclidiana(String[][] puzzle) {
        Metodos metodos = new Metodos();

        String[][] puzzleMeta = new String[3][3];
        puzzleMeta = metodos.referenciaPuzzleMeta();

        int peçasForaDoLugar = 0, posLinhaPuzzleMeta, posColunaPuzzleMeta;
        
        for (int i = 0; i < metodos.getTamMaximoPuzzle(); i++) {
            for (int j = 0; j < metodos.getTamMaximoPuzzle(); j++) {
                if(!puzzle[i][j].equals("_")) {
                    if(!puzzle[i][j].equals(puzzleMeta[i][j])) {
                        /*posLinhaPuzzleMeta = encontraPosLinhaPuzzle(puzzle[i][j], puzzleMeta);
                        posColunaPuzzleMeta = encontraPosColunaPuzzle(puzzle[i][j], puzzleMeta);
                        peçasForaDoLugar = peçasForaDoLugar + (Math.abs(i-posLinhaPuzzleMeta) + Math.abs(j-posColunaPuzzleMeta));
                        */int quadrado = 0;
                        posLinhaPuzzleMeta = encontraPosLinhaPuzzle(puzzle[i][j], puzzleMeta);
                        posColunaPuzzleMeta = encontraPosColunaPuzzle(puzzle[i][j], puzzleMeta);
                        quadrado = (int) (Math.pow((i-posLinhaPuzzleMeta), 2) + Math.pow((j-posColunaPuzzleMeta), 2));
                        peçasForaDoLugar = (int) (peçasForaDoLugar + (Math.sqrt(quadrado)));
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

 /*
    Método responsável por varificar se os valores das heuristicas são iguais
     */
    public double verificaIgualdadeHeuristica(ArrayList<Double> heuristica) {
        double valorIgual = 0; //nao igual
        int tamHeuristica = heuristica.size();

        for (int pfd = 0; pfd < heuristica.size(); pfd++) {
            if ((pfd + 1) < tamHeuristica) {
                if (Objects.equals(heuristica.get(pfd), heuristica.get(pfd + 1))) {
                    valorIgual = heuristica.get(pfd); //armazena qual valor igual é
                }
            }
        }
        if (valorIgual == 0 && tamHeuristica >= 3) {
            valorIgual = heuristica.get(0);
            for (int h = 1; h < heuristica.size(); h++) {
                if (heuristica.get(h) == valorIgual) {
                    valorIgual = heuristica.get(h);
                } else {
                    valorIgual = 0;
                }
            }
        }

        return valorIgual;
    }

    /*Método responsável por encontrar o menor valor
    utilizando a heurística de peças fora do lugar,
     */
    public double encontraMenor(ArrayList<Double> heuristica) {

        double menorValor = 10000;
        for (Double pfd : heuristica) {
            if (pfd < menorValor) {
                menorValor = pfd;
            }
        }
        return menorValor;
    }


    /*
    Método responsável por encontrar puzzle da menor heuristica
     */
    public String[][] encontraPuzzleDaHeuristica(Map<String[][], Double> puzzleEheuristica, Double menorValorHeuristica) {
        String[][] puzzle = new String[3][3];

        for (Map.Entry<String[][], Double> peh : puzzleEheuristica.entrySet()) {
            if (Objects.equals(peh.getValue(), menorValorHeuristica)) {
                puzzle = peh.getKey();
            }
        }
        return puzzle;
    }

    /*
    Método responsável por receber heuristicas com valores iguas e um diferente
    retornar esse valor diferente
     */
    public double encontraValorDiferente(ArrayList<Double> heuristica, double ehHeuristicaIgual) {
        double valorDiferente = ehHeuristicaIgual;
        for (Double h : heuristica) {
            if (h != ehHeuristicaIgual) {
                valorDiferente = h;
            }
        }
        return valorDiferente;
    }
    /*
        Método responsável por receber uma expansão do puzzle
        e verificar se essa expansão é o estado final.
     */
    public int comparaPuzzleFinal(String[][] puzzle) {
        String[][] puzzleMeta = new String[3][3];
        puzzleMeta = referenciaPuzzleMeta();

        ArrayList<Integer> ehPuzzle = new ArrayList<>();
        int pm = 0;
        for (String[] p : puzzle) {
            if (Arrays.equals(p, puzzleMeta[pm])) {
                ehPuzzle.add(1);
            } else {
                ehPuzzle.add(0);
            }
            pm = pm + 1;
        }

        if (ehPuzzle.contains(0)) {
            return 0;
        } else {
            return 1;
        }
    }

    /*
    Método que adiciona uma cor ao filho
    se vermelho, o filho é uma expansão que já foi feita.
    se azul, o filho é válido.
     */
    public String adicionaCores(ArrayList<String[][]> filhoPuzzle, ArrayList<String[][]> puzzlePercorrido) {
        String cor = "azul";

        for (String[][] i : puzzlePercorrido) {
            for (String[][] j : filhoPuzzle) {
                if (Arrays.deepToString(i).equals(Arrays.deepToString(j))) {
                    cor = "vermelho";
                }
            }

        }
        return cor;
    }

    /*
    Método responsável por atribuir a uma variavel o puzzle meta
     */
    public String[][] referenciaPuzzleMeta() {
        HeuristicaDistanciaManhattan.Puzzle puzz = new HeuristicaDistanciaManhattan.Puzzle();
        String[][] puzzleMeta = new String[3][3];
        puzzleMeta = puzz.estadoMeta();

        return puzzleMeta;
    }

    public void imprimePuzzle(String[][] puzzle) {
        for (int i = 0; i < tamMaximoPuzzle; i++) {
            for (int j = 0; j < tamMaximoPuzzle; j++) {
                System.out.print(puzzle[i][j]);
            }
            System.out.print("\n");
        }
    }

    
}
