
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1886c
 * Date       = Sat Nov 18 13:40:16 PST 2023
 */
public class cf1886c {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            String s = in.next();
            long p = in.nextLong();

            int i = findi(s.length(), p);
            long len = length(s.length(), i);
            String g = generate(s, i);
            out.print(g.charAt((int)(p-len-1)));
        }
    }

    public int findi(int n, long p){
        int a = 0;
        int b = n;
        int i = -1;
        while (a<=b){
            int m = (a+b)/2;
            long len = length(n,m);
            if (len < p){
                i = m;
                a = m+1;
            } else {
                b = m-1;
            }
        }
        return i;
    }

    public long length(long n, long i){
        long m = n-i+1;
        return (n*(n+1))/2 - (m*(m+1))/2;
    }

    public String generate(String s, int i){
        StringBuilder g = new StringBuilder();
        boolean[] marked = new boolean[s.length()];
        for(int j = 0; j < s.length(); j++){
            if (j < s.length() - 1 && s.charAt(j) > s.charAt(j+1) && i > 1){
                int k = j;
                while(i > 1 && k>=0 && s.charAt(k) > s.charAt(j+1)){
                    if (!marked[k]){
                        marked[k] = true;
                        i--;
                    }
                    k--;
                }
            }
        }
        while(i > 1){
            marked[s.length()-i+1] = true;
            i--;
        }
        for(int j = 0; j < s.length(); j++){
            if (!marked[j])
                g.append(s.charAt(j));
        }
        return g.toString();
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
    cf1886c t=new cf1886c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
