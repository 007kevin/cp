
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1898b
 * Date       = Tue Nov 28 21:22:24 PST 2023
 */
public class cf1898b {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; ++i) a[i] = in.nextInt();
            long op = 0;
            for(int i = n-1; i > 0; --i){
                int k = (a[i] + a[i-1]-1)/a[i];
                a[i-1] = a[i-1]/k;
                op+=k-1;
            }
            out.println(op);
        }
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
    cf1898b t=new cf1898b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
