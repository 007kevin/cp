import java.io.*;
import java.util.*;

/**
 * Problem    = cf2114a
 * Date       = Mon May 26 07:35:17 PDT 2025
 */
public class cf2114a {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            solve();
        }
    }
    
    void solve() {
        int s = Integer.valueOf(in.next());
        for(int i = 0; i*i <= s; ++i){
            if (i*i==s){
                out.println(i + " " + 0);
                return;
            }
        }
        out.println(-1);
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
    cf2114a t=new cf2114a();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
