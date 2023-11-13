
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1857e
 * Date       = Fri Nov  3 21:27:16 PDT 2023
 */
public class cf1857e {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            long[] x = new long[n];
            long[] a = new long[n];
            long[] s = new long[n];
            for(int i = 0; i < n; ++i){
                x[i] = in.nextLong();
                a[i] = x[i];
            }
            Arrays.sort(a);
            for(int i = n-1; i > 0; --i)
                s[i-1] += s[i] + a[i];
            Map<Long, Long> map = new HashMap<>();
            long pre = 0;
            for(int i = 0; i < n; ++i){
                map.put(a[i], i*a[i] - pre + 1 + s[i] - (a[i]-1) * (n-i-1));
                pre += a[i]-1;
            }
            for(int i = 0; i < n; ++i){
                out.print(map.get(x[i]) + " ");
            }
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
    cf1857e t=new cf1857e();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
