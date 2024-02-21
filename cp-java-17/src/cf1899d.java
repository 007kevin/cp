
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1899d
 * Date       = Sun Nov 26 20:59:29 PST 2023
 */
public class cf1899d {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] a = new int[n];
            long s = 0;
            for(int i = 0; i < n; ++i) a[i]=in.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; ++i){
                int b = a[i];
                int step = 0;
                while(b%2==0){
                    if(a[i]-step == b)
                        s += map.getOrDefault(b, 0);
                    b/=2;
                    step++;
                }
                if(a[i]-step == b)
                    s += map.getOrDefault(b, 0);
                b = a[i]*2;
                step = 1;
                while(b<=1000000000){
                    if (a[i] + step == b)
                        s += map.getOrDefault(b, 0);
                    b*=2;
                    step++;
                }
                map.compute(a[i], (k,v) -> v == null ? 1 : v + 1);
            }
            // for(var e : map.entrySet()){
            //     out.printf("(%d,%d)\n", e.getKey(), e.getValue());
            // }
            out.println(s);
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
    cf1899d t=new cf1899d();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
