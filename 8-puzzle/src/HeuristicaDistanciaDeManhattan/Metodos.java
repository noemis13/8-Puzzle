package HeuristicaDistanciaDeManhattan;

import HeuristicaNumeroPeçasForaDoLugar.Puzzle;
import java.util.ArrayList;
import java.util.Arrays;

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
}
