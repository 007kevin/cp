
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1886b
 * Date       = Mon Nov 20 18:49:01 PST 2023
 */
public class cf1886b {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int[] o = new int[]{0,0};
            int[] p = new int[]{in.nextInt(), in.nextInt()};
            int[] a = new int[]{in.nextInt(), in.nextInt()};
            int[] b = new int[]{in.nextInt(), in.nextInt()};
            double[] pd = find(dist(p,b), dist(p,a));
            double[] od = find(dist(o,b), dist(o,a));
            double md = pd[1] == od[1] ? Double.MIN_VALUE : dist(a,b)/2l;
            out.println(max(pd[0],od[0],md));
        }
    }

    double[] find(double a, double b){
        if (a < b)
            return new double[]{a, 0};
        return new double[]{b,1};
    }

    double dist(int[] a, int[] b){
        int x = a[0]-b[0];
        int y = a[1]-b[1];
        return Math.sqrt(x*x + y*y);
    }

    double max(double... a){
        double m = Double.MIN_VALUE;
        for(int i = 0; i < a.length; ++i)
            m=Math.max(m, a[i]);
        return m;
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
    cf1886b t=new cf1886b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
