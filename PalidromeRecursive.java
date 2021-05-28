import java.util.Scanner;

class PalidromeRecursive{

	public static int Solve(String s){
		if (s.length() == 1 || s.length() == 0) {
			return s.length();
		}else{
			int p = 0;
			int u = 0;
			if (s.charAt(0) == s.charAt(s.length() - 1)) {
				 p = 2 + Solve(s.substring(1, s.length() - 1));
			}else{
				 u = Math.max(Solve(s.substring(1,s.length())),Solve(s.substring(0,s.length() - 1)));
			}
			return Math.max(p,u);
		}
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



// int a = 0;
// 		int b = 1;
// 		int c = 0;


// 		for (int i = 0, j = s.length() - 1;i < s.length() && j >= 0 ;) {
// 			if (s.charAt(i) == s.charAt(j) && i != j) {
// 				c = 2 + Math.max(a,b);
// 				a = b;
// 				b = c;
// 				i++;
// 				j--;
// 			}else {
// 				if (i < s.length() - 1) {
// 					if (s.charAt(i + 1) == s.charAt(j)) {
// 						c = 2 + Math.max(a,b);
// 						a = b;
// 						b = c;
// 						i = i + 2;
// 						j--;
// 					}else{
// 						c = Math.max(a,b);
// 						a = b;
// 						b = c;
// 					}
// 				}

// 				if (j > 0) {
// 					if (s.charAt(i) == s.charAt(j - 1)) {
// 						c = 2 + Math.max(a,b);
// 						a = b;
// 						b = c;
// 						j = j - 2;
// 						i++;
// 					}else{
// 						c = Math.max(a,b);
// 						a = b;
// 						b = c;
// 					}
// 				}
// 			}
// 		}

// 		return b;