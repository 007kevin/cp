
import java.io.*;
import java.util.*;

/**
 * Problem    = ucoLiars
 * Date       = Thu May 30 22:19:47 PDT 2024
 */
public class ucoLiars {

  final static int MAX = 1000000000;

  public void run() {
    int n = in.nextInt();
    var map = new TreeMap<Integer,Integer>();
    for(int i = 0; i < n; ++i){
      String d = in.next();
      int p = in.nextInt();
      if (d.equals("G")){
        map.put(p, map.getOrDefault(p, 0) + 1);
        map.put(MAX+1, map.getOrDefault(MAX+1, 0) - 1);
      }
      if (d.equals("L")){
        map.put(0, map.getOrDefault(0, 0) + 1);
        map.put(p+1, map.getOrDefault(p+1, 0) - 1);
      }
    }
    int m = 0;
    int t = 0;
    for(var v : map.values()){
      t+=v;
      m=Math.max(m,t);
    }
    out.println(n-m);
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
  void main(String[]args){ucoLiars t=new ucoLiars();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
