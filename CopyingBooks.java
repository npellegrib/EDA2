import java.util.Scanner;

public class CopyingBooks{

 

    public static Object Solve(int list[],int k){
        if (k == 1) {
            return list;
        }else{
            return SolveAux(list, k);
        }
    }

    public static String[] SolveAux(int list[], int k){
        int max = list[0];
        String answer[] = new String[(list.length - 1) + k - 1];
        int pointers[] = new int[k];
        int index = 0;

        for (int i = 1; i < list.length;) {
            if (max > MinArray(i, list.length - 1, list) && index < pointers.length) {
                pointers[index] = i;
                index++;
                max = list[i];
            }else{
                max = max + list[i];
                i++;
            }
        }

        index = 0;
        int j = 0;

        for (int i = 0; i < answer.length; i++) {
            
            if (j < pointers.length && index < list.length) {
                if (pointers[j] == i) {
                    answer[i] = "/";
                    j++;
                }else{
                    answer[i] = list[index] + "";
                    index++;
                }
            }
        }

        return answer;

    }

    public static int MinArray(int start, int end,int books[]){
        if (start == end) {
            return books[start];
        }else{
            int middle = (start + end)/2;
            int Min_Left = MinArray(start, middle, books);
            int Min_Rigth = MinArray(middle + 1, end, books);
            int Min_Middle = CalcMinMiddle(books, middle);

            return Math.min(Min_Left,Math.min(Min_Rigth, Min_Middle));
        }
    }


    public static int CalcMinMiddle(int aux[],int index){
        int suma = 0;
        int Max_Left = -1000000000;
        for(int i = 0; i < index -1;i++ ){
            suma = suma + aux[i];
            if (suma > Max_Left) {
                Max_Left = suma;
            }
        }

        suma = 0;
        int Max_Rigth = -1000000000;
        for (int i = index; i < aux.length; i++) {
            suma = suma + aux[i];
            if (suma > Max_Rigth) {
                Max_Rigth = suma;
            }
        }

        return Max_Left + Max_Rigth;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        

        for (int i = 0; i < n; i++) {
            
            int m = scan.nextInt();
            int k = scan.nextInt();
            int books[] = new int[m];

            for (int j = 0; j < m; j++) {
                books[j] = scan.nextInt();
            }
            if (k == 1) {
                int solution[] = (int[])Solve(books, k); 

                for (int j = 0; j < solution.length; j++) {
                    System.out.println(solution[j]+ " ");
                }
            }else{
                String sol[] = (String[])Solve(books, k);
                for (int j = 0; j < sol.length - 1; j++) {
                    System.out.println(sol[j]+ " ");
                }
            }
        }
        scan.close();
    }

}