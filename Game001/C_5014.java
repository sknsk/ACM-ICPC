import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5014
 * 스타트링크
 * @author sknsk
 */
public class C5014 {
     
	static int F; //건물층수
	static int S; //강호
	static int G; //스타트링크
	static int U; //위칸수
	static int D; //아래칸수
	
	static int [] visited;
	static int min = 10000001;
	
    public static void main(String[] args) {
    	FastScanner sc = new FastScanner();
    	F = sc.nextInt();
    	S = sc.nextInt();
    	G = sc.nextInt();
    	U = sc.nextInt();
    	D = sc.nextInt();
    	visited = new int[1000001];
    	DFS(S, 0);
    	System.out.println(min == 10000001 ? "use the stairs" : min);
    	
    }
    
    static void DFS(int loc, int cnt){
        
    	if(cnt > min) {
        	return;
        }
        
        if(loc == G){
            if(cnt < min) {
            	min = cnt;
            }
            return;
        }
        
        visited[loc] = 1;
        
        if(loc + U <= F && visited[loc + U] != 1) {
        	DFS(loc + U, cnt + 1);
        }
        
        if(loc - D > 0&& visited[loc - D] != 1) {
        	DFS(loc - D, cnt + 1);
        }
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
                st = new StringTokenizer(br.readLine().trim());
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