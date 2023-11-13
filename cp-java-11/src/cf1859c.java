
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1859c
 * Date       = Fri Oct 20 21:16:21 PDT 2023
 */
public class cf1859c {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            Integer n = in.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            Integer ans = 0;
            for(Integer i = 1; i <= n; ++i){
                for(Integer j = i; j <= n; ++j){
                    set.clear();
                    Integer m = i*j;
                    Integer sum = 0;
                    for(Integer k = n; k >= 1; --k){
                        set.add(k);
                    }
                    for(int k = n; k >= 1; --k){
                        Integer x = set.floor(m/k);
                        if (x == null){
                            break;
                        }
                        set.remove(x);
                        sum += k*x;
                    }
                    if (set.isEmpty()){
                        ans=Math.max(ans,sum-m);
                    }
                }
            }
            out.println(ans);
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
    cf1859c t=new cf1859c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
