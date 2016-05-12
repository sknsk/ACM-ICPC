import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
     
    public static void main(String[] args) {
    	
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
    
    long nextLong() {
    	return Long.parseLong(next());
    }
     
    String nextLine() {
        String line = "";
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line ;
    }
}