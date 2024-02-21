
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1891c
 * Date       = Wed Nov 15 21:09:31 PST 2023
 */
public class cf1891c {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            long[] a = new long[n];
            for(int i = 0; i < n; ++i) a[i]=in.nextLong();
            Arrays.sort(a);
            int c = 0;
            int p = n-1;
            long x = 0;
            long m = 0;
            while(c<p){
                if(x+a[c] < a[p]){
                    m+=a[c];
                    x+=a[c];
                    c++;
                    continue;
                }
                if (x+a[c] >= a[p]){
                    m += a[p]-x;
                    m += 1;
                    a[c] -= a[p]-x;
                    x=0;
                    p--;
                }
            }
            if (a[c] > x + 1){
                long d = (a[c]-x)/2;
                a[c]-=d;
                x+=d;
                m+=d;

            }
            if (x > 0){
                a[c]-=x;
                m+=1;
            }
            m+=a[c];
            out.println(m);
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
    cf1891c t=new cf1891c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
