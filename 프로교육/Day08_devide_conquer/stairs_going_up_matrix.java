import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class stairs_going_up_matrix {
	
	static int n;
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			
		}
		
	}
	
	static boolean isElementList() {
		return false;
	}
	static boolean isList() {
		return false;
	}
	
	static boolean isElement() {
		return false;
	}
	
	static boolean isAtom() {
		return false;
	}
	
	static class FScanner {
		BufferedReader br;
		StringTokenizer st;

		public FScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}
}


