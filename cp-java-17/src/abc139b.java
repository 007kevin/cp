
import java.io.*;
import java.util.*;

/**
 * Problem    = abc139b
 * Date       = Sat May  4 20:49:45 PDT 2024
 */
public class abc139b {

    public void run() {
        double a = in.nextDouble();
        double b = in.nextDouble();
        out.println((int)Math.ceil((b-1)/(a-1)));
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
    abc139b t=new abc139b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
