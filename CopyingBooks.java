import java.util.Scanner;

import javax.management.monitor.StringMonitor;

public class CopyingBooks{

	public static int Solve(int base, int[] lista, int k, int[] pointers) {
		if (k == 1) {
			int suma = 0;
			for (int i = base; i < lista.length; i++) {
				suma += lista[i];
			}
			return suma;
		}  else {
			int sumaIzq = 0;
			int resultado = Integer.MAX_VALUE;
			boolean detenerse = false;
			while (base < lista.length-(k-1) && !detenerse) {
				sumaIzq += lista[base];
				base++;
				int sumaDer = Solve(base, lista, k-1, pointers);
				int resultadoActual = sumaDer;
				if (sumaIzq > sumaDer) {
					resultadoActual = sumaIzq;
					detenerse = true;
				}
				if (resultadoActual < resultado) {
					resultado = resultadoActual;
					pointers[k-1] = base;
				}
				if (resultadoActual == resultado) {
					
				}
			}	
			return resultado;
		}
	}
	

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        

        for (int i = 0; i < n; i++) {
            
            int m = scan.nextInt();
            int k = scan.nextInt();
            int books[] = new int[m];
			int aux = 0;

            for (int j = 0; j < m; j++) {
                books[j] = scan.nextInt();
				aux += books[j];
            }
                int[] pointers = new int[k];
            	int suma = Solve(0, books, k, pointers);
				String solucion[] = new String[books.length + pointers.length]; 
                if(suma == aux){
					for (int j = 0; j < books.length; j++) {
						
                    	System.out.println(books[j]+ " ");
                	}
				}else{
					for (int j = 0,temp = 1,z = 0; j < solucion.length && temp < pointers.length && z < books.length;) {
						if (pointers[temp] == j) {
							solucion[j] = "/";
							temp++;
							System.out.print(solucion[j] + " ");
							j++;
						}else{
							solucion[j] = books[z] + "";
							System.out.print(solucion[j] + " ");
							z++;
							j++;
						}
					}
				}
        }
        scan.close();
    }

}