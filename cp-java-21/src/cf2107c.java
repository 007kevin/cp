import java.io.*;
import java.util.*;

/**
 * Problem    = cf2107c
 * Date       = Mon Jun  2 05:13:42 JST 2025
 */
public class cf2107c {

    public void main() {
        int t = in.nextInt();
        while(t-->0) 
            run();
    }
    
    void run() {
        int n = in.nextInt();
        long k = in.nextLong();
        char[] b = in.next().toCharArray();
        long[] a = new long[n];
        for(int i = 0; i < n; ++i) 
            a[i] = in.nextLong();
        long[] s = new long[n+1];
        for(int i = n-1; i >= 0; --i)
            s[i] = Math.max(0, s[i+1] + a[i]);
        long p = 0;
        for(int i = 0; i < n; ++i){
            if (b[i] == '0')
                a[i] = k - p - s[i+1];
            p = Math.max(0, p + a[i]);
        }
        long max = 0;
        long sum = 0;
        for(int i = 0; i < n; ++i) {
            sum=Math.max(0, sum+a[i]);
            max=Math.max(max, sum);
        }
        if (max != k) {
            out.println("No");
            return;
        }
        out.println("Yes");
        for(int i = 0; i < n; ++i)
            out.print(a[i] + " ");
        out.println();
    }
    
    ///////////p //////////////////////////////////////////////////////////////////
    IR in=new IR(System.in);PrintWriter out=new PrintWriter(System.out);void c(){
    out.close();}static class IR {BufferedReader r; StringTokenizer t= null; IR (
    InputStream s){r=new BufferedReader(new InputStreamReader(s), 32768);}boolean
    p(){while(t==null||!t.hasMoreTokens()){try{String l=r. readLine();if(l==null)
    return false; t = new StringTokenizer(l); } catch (IOException e) { throw new
    RuntimeException(e);}}return true;}boolean hasNext(){return p();}String next(
    ){ p();return t.nextToken();}int nextInt() {return Integer.parseInt(next());}
    long nextLong() { return Long.parseLong(next());} double nextDouble(){ return
    Double.parseDouble( next() ); } } public static void main ( String[ ]args ) {
    cf2107c t=new cf2107c();t.main();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
