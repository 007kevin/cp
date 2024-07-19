
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoTriangles
 * Date       = Fri Jun  7 18:28:39 PDT 2024
 */
public class usacoTriangles {

  public void run() {
    int n = in.nextInt();
    var xs = new HashMap<Integer,List<Integer>>();
    var ys = new HashMap<Integer,List<Integer>>();
    int[][] ps = new int[n][2];
    for(int i = 0; i < n; ++i){
      ps[i][0] = in.nextInt();
      ps[i][1] = in.nextInt();
      xs.computeIfAbsent(ps[i][0], k -> new LinkedList<>()).add(ps[i][1]);
      ys.computeIfAbsent(ps[i][1], k -> new LinkedList<>()).add(ps[i][0]);
    }
    int m = 0;
    for(int[] p : ps){
      for(int y : xs.get(p[0])){
        for(int x : ys.get(p[1])){
          int a = Math.abs(p[0]-x);
          int b = Math.abs(p[1]-y);
          m = Math.max(m, a*b);
      }
      }
    }
    out.println(m);
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
  void main(String[]args){usacoTriangles t=new usacoTriangles();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "triangles";
}
