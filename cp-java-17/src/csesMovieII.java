
import java.io.*;
import java.util.*;

/**
 * Problem    = csesMovieII
 * Date       = Fri Oct 18 21:38:26 PDT 2024
 */
public class csesMovieII {

  static class Movie {
    int a;
    int b;
    public Movie(int a, int b){
      this.a=a;
      this.b=b;
    }
    @Override
    public String toString() {
      return "{a=" + a + ", b=" + b + "}";
    }
  }

  public void run() {
    int n = in.nextInt();
    int k = in.nextInt();
    var list = new ArrayList<Movie>(n);
    for(int i = 0; i < n; ++i)
      list.add(new Movie(in.nextInt(),in.nextInt()));
    Collections.sort(list, Comparator.comparingInt(m -> m.b));
    var map = new TreeMap<Integer,Integer>();
    map.put(0,k);
    int cnt = 0;
    for(var m : list){
      var e = map.floorEntry(m.a);
      if (e != null){
        if (e.getValue() == 1)
          map.remove(e.getKey());
        else
          map.put(e.getKey(), e.getValue() - 1);
        map.put(m.b, map.getOrDefault(m.b, 0) + 1);
        cnt++;
      }
//      out.println(map);
    }
    out.println(cnt);
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
  void main(String[]args){csesMovieII t=new csesMovieII();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
