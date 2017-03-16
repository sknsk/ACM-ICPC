import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class partial_sum {

	static int n;
	static int q;
	static long[] tree;
	static int[] a;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		q = Integer.parseInt(br.readLine());

		int size = n;
		for (int i = 1;;) {
			i <<= 1;
			if (i >= size) {
				n = i;
				break;
			}
		}
		a = new int[size + 1];
		tree = new long[n + 1];
		// initialize tree
		for (int i = 1; i <= size; i++) {
				int diff = i - a[i];
				a[i] = i;
				update(i, diff);
		}

		for (int i = 1; i <= q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (t == 1) {
				System.out.println(sum(y) - sum(x - 1));
				continue;
			}
			int diff = y - a[x];
			a[x] = y;
			update(x, diff);
		}

	}

	private static void update(int i, int diff) {
		while (i <= n) {
			tree[i] += diff;
			i += (i & -i);
		}
	}

	private static long sum(int i) {
		long ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
}
