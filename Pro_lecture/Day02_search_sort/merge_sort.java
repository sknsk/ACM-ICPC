import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class merge_sort {
	
	static int [] perm;
	static int [] tmp;
	static int N;
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		N = sc.nextInt();
		perm = new int[N];
		tmp = new int[N];
		mergeSort(0, N - 1);
		sc.close();
	}
	
	private static void mergeSort(int p, int q){
		int mid = (p + q) / 2;
		if (p - q == 0) {
			return;
		}
		mergeSort(p, mid);
		mergeSort(q + 1, q);
		merge(p, mid, q);
	}
	
	private static void merge(int p, int q, int r) {
		
		for(int i = p; i <= r; i++) {
			tmp[i] = perm[i];
		}
		int pt1 = p;
		int pt2 = q + 1;
		int index = p;
		while(pt1 <= q && pt2 <= r) {
			if(tmp[pt1] > tmp[pt2]) {
				perm[index++] = tmp[pt2++];
			}else{
				perm[index++] = tmp[pt1++];
			}
		}
		while(pt1 <= q) {
			perm[index++] = tmp[pt1++];
		}
		
		while(pt2 <= r) {
			perm[index++] = tmp[pt2++];
		}
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
