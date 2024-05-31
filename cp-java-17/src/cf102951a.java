
import java.io.*;
import java.util.*;

/**
 * Problem    = cf102951a
 * Date       = Tue May 28 23:28:56 PDT 2024
 */
public class cf102951a {

  public void run() {
    int n = in.nextInt();
    int[] x = new int[n]; for(int i = 0; i < n; ++i) x[i] = in.nextInt();
    int[] y = new int[n]; for(int i = 0; i < n; ++i) y[i] = in.nextInt();
    long max = 0;
    for(int i = 0; i < n; ++i){
      for(int j = i+1; j < n; ++j){
        long a = x[i]-x[j];
        long b = y[i]-y[j];
        max = Math.max(max, a*a + b*b);
      }
    }
    out.println(max);
  }

  /////////////////////////////////////////////////////////////////////////////////
  static InputStream in(){try{if(file!=null)return new FileInputStream(file+".in");
  return System.in;}catch(Exception e){throw new RuntimeException(e);}}static
  OutputStream out(){try{if(file!=null)return new FileOutputStream(file+".out");
  return System.out;}catch(Exception e){throw new RuntimeException(e);}}IR in=new
  IR(in());PrintWriter out=new PrintWriter(out());void c(){out.close();}static
  class IR{BufferedReader r;StringTokenizer t=null;IR(InputStream s){r=new
  BufferedReader(new InputStreamReader(s),32768);}boolean p(){while(t==null||
  !t.hasMoreTokens()){try{String l=r.readLine();if(l==null)return false;t=new
  StringTokenizer(l);}catch(IOException e){throw new RuntimeException(e);}}return
  true;}boolean hasNext(){return p();}String next(){p();return t.nextToken();}int
  nextInt(){return Integer.parseInt(next());}long nextLong(){return Long.parseLong(
  next());}double nextDouble(){return Double.parseDouble(next());}}public static
  void main(String[]args){cf102951a t=new cf102951a();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
