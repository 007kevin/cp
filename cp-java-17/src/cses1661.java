
import java.io.*;
import java.util.*;

/**
 * Problem    = cses1661
 * Date       = Tue Sep 17 20:42:06 PDT 2024
 */
public class cses1661 {

  public void run() {
    int n = in.nextInt();
    long[] a = new long[n+1];
    int x = in.nextInt();
    for(int i = 1; i <= n; ++i){
      a[i]=in.nextLong()+a[i-1];
    }
    long ans = 0;
    var map = new HashMap<Long,Long>();
    map.put(0L,1L);
    for(int i = 1; i <= n; ++i){
      ans+=map.getOrDefault(a[i]-x, 0L);
      map.put(a[i], map.getOrDefault(a[i],0L)+1L);
    }
    out.println(ans);
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
  void main(String[]args){cses1661 t=new cses1661();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
