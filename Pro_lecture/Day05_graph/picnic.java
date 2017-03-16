import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class picnic {
	
	static int k;
	static int n;
	static int m;
	static int [] cowPos;
	static ArrayList<Integer> [] adjList;
	
	//각각에 대해서 BFS만 돌리면 된당
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		k = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();
		cowPos = new int [k + 1];
		for(int i = 1; i <= k; i++) {
			cowPos[i] = sc.nextInt();
		}
		adjList = new ArrayList[n];		
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for(int i = 1; i <= m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adjList[x].add(y);
		}
		
		//solve
		
		sc.close();
	}
	
	static void bfs() {
		Queue que = new LinkedList<Integer>();
		
	}
													
	static class FScanner {
		BufferedReader br;
		StringTokenizer st;	
		public FScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {}
			}
			return st.nextToken(); 
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		void close(){
			try {
				br.close();
			} catch (IOException e) {}
		}
	}
}
