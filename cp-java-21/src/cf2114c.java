import java.io.*;
import java.util.*;

/**
 * Problem    = cf2114c
 * Date       = Mon May 26 08:15:25 PDT 2025
 */
public class cf2114c {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int[] a = get();
            int n = a.length;
            int c = 0;
            for(int i = 1; i < n-1; ++i){
                if (a[i-1]+1 == a[i] && a[i] == a[i+1]-1){
                    a[i]=0;
                    c++;
                    i++;
                }
            }
            int[] m = new int[n-c];
            int j = 0;
            for(int i = 0; i < n; ++i){
                if (a[i]!=0)
                    m[j++] = a[i];
            }
            // for(int i = 0; i < m.length; ++i)
            //     out.println(m[i]);
            int ans = 1;
            for(int i = 0; i < m.length-1; ++i)
                if (m[i]+1!=m[i+1])
                    ans++;
            out.println(ans);
        }
    }
    
    int[] get() {
        int n = in.nextInt();
        var l = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            int a = in.nextInt();
            while(l.isEmpty() || l.get(l.size()-1) != a)
                l.add(a);
        }
        int[] m = new int[l.size()];
        for(int i = 0; i < l.size(); ++i){
            m[i]=l.get(i);
        }
        return m;
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
    cf2114c t=new cf2114c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
