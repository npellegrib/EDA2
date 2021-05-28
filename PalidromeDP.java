import java.util.Scanner;

class PalidromeDP{


	public static int Solve(String s){
		int table[][] = new int[s.length()][s.length()];

		for (int i = 0; i <  s.length();i++ ) {
			table[i][i] = 1;
		}

		int cont = 1;

		for(int i = 0, j = i + cont; i < s.length() && j < s.length();){
			if (s.charAt(i) == s.charAt(j)) {
				table[i][j] = 2 + table[i + 1][j - 1];
			}else{
				table[i][j] = Math.max(table[i][j - 1],table[i + 1][j]);
			}

			if (j == s.length() - 1 && j - i != s.length() - 1 && cont != s.length() - 1) {
				cont++;
				j = cont;
				i = 0;
			}else{
				i++;
				j++;
			}
		}
		
		return table[0][s.length() - 1];
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < n ; i++) {	
			String s = scan.nextLine();
			System.out.println(Solve(s));
		}
		scan.close();
	}
}