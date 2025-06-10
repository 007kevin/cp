import java.io.*;
import java.util.*;

/**
 * Problem    = cf2114e
 * Date       = Mon May 26 09:22:34 PDT 2025
 */
public class cf2114e {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            solve();
        }
    }
    
    int n;
    int[] d;
    int[] t;
    Map<Integer, Set<Integer>> tree;
    
    void solve() {
        n = in.nextInt();
        d = new int[n];
        t = new int[n];
        for(int i = 0; i < n; ++i) {
            d[i] = in.nextInt();
            t[i] = Integer.MIN_VALUE;
        };
        tree = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < n - 1; ++i){
            int u = in.nextInt();
            int v = in.nextInt();
            tree.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            tree.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }
        dfs(1, -1);
        for(int i = 0; i < n; ++i)
            out.print(t[i] + " ");
        out.println();
    }
    
    int dfs(int v, int p) {
        for(var u : tree.get(v)){
            if (u == v)
                continue;
            t[v] = Math.max(t[v], dfs(u,v));
        }
        return t[v];
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
    cf2114e t=new cf2114e();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
