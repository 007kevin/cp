
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoSpeeding
 * Date       = Sun May  5 22:28:17 PDT 2024
 */
public class usacoSpeeding {

    public void run() {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] r = new int[101];
        int[] b = new int[101];
        int p = 0;
        for(int i = 0; i < n; ++i){
            int l = in.nextInt();
            int s = in.nextInt();
            for(int j = 1; j <= l; ++j)
                r[p+j]=s;
            p+=l;
        }
        p = 0;
        for(int i = 0; i < m; ++i){
            int l = in.nextInt();
            int s = in.nextInt();
            for(int j = 1; j <= l; ++j)
                b[p+j]=s;
            p+=l;
        }
        int a = 0;
        for(int i = 1; i <= 100; ++i){
            a = Math.max(a, b[i]-r[i]);
        }
        out.println(a);
    }

    ////////////////////////////////////////////////////////////////////////////////
    static InputStream in(){try{if(file!=null)return new FileInputStream(file+".in");
    return System.in;} catch(Exception e) { throw new RuntimeException(e); } } static
    OutputStream out(){ try{ if (file!=null)return new FileOutputStream(file+".out");
    return System.out;} catch(Exception e){ throw new RuntimeException(e);}}IR in=new
    IR(System.in); PrintWriter out=new PrintWriter(System.out);void c(){out.close();}
    static class IR{BufferedReader r; StringTokenizer t=null; IR(InputStream s){r=new
    BufferedReader(new InputStreamReader(s), 32768); } boolean p() { while(t==null ||
    !t.hasMoreTokens()) { try{String l=r.readLine(); if (l==null) return false; t=new
    StringTokenizer(l); } catch(IOException e){throw new RuntimeException(e);}}return
    true; } boolean hasNext(){return p();}String next(){p();return t.nextToken();}int
    nextInt(){return Integer.parseInt(next());}long nextLong(){return Long.parseLong(
    next());} double nextDouble(){ return Double.parseDouble(next());}} public static
    void main(String[]args){usacoSpeeding t=new usacoSpeeding();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////////
    static String file;
}
