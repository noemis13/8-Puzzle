package pkg8.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author ns
 */
public class BuscaGulosa {

    private int tamMaximoPuzzle = 3;

    public BuscaGulosa() {
    }

    /*Método responsável por receber uma lista contendo uma
    expasão do puzzle e encontrar qual é a melhor expansão para se usar
     */
    public void encontraValorHeuritica(ArrayList<String[][]> puzzleFilhos, ArrayList<String[][]> puzzlePercorrido) {
        ExpandeFilhos expandeFilhos = new ExpandeFilhos();
        ExpandePuzzle expandePuzzle = new ExpandePuzzle();

        int menorValorHeuristica = 0, peçasFLugar;
        String[][] puzzle = new String[3][3];
        ArrayList<Integer> peçasForaDoLugar = new ArrayList<>();

        //calcular o valor da heuristica de cada puzzle
        for (String[][] i : puzzleFilhos) {
            peçasForaDoLugar.add(calculaPecasForaDoLugar(i));
        }

        System.out.println("heuristica antes: " + peçasForaDoLugar);

        //valores da heuristica iguais
        String[][] puzzleHeuristicaIguais = new String[3][3];
        String[][] puzzleHeuristicaIguais2 = new String[3][3];
        int valoresHeuristicaIguais, valoresHeuristicaIguais2;
        int tamPeçasForaDoLugar = peçasForaDoLugar.size();

        
        for (int pfd = 0; pfd < peçasForaDoLugar.size(); pfd++) {
            if ((pfd + 1) < tamPeçasForaDoLugar) {
                if (Objects.equals(peçasForaDoLugar.get(pfd), peçasForaDoLugar.get(pfd + 1))) {
                    puzzleHeuristicaIguais = encontraPuzzle(puzzleFilhos, peçasForaDoLugar.get(pfd));
                    valoresHeuristicaIguais = expandePuzzle.expande(puzzleHeuristicaIguais, puzzlePercorrido, peçasForaDoLugar.get(pfd));

                    puzzleHeuristicaIguais2 = encontraPuzzle2(puzzleFilhos, peçasForaDoLugar.get(pfd + 1), puzzleHeuristicaIguais);
                    valoresHeuristicaIguais2 = expandePuzzle.expande(puzzleHeuristicaIguais2, puzzlePercorrido, peçasForaDoLugar.get(pfd + 1));

                    peçasForaDoLugar.remove(pfd);
                    peçasForaDoLugar.add(pfd, valoresHeuristicaIguais);

                    peçasForaDoLugar.remove(pfd + 1);
                    peçasForaDoLugar.add((pfd + 1), valoresHeuristicaIguais2);
                }
            }
        }

        System.out.println("Heuristica sem repetição: " + peçasForaDoLugar);
        //calcula menor heurística
        menorValorHeuristica = encontraMenor(peçasForaDoLugar);

        //descobrir a qual matriz o menor valor pertenece
        for (String[][] pf : puzzleFilhos) {
            peçasFLugar = calculaPecasForaDoLugar(pf);
            if (peçasFLugar == menorValorHeuristica) {
                puzzle = pf;
                break;
            }
        }

        //adiciona o novo puzzle no puzzlePercorrido
        puzzlePercorrido.add(puzzle);

        //-------------------------------------------------------------------
        //verifica se o puzzle é o meta, se não expande novamente os filhos e 
        //salva em uma lista os nós expadidos
        ArrayList<String[][]> puzzleExpandidos = new ArrayList<>();
        puzzleExpandidos.add(puzzle);

        int ehPuzzleFInal;
        ehPuzzleFInal = comparaPuzzleFinal(puzzle);

        if (ehPuzzleFInal == 0) {
            imprimePuzzle(puzzle);
            System.out.println("valor heuristica" + menorValorHeuristica);
            System.out.println("\n");
            expandeFilhos.expandePuzzle(puzzle, puzzlePercorrido);
        } else {
            System.out.println("Puzzle final obtido \n");

        }
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

    /*método responsável por receber uma expansão (filho) do puzzle,
    calcular a quantidade de peças fora do lugar */
    public int calculaPecasForaDoLugar(String[][] puzzle) {
        String[][] puzzleMeta = new String[3][3];
        puzzleMeta = referenciaPuzzleMeta();
        int peçasForaDoLugar = 0;
        String valor;
        int[] posCorreta = new int[2];

        for (int i = 0; i < tamMaximoPuzzle; i++) {
            for (int j = 0; j < tamMaximoPuzzle; j++) {
                if (!puzzle[i][j].equals("_")) {
                    if (!puzzle[i][j].equals(puzzleMeta[i][j])) {
                        peçasForaDoLugar = peçasForaDoLugar + 1;
                    }
                }
            }
        }
        return peçasForaDoLugar;
    }

    /*
    Método responsável por receber um puzzle e valor de heuristicasIguais e determinar
    a qual puzzle esse valor pertence
     */
    public String[][] encontraPuzzle(ArrayList<String[][]> puzzleFilhos, int valorPeçasForaDoLugar) {
        String[][] puzzleHeuristicaIguais = new String[3][3];
        for (String[][] pf : puzzleFilhos) {
            int peçasFl = calculaPecasForaDoLugar(pf);
            if (peçasFl == valorPeçasForaDoLugar) {
                puzzleHeuristicaIguais = pf;
            }
        }
        return puzzleHeuristicaIguais;
    }

    public String[][] encontraPuzzle2(ArrayList<String[][]> puzzleFilhos, int valorPeçasForaDoLugar, String[][] puzzleHeuristica) {
        String[][] puzzleHeuristicaIguais = new String[3][3];
        for (String[][] pf : puzzleFilhos) {
            int peçasFl = calculaPecasForaDoLugar(pf);
            if ((peçasFl == valorPeçasForaDoLugar) && (!Arrays.equals(pf, puzzleHeuristica))) {
                puzzleHeuristicaIguais = pf;
            }
        }
        return puzzleHeuristicaIguais;
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

    /*
    Método responsável por atribuir a uma variavel o puzzle meta
     */
    public String[][] referenciaPuzzleMeta() {
        Puzzle puzz = new Puzzle();
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

    public static void main(String[] args) {
        ExpandeFilhos expandeFilhos = new ExpandeFilhos();
        Puzzle puzz = new Puzzle();

        String[][] puzzleIni = new String[3][3];
        puzzleIni = puzz.puzzleInicio();

        ArrayList<String[][]> puzzlePercorrido = new ArrayList<>();
        puzzlePercorrido.add(puzzleIni);

        expandeFilhos.expandePuzzle(puzzleIni, puzzlePercorrido);

    }

}
