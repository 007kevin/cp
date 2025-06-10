import java.io.*;
import java.util.*;

/**
 * Problem    = cf2106d
 * Date       = Sat May 31 11:33:33 PDT 2025
 */
public class cf2106d {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            solve();
        }
    }
    
    public void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0; i < n; ++i) a[i]=in.nextInt();
        for(int i = 0; i < m; ++i) b[i]=in.nextInt();
        if (m == 1) {
            for(int i = 0; i < n; ++i)
                if (b[0] <= a[i]){
                    out.println(0);
                    return;
                }
            out.println(b[0]);
            return;
        }

        int[] p = new int[m];
        int[] s = new int[m];
        for(int i = 0; i < m; ++i){
            p[i]=-1;
            s[i]=-1;
        }
        int j = 0;
        for(int i = 0; i < n; ++i){
            if (j < m && b[j] <= a[i]){
                p[j] = i;
                j++;
            }
        }
        j = m-1;
        for(int i = n-1; i >= 0; --i){
            if (j >= 0 && b[j] <= a[i]){
                s[j] = i;
                j--;
            }
        }
        // print(p);
        // print(s);        
        for(int i = 0; i < m; ++i){
            if (p[i] != -1 && s[i] != -1 && p[i] <= s[i]){
                out.println(0);
                return;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < m; ++i){
            if (i == 0){
                if (s[i+1] != -1 && s[i+1] >= 0){
                    ans = Math.min(ans, b[i]);
                }
            }
            else if (i == m-1) {
                if (p[m-2] != -1 && p[m-2] <= n) {
                    ans = Math.min(ans, b[i]);
                }
            } else {
                if (p[i-1] != -1 && s[i+1] != -1 && p[i-1] < s[i+1]) {
                    ans = Math.min(ans, b[i]);
                }
            }
        }
        if (ans == Integer.MAX_VALUE)
            out.println(-1);
        else 
            out.println(ans);
    }
    
    void print(int[] a){
        for(int i = 0; i < a.length; ++i)
            out.print(a[i] + " ");
        out.println();
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
    cf2106d t=new cf2106d();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
