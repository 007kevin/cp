
import java.io.*;
import java.util.*;

/**
 * Problem    = cf2052a
 * Date       = Mon Jan 27 23:11:17 PST 2025
 */
public class cf2052a {

  static class Pair {
    int x,y;
    Pair(int x, int y){
      this.x=x;this.y=y;
    }
  }

  public void run() {
    int n = in.nextInt();
    int[] p = new int[n+1];
    for(int i = 1; i <= n; ++i){
      p[i]=in.nextInt();
    }
    Set<Integer> s = new HashSet<>();
    
    var pairs = new LinkedList<Pair>();
    for(int i = 1; i <= n; ++i){
      for(int j = p[i]+1; j <= n; ++j){
        if (!s.contains(j)){
          pairs.add(new Pair(j,p[i]));
        }
      }
      for(int j = n; j > 0; j--){
        if (p[i]==j) continue;
        if (!s.contains(j)){
          pairs.add(new Pair(p[i],j));
        }
      }
      s.add(p[i]);
    }
    out.println(pairs.size());
    for(var pair : pairs)
      out.println(pair.x + " " + pair.y);
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
  void main(String[]args){cf2052a t=new cf2052a();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
