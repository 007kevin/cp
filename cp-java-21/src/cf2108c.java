import java.io.*;
import java.util.*;

/**
 * Problem    = cf2108c
 * Date       = Fri May 23 22:46:18 PDT 2025
 */
public class cf2108c {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            solve();
        }
    }
    
    void solve() {
        int[] b = normalized();
        int n = b.length;
        boolean[] p = new boolean[n];
        List<Integer> l = new ArrayList<>(n);
        int c = 0;
        for(int i = 0; i < n; ++i){
            l.add(i);
        }
        Collections.sort(l, (i,j) -> {
                if (b[i] == b[j])
                    return i - j;
                return b[j]-b[i];
            });
        for(int i = 0; i < n; ++i){
            int j = l.get(i);
            if (clone(p,j)) 
                c++;
            p[j]=true;
        }
        out.println(c);
    }
    
    boolean clone(boolean[] p, int j){
        int n = p.length;
        if (n == 1)
            return true;
        if (j == 0)
            return !p[j+1];
        if (j == n-1)
            return !p[j-1];
        return !(p[j+1] || p[j-1]);
    }
    
    int[] normalized() {
        int n = in.nextInt();
        var list = new ArrayList<Integer>(n);
        for(int i = 0; i < n; ++i){
            int b = in.nextInt();
            if (list.isEmpty() || list.get(list.size() - 1) != b)
                list.add(b);
        }
        int[] b = new int[list.size()];
        for(int i = 0; i < list.size(); ++i)
            b[i] = list.get(i);
        return b;
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
    cf2108c t=new cf2108c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
