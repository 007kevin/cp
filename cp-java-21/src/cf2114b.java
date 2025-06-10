import java.io.*;
import java.util.*;

/**
 * Problem    = cf2114b
 * Date       = Mon May 26 07:48:29 PDT 2025
 */
public class cf2114b {

    public void run() {
        int t = in.nextInt();
        while(t-->0) solve();
    }
    
    void solve() {
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        int ones = 0;
        int zeros = 0;
        for(int i = 0; i < n; ++i){
            if (s.charAt(i) == '0') zeros++;
            else ones++;
        }
        int l = n-(2*k);
        while(ones > 0 && zeros > 0 && l > 0){
            ones--;
            zeros--;
            l-=2;
        }
        while(ones > 0 && k > 0){
            ones-=2;
            k--;
        }
        while(zeros > 0 && k > 0){
            zeros-=2;
            k--;
        }
        out.println((k == 0 && ones == 0 && zeros == 0) ? "YES" : "NO");
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
    cf2114b t=new cf2114b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
