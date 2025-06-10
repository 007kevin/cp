
import java.io.*;
import java.util.*;

/**
 * Problem    = csesRangeXor
 * Date       = Sun Nov  3 16:22:27 PST 2024
 */
public class csesRangeXor {

  public void run() {
    int n = in.nextInt();
    int q = in.nextInt();
    int[] x = new int[n+1];
    for(int i = 1; i <= n; ++i){
      x[i] = in.nextInt() ^ x[i-1];
    }
    while(q-->0){
      int a = in.nextInt();
      int b = in.nextInt();
      out.println(x[b]^x[a-1]);
    }
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
  void main(String[]args){csesRangeXor t=new csesRangeXor();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
