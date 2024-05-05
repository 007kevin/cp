
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1948c
 * Date       = Fri Apr 12 15:27:48 PDT 2024
 */
public class cf1948c {

    public void run() {
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            char[] a = in.next().toCharArray();
            char[] b = in.next().toCharArray();
            if (solve(n,a,b)){
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }

    public boolean solve(int n, char[] a, char[] b){
        // 1 - starting point
        // 2 - can be reached
        int[][] dp = new int[2][n];
        dp[0][0] = 1;
        for(int i = 0; i < n; ++i){
            if (dp[0][i] == 1) {
                moveAndSet(dp, 0, i+1, get(a, i+1));
                moveAndSet(dp, 1, i, get(b, i));
            }
            if (dp[1][i] == 1) {
                moveAndSet(dp, 0, i, get(a, i));
                moveAndSet(dp, 1, i+1, get(b, i+1));
            }
        }
        return dp[1][n-1] > 0;
    }

    public void moveAndSet(int[][] dp, int r, int c, char d){
        if (0 <= c && c < dp[r].length) {
            dp[r][c] = 2;
        }
        if (c != 0){
            if (d == '<') c--;
            if (d == '>') c++;
            if (0 <= c && c < dp[r].length) {
                dp[r][c] = 1;
            }
        }
    }

    public char get(char[] a, int i) {
        if (0 <= i && i < a.length) {
            return a[i];
        }
        return 0;
    }


    /////////////////////////////////////////////////////////////////////////////
    IR in=new IR(System.in);PrintWriter out=new PrintWriter(System.out);void c(){
    out.close();}static class IR {BufferedReader r; StringTokenizer t= null; IR (
    InputStream s){r=new BufferedReader(new InputStreamReader(s), 32768);}boolean
    p(){while(t==null||!t.hasMoreTokens()){try{String l=r. readLine();if(l==null)
    return false; t = new StringTokenizer(l); } catch (IOException e) { throw new
    RuntimeException(e);}}return true;}boolean hasNext(){return p();}String next(
    ){ p();return t.nextToken();}int nextInt() {return Integer.parseInt(next());}
    long nextLong() { return Long.parseLong(next());} double nextDouble(){ return
    Double.parseDouble( next() ); } } public static void main ( String[ ]args ) {
    cf1948c t=new cf1948c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
