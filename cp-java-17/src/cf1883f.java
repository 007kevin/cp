
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1883f
 * Date       = Tue Nov 21 21:01:36 PST 2023
 */
public class cf1883f {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i = 0; i < n; ++i) a[i]=in.nextInt();
            Set<Integer> set = new HashSet<>();
            for(int i = n-1; i >= 0; --i)
                if (!set.contains(a[i])){
                    set.add(a[i]);
                    b[i]=1;
                }
            for(int i = n-2; i >= 0; --i) b[i]+=b[i+1];
            set.clear();
            long s = 0l;
            for(int i = 0; i < n; ++i)
                if (!set.contains(a[i])){
                    set.add(a[i]);
                    s += b[i];
                }
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
    cf1883f t=new cf1883f();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
