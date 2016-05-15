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
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
                 
        A = (A + ((B + C) / 60)) % 24;
        B = (B + C) % 60;
        System.out.println(A +" " + B);
         
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