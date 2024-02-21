
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1896c
 * Date       = Wed Nov 29 21:22:27 PST 2023
 */
public class cf1896c {

    static class Pair {
        int first;
        int second;
        int mapped = 0;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int x = in.nextInt();
            ArrayList<Pair> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            for(int i = 0; i < n; ++i) a.add(new Pair(in.nextInt(), i));
            for(int i = 0; i < n; ++i) b.add(in.nextInt());
            Collections.sort(a, (e1, e2) -> e1.first - e2.first);
            Collections.sort(b, (e1, e2) -> e1 - e2);
            for(int i = n-x; i < n; ++i) a.get(i).mapped = b.get(i-(n-x));
            for(int i = 0; i < n-x; ++i) a.get(i).mapped = b.get(i+x);
            Collections.sort(a, (e1, e2) -> e1.second - e2.second);
            int y = 0;
            for(Pair p : a)
                if (p.first > p.mapped)
                    y++;
            if (y == x){
                out.println("YES");
                for(Pair p : a)
                    out.print(p.mapped + " ");
                out.println();
            } else {
                out.println("NO");
            }
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
    cf1896c t=new cf1896c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
