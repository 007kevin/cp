
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1883d
 * Date       = Tue Nov 21 21:07:46 PST 2023
 */
public class cf1883d {

    static final TreeMap<Integer,Integer> minRight = new TreeMap<>();
    static final TreeMap<Integer,Integer> maxLeft = new TreeMap<>();

    public void run() {
        int q = in.nextInt();
        while(q-->0){
            String op = in.next();
            Integer l = in.nextInt();
            Integer r = in.nextInt();
            if ("+".equals(op)){
                minRight.put(r, minRight.getOrDefault(r, 0) + 1);
                maxLeft.put(l, maxLeft.getOrDefault(l, 0) + 1);
            } else {
                Integer rv = minRight.get(r);
                Integer lv = maxLeft.get(l);
                if (rv == 1) minRight.remove(r);
                else minRight.put(r, rv -1);
                if (lv == 1) maxLeft.remove(l);
                else maxLeft.put(l, lv -1);
            }
            if (maxLeft.isEmpty() || minRight.isEmpty() || minRight.firstKey() >= maxLeft.lastKey())
                out.println("NO");
            else
                out.println("YES");
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
    cf1883d t=new cf1883d();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
