
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoMixMilk
 * Date       = Sun May  5 21:38:03 PDT 2024
 */
public class usacoMixMilk {

    public void run() {
        int[][] b = new int[][]{
            {in.nextInt(), in.nextInt()},
            {in.nextInt(), in.nextInt()},
            {in.nextInt(), in.nextInt()}};
        int c = 0;
        while(c<100){
            pour(b[c%3],b[(c+1)%3]);
            c++;
        }
        out.println(b[0][1]);
        out.println(b[1][1]);
        out.println(b[2][1]);
    }

    void pour(int[] a, int[] b) {
        int x = b[0] - b[1];
        if (x >= a[1]) {
            b[1]+=a[1];
            a[1]=0;
        } else {
            b[1]=b[0];
            a[1]-=x;
        }
    }

    static OutputStream out() {
        try {
            return new FileOutputStream("mixmilk.out");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    IR in=new IR(System.in);PrintWriter out=new PrintWriter(out());void c(){
    out.close();}static class IR {BufferedReader r; StringTokenizer t= null; IR (
    InputStream s){r=new BufferedReader(new InputStreamReader(s), 32768);}boolean
    p(){while(t==null||!t.hasMoreTokens()){try{String l=r. readLine();if(l==null)
    return false; t = new StringTokenizer(l); } catch (IOException e) { throw new
    RuntimeException(e);}}return true;}boolean hasNext(){return p();}String next(
    ){ p();return t.nextToken();}int nextInt() {return Integer.parseInt(next());}
    long nextLong() { return Long.parseLong(next());} double nextDouble(){ return
    Double.parseDouble( next() ); } } public static void main ( String[ ]args ) {
    usacoMixMilk t=new usacoMixMilk();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
