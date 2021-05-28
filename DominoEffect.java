import javafx.util.Pair;

public class DominoEffect{

    static boolean HayFichaAux(int fila, int columna, int fila2, int columna2, int tablero[][], Pair<Pair<Integer,Integer>,Boolean> fichas[]){
        if(fila < 7 && columna < 8 && fila2 < 7 && columna2 < 8){
            for(int i = 0; i < fichas.length; i++){
                if (tablero[fila][columna] == fichas[i].getKey().getKey() && tablero[fila2][columna2] == fichas[i].getKey().getValue() 
                && fichas[i].getValue() == true) {
                    fichas[i] = new Pair<>(fichas[i].getKey(), false);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean HayFicha(int fila, int columna, int fila2, int columna2, int tablero[][], Pair<Pair<Integer,Integer>,Boolean> fichas[]){
        if(HayFichaAux(fila, columna, fila2 + 1, columna2, tablero,fichas)){
            return true;
        }
        return HayFichaAux(fila, columna, fila2, columna2 + 1, tablero, fichas);
    }

    public static void main(String[] args) {
        System.out.println("Run");
    }
}