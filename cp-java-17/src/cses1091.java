
import java.io.*;
import java.util.*;

/**
 * Problem    = cses1091
 * Date       = Wed Oct  9 16:35:40 PDT 2024
 */
public class cses1091 {

  public void run() {
    int n = in.nextInt();
    int m = in.nextInt();
    var map = new TreeMap<Integer,Integer>();
    for(int i = 0; i < n; ++i){
        int h = in.nextInt();
        map.put(h,map.getOrDefault(h, 0) + 1);
    }
    for(int i = 0; i < m; ++i){
      int c = in.nextInt();
      var e = map.floorEntry(c);
      if (e == null){
        out.println(-1);
        continue;
      }
      out.println(e.getKey());
      if (e.getValue() - 1 == 0){
        map.remove(e.getKey());
      } else {
        map.put(e.getKey(), e.getValue() - 1);
      }
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
  void main(String[]args){cses1091 t=new cses1091();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
