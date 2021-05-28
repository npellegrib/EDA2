
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Scanner;


public class Prueba2 {

    public static boolean HayFichaHorizontal(int fila, int columna,int tablero[][],Pair<Pair<Integer,Integer>,Boolean> fichas[]){
        for (int i = 0; i < fichas.length; i++) {
            if (columna < 7) {
                if (tablero[fila][columna] == fichas[i].getKey().getKey() && tablero[fila][columna + 1] == fichas[i].getKey().getValue()) {
                    fichas[i] = new Pair<>(fichas[i].getKey(), false);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean HayFichaVertical(int fila, int columna,int tablero[][],Pair<Pair<Integer,Integer>,Boolean> fichas[]){
        for (int i = 0; i < fichas.length; i++) {
            if(fila < 6){
                if (tablero[fila][columna] == fichas[i].getKey().getKey() && tablero[fila + 1][columna] == fichas[i].getKey().getValue()) {
                    fichas[i] = new Pair<>(fichas[i].getKey(), false);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean PonerFichas(int fila, int columna,int tablero[][],Pair<Pair<Integer,Integer>,Boolean> fichas[], int sol[][]){

        boolean resultado = true;

        for (int i = 0; i < tablero.length; i++) {
            if (HayFichaHorizontal(fila, columna, tablero, fichas)){
                sol[fila][columna] = i + 1;
                sol[fila][columna + 1] = i + 1;
            }else if (HayFichaVertical(fila, columna, tablero, fichas)){
                sol[fila][columna] = i + 1;
                sol[fila + 1][columna] = i + 1;
            }
        }
        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i].getValue()) {
                resultado = false;
                return resultado;
            }
        }
        return resultado;
    }

    public static boolean PonerFichas2(int fila, int columna,int tablero[][],Pair<Pair<Integer,Integer>,Boolean> fichas[], int sol[][]){

        boolean resultado = true;

        for (int i = 0; i < tablero.length; i++) {
            if (HayFichaVertical(fila, columna, tablero, fichas)){
                sol[fila][columna] = i + 1;
                sol[fila + 1][columna] = i + 1;
            }else if (HayFichaHorizontal(fila, columna, tablero, fichas)){
                sol[fila][columna] = i + 1;
                sol[fila][columna + 1] = i + 1;
            }
        }
        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i].getValue()) {
                resultado = false;
                return resultado;
            }
        }
        return resultado;
    }

}
