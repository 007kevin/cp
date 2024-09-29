
import java.io.*;
import java.util.*;

/**
 * Problem    = cses1662
 * Date       = Wed Sep 18 12:11:42 PDT 2024
 */
public class cses1662 {

  public void run() {
    int n = in.nextInt();
    int a[] = new int[n+1];
    for(int i = 1; i <= n; ++i){
      a[i]=((in.nextInt()%n) + a[i-1])%n;
    }
    var map = new HashMap<Integer,Long>();
    long ans = 0;
    map.put(0,1L);
    for(int i = 1; i <= n; ++i){
      if (a[i] == 0){
        ans+=map.get(0);
      }
      if (a[i] > 0){
        ans+=map.getOrDefault(a[i], 0L);
        ans+=map.getOrDefault(-1*(n-a[i]),0L);
      }
      if (a[i] < 0){
        ans+=map.getOrDefault(a[i], 0L);
        ans+=map.getOrDefault(n - (-1*(a[i])), 0L);
      }
      map.put(a[i], map.getOrDefault(a[i],0L) +1L);
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
  void main(String[]args){cses1662 t=new cses1662();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
