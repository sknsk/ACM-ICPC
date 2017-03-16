import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS {

	static int n;
	static int[] tree;
	static int [] a;
	static int [] b;
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		n = sc.nextInt();
		a = new int[n + 1];
		b = new int[n + 1];
		tree = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
			b[i] = a[i];
		}
		Arrays.sort(b);
		for(int i = 1; i <= n; i++) {
			a[i] = binarySearch(b, a[i]);
		}
		for(int i = 1; i <= n; i++) {
			int v = get(a[i] - 1) + 1;
			update(a[i], v);
		}
		System.out.println(tree[n]);
		sc.close();
	}

	static int binarySearch(final int [] arr, int val) {
		int left = 1;
		int right = arr.length - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (arr[mid] == val) {
				return mid;
			} else if (arr[mid] > val) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -(left + 1);
	}

	static void update(int i, int num) {
		while (i <= n) {
			tree[i] = Math.max(tree[i], num);
			i += (i & -i);
		}
	}

	static int get(int i) {
		int ans = 0;
		while (i > 0) {
			ans = Math.max(ans, tree[i]);
			i -= (i & -i);
		}
		return ans;
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
