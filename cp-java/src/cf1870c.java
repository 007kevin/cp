
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1870c
 * Date       = Sun Oct  8 22:12:08 PDT 2023
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf1870c {

    class Color implements Comparable<Color> {
        int value, index, min, max;
        Color(int value, int index){
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Color that) {
            if (this.value != that.value){
                return Integer.compare(this.value, that.value);
            } else
                return Integer.compare(this.index, that.index);
        }
    }

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int k = in.nextInt();
            Color[] a = new Color[n];
            for(int i =0; i < n; ++i) a[i] = new Color(in.nextInt(), i);
            Arrays.sort(a);
            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int i = n-1; i >= 0; --i){
                min = Math.min(min, a[i].index);
                max = Math.max(max, a[i].index);
                a[i].min=min;
                a[i].max=max;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (Color c : a) {
                map.computeIfAbsent(c.value, x -> (c.max+1-c.min)*2);
            }
            for(int i = 1; i <= k; ++i){
                if (!map.containsKey(i))
                    out.print("0 ");
                else
                    out.print(map.get(i) + " ");
            }
            out.println();
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
    cf1870c t=new cf1870c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
