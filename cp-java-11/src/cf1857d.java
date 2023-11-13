
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1857d
 * Date       = Sat Nov  4 11:54:20 PDT 2023
 */
public class cf1857d {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            long max = Long.MIN_VALUE;
            long cnt = 0;
            for(int i = 0; i < n; ++i) a[i] = in.nextLong();
            for(int i = 0; i < n; ++i) b[i] = in.nextLong();
            for(int i = 0; i < n; ++i) max = Math.max(max, a[i]-b[i]);
            for(int i = 0; i < n; ++i) if (a[i]-b[i] == max) cnt++;
            out.println(cnt);
            for(int i = 0; i < n; ++i) if (a[i]-b[i] == max) out.print((i + 1) + " ");
            out.println();
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
    cf1857d t=new cf1857d();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
