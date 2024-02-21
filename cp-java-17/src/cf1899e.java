
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1899e
 * Date       = Thu Nov 23 22:54:16 PST 2023
 */
public class cf1899e {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] a = new int[n];
            int minElem = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
                if (a[i] < minElem){
                    minElem = a[i];
                    minIndex = i;
                }
            }
            if (!valid(a,minIndex)){
                out.println(-1);
            } else {
                int cnt = 0;
                for(int i = 0; i < minIndex; i++){
                    if (a[i] > a[minIndex])
                        cnt++;
                }
                out.println(cnt);
            }
        }
    }

    boolean valid(int[] a, int minIndex){
        int greatest = a[minIndex];
        for(int i = minIndex; i < a.length; ++i){
            if (a[i] < greatest)
                return false;
            greatest = Math.max(greatest, a[i]);
        }
        return true;
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
    cf1899e t=new cf1899e();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
