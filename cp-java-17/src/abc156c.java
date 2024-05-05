
import java.io.*;
import java.util.*;

/**
 * Problem    = abc156c
 * Date       = Sat May  4 21:01:59 PDT 2024
 */
public class abc156c {

    public void run() {
        int n = in.nextInt();
        int[] x = new int[n];
        int[] l = new int[101];
        for(int i = 0; i < n; ++i) x[i]=in.nextInt();
        for(int i = 0; i < n; ++i){
            for(int j = 1; j <= 100; ++j){
                l[j]+=(x[i]-j)*(x[i]-j);
            }
        }
        int m = Integer.MAX_VALUE;
        for(int i = 1; i <= 100; ++i)
            m=Math.min(m,l[i]);
        out.println(m);
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
    abc156c t=new abc156c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
