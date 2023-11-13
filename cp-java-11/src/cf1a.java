
import java.io.*;
import java.util.*;

/**
 * Problem    = cp1a
 * Date       = Mon Oct  2 22:11:16 PDT 2023
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf1a {

    public void run() {
        double n = in.nextInt();
        double m = in.nextInt();
        double a = in.nextInt();
        out.println((long) (Math.ceil(n/a) * Math.ceil(m/a)));
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
    cf1a t=new cf1a();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
