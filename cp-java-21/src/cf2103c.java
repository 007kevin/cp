import java.io.*;
import java.util.*;

/**
 * Problem    = cf2103c
 * Date       = Fri Jun  6 17:55:13 KST 2025
 */
public class cf2103c {

    public void main() {
        int t = in.nextInt();
        while(t-->0) run();
    }
    
    void run() {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
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
    cf2103c t=new cf2103c();t.main();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
