
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoShellGame
 * Date       = Sun May  5 00:09:57 PDT 2024
 */
public class usacoShellGame {

    public void run() {
        int n = in.nextInt();
        int[] p = new int[4];
        while(n-->0){
            int a = in.nextInt();
            int b = in.nextInt();
            int g = in.nextInt();
            swap(p,a,b);
            p[g]++;
        }
        out.println(Math.max(p[1], Math.max(p[2],p[3])));
    }

    public void swap(int[] p, int a, int b){
        int t = p[a];
        p[a] = p[b];
        p[b] = t;
    }

    static InputStream in() {
        try {
            return new FileInputStream("shell.in");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static OutputStream out() {
        try {
            return new FileOutputStream("shell.out");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    IR in=new IR(in());PrintWriter out=new PrintWriter(out());void c(){
    out.close();}static class IR {BufferedReader r; StringTokenizer t= null; IR (
    InputStream s){r=new BufferedReader(new InputStreamReader(s), 32768);}boolean
    p(){while(t==null||!t.hasMoreTokens()){try{String l=r. readLine();if(l==null)
    return false; t = new StringTokenizer(l); } catch (IOException e) { throw new
    RuntimeException(e);}}return true;}boolean hasNext(){return p();}String next(
    ){ p();return t.nextToken();}int nextInt() {return Integer.parseInt(next());}
    long nextLong() { return Long.parseLong(next());} double nextDouble(){ return
    Double.parseDouble( next() ); } } public static void main ( String[ ]args ) {
    usacoShellGame t=new usacoShellGame();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
