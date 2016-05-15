import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/**
 * https://www.acmicpc.net/problem/2525
 * 오븐 시계
 * @author sknsk
 */
public class B_2525 {
	static int F; //총 계단수
    static int S; //강호 위치
    static int G; //스타트링크 위치
    static int U; //윗층
    static int D; //아래층
     
    static int [] visited;
    static int [] count;
     
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();
         
        visited = new int[1000001];
        count = new int[1000001];
        int index = BFS();
        System.out.println(index == -1 ? "use the stairs" : count[index] );
         
    }
     
    static int BFS(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(S);
        visited[S] = 1;
        count[S] = 0;
         
        while(!queue.isEmpty()) {
            S = queue.poll();
            if(S == G) {
                return S;
            }
            if(S + U <= G && visited[S + U] != 1) {
                queue.add(S + U);
                visited[S + U] = 1;
                count[S + U] = count[S] + 1;
            }
            if(S - D > 0 && visited[S - D] != 1) {
                queue.add(S - D);
                visited[S - D] = 1;
                count[S - D] = count[S] + 1;
            }
        }
        return -1;
    }
}
 
class FastScanner {
    BufferedReader br;
    StringTokenizer st;
     
    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
     
    String next() {
        while(st == null || !st.hasMoreTokens()){
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
     
    int nextInt() {
        return Integer.parseInt(next());
    }
}