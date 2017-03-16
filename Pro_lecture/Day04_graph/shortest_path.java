
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//방향이 없는거네 ㅅㅂ
public class shortest_path {

	static int N;
	static int M;
	static ArrayList<Node>[] adjList;
//	static Set<Integer> settled;
	static PriorityQueue<Node> que;
	static long [] dist;

	public static void main(String[] args) {
		FScanner sc = new FScanner();

		N = sc.nextInt();
		M = sc.nextInt();
		adjList = new ArrayList[N + 1];
		
		dist = new long[N + 1];
//		settled = new HashSet<Integer>();
		que = new PriorityQueue<Node>();
		
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
			dist[i] = Long.MAX_VALUE;
		}

		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adjList[a].add(new Node(b, c));
			adjList[b].add(new Node(a, c));
		}
		solve(1);

		sc.close();
	}

	private static void solve(int start) {
		dist[start] = 0;
		que.offer(new Node(start, dist[start]));
		
		while(!que.isEmpty()) {
			Node q = que.remove();
			int here = q.getVertex();
			long cost = q.getWeight();
			
			//return 조건 필요??
			
			for (Node node : adjList[here]) {
				int desNode = node.getVertex();
				long distance = node.getWeight();
				if (dist[desNode] > dist[here] + distance) {
					dist[desNode] = dist[here] + distance;
					que.offer(new Node(desNode, dist[desNode]));
				}
			}
		}
		System.out.print(dist[N] == Long.MAX_VALUE ? -1 : dist[N]);
		
	}

	static class Node implements Comparable<Node>{

		private int vertex;
		private long weight;

		public Node(int vertex, long weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public int getVertex() {
			return vertex;
		}

		public void setVertex(int vertex) {
			this.vertex = vertex;
		}

		public long getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
	
		public int compareTo(Node n){
	        return weight <= n.weight ? -1 : 1;
	    }

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + "]";
		}
		
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
