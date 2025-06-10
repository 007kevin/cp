import java.io.*;
import java.util.*;

/**
 * Problem    = cf2104e
 * Date       = Sun May 25 01:02:08 PDT 2025
 */
public class cf2104e {

    public void run() {
        int n = in.nextInt();
        int k = in.nextInt();
        char[] s = in.next().toCharArray();
        int[][] next = new int[k][n];
        for(int i = 0; i < k; ++i)
            for(int j = 0; j < n; ++j)
                next[i][j]=-1;
        next[k(s[n-1])][n-1]=n-1;
        for(int j = n-2; j >= 0; --j){
            for(int i = 0; i < k; ++i)
                next[i][j] = next[i][j+1];
            next[k(s[j])][j] = j;
        }
        // for(int i = 0; i < k; ++i){
        //     for(int j = 0; j < n; ++j)
        //         out.print(dp[i][j] + " \t");
        //     out.println();
        // }
        int q = in.nextInt();
        while(q-->0){
            char[] t = in.next().toCharArray();
            int m = t.length;
            if (m >= n) {
                out.println(0);
                continue;
            }
            int[][] p = new int[k][2];
            for(int i = 0; i < k; ++i){
                p[i][0]=-1;
            }
                
            boolean e = false;
            for(int i = 0; i < m; ++i){
                int j = p[k(t[i])][0]+1;
                if (j == n) {
                    e = true;
                    break;
                }
                int nxt = next[k(t[i])][j];
                if (nxt == -1){
                    e = true;
                    break;
                }
                p[k(t[i])][0] = nxt;
            }
            if (e) {
                out.println(0);
                continue;
            }
            for(int i = 0; i < k; ++i){
                int j = p[i][0] + 1;
                if (j == n)
                    continue;
                int nxt = next[i][j];
                if (nxt == -1){
                    out.println(p[i][1] + 1);
                    e = true;
                    break;
                }
                p[i][0]=nxt;
                p[i][1]=p[i][1]+1;
            }
            if (e)
                continue;
            int a = Integer.MAX_VALUE;
            for(int i = 0; i < k; ++i)
                a = Math.min(a, p[i][1]);
            out.println(a);
        }
    }
    
    int k(char a){
        return a - 'a';
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
    cf2104e t=new cf2104e();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
