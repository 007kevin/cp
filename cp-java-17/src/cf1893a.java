
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1893a
 * Date       = Tue Nov 14 23:15:06 PST 2023
 */
public class cf1893a {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] b = new int[n];
            for(int i = 0; i < n; ++i) b[i] = in.nextInt();
            int l = n-1;
            int s = 0;
            while(s < Math.min(k, n)){
                if (b[l] > n) break;
                l = (((l - b[l]) % n ) + n) % n;
                s++;
            }
            if (s == Math.min(k, n))
                out.println("Yes");
            else
                out.println("No");
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
    cf1893a t=new cf1893a();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
