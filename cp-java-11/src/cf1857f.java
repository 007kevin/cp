
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1857f
 * Date       = Sat Oct 21 10:57:52 PDT 2023
 */
public class cf1857f {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            long[] a = new long[n];
            for(int i = 0; i < n; ++i) a[i] = in.nextLong();
            int q = in.nextInt();
            while(q-->0){
                long x = in.nextLong();
                long y = in.nextLong();
                long cnt = 0;
                Map<Long,Long> map = new HashMap<>();
                for (long num : a){
                    if (y%num!=0){
                        map.put(num, map.getOrDefault(num, 0l) + 1l);
                        continue;
                    }
                    if (x - num != y/num){
                        map.put(num, map.getOrDefault(num, 0l) + 1l);
                        continue;
                    }
                    cnt += map.getOrDefault(x-num, 0l);
                    map.put(num, map.getOrDefault(num, 0l) + 1l);
                }
                out.print(cnt + " ");
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
    cf1857f t=new cf1857f();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
