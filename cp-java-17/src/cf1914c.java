
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1914c
 * Date       = Thu Sep  5 21:18:26 PDT 2024
 */
public class cf1914c {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt();
      int k = in.nextInt();
      int[] a = new int[n]; for(int i = 0; i < n; ++i) a[i] = in.nextInt();
      int[] b = new int[n]; for(int i = 0; i < n; ++i) b[i] = in.nextInt();
      long maxXp = 0;
      long maxB = 0;
      long acc = 0;
      for(int i = 0; i < n && i < k; ++i){
        acc += a[i];
        maxB = Math.max(maxB, b[i]);
        long xp = acc;
        xp+=maxB * (k-i-1);
        maxXp = Math.max(maxXp, xp);
      }
      out.println(maxXp);
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
  void main(String[]args){cf1914c t=new cf1914c();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
