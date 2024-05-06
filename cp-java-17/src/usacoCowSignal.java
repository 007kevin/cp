
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoCowSignal
 * Date       = Sun May  5 22:06:21 PDT 2024
 */
public class usacoCowSignal {

    public void run() {
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        for(int i = 0; i < m; ++i){
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < s.length(); j++){
                for(int x = 0; x < k; ++x){
                    sb.append(s.charAt(j));
                }
            }
            for(int x = 0; x < k; ++x){
                out.println(sb);
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
    usacoCowSignal t=new usacoCowSignal();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
