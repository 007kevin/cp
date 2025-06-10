import java.io.*;
import java.util.*;

/**
 * Problem    = cf2114d
 * Date       = Mon May 26 08:35:26 PDT 2025
 */
public class cf2114d {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            solve();
        }
    }
    
    void solve() {
        int n = in.nextInt();
        long[][] m = new long[n][2];
        var xs = new TreeMap<Long,Long>();
        var ys = new TreeMap<Long,Long>();
        long coins = Long.MAX_VALUE;
        for(int i = 0; i < n; ++i){
            m[i][0] = in.nextLong();
            m[i][1] = in.nextLong();
            add(xs, m[i][0]);
            add(ys, m[i][1]);
        }
        if (n == 1){
            out.println(1);
            return;
        }
        // out.println("xs: " + xs);
        // out.println("ys: " + ys);
        for(long[] mo : m){
            rem(xs, mo[0]);
            rem(ys, mo[1]);
            long minx = min(xs);
            long miny = min(ys);
            long maxx = max(xs);
            long maxy = max(ys);
            // out.println(maxy-miny+1);
            // out.println(maxx-minx+1);
            long area = (maxy-miny+1) * (maxx-minx+1);
            // out.println(String.format("[%s,%s] => minx:%s, miny%s, maxx:%s, maxy:%s => %s", mo[0], mo[1], minx,miny,maxx,maxy, area));
            if (area == n-1){
                long extra = Math.min((maxy-miny+1),(maxx-minx+1));
                coins = Math.min(coins, area + extra);
            } else {
                coins = Math.min(coins, area);
            }
            add(xs, mo[0]);
            add(ys, mo[1]);
        }
        out.println(coins);
    }
    
    long rem(TreeMap<Long,Long> tm, long k) {
        long v = tm.get(k);
        if (v == 1)
            tm.remove(k);
        else
            tm.put(k, v-1);
        return v;
    }
    
    void add(TreeMap<Long,Long> tm, long k) {
        if (tm.containsKey(k)){
            tm.put(k, tm.get(k) + 1);
        } else 
            tm.put(k, 1l);
    }
    
    long max(TreeMap<Long,Long> tm) {
        return tm.lastKey();
    }
    
    long min(TreeMap<Long,Long> tm) {
        return tm.firstKey();
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
    cf2114d t=new cf2114d();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
