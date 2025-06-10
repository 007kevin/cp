
import java.io.*;
import java.util.*;

/**
 * Problem    = usacohelpcross
 * Date       = Tue Oct 22 22:30:09 PDT 2024
 */
public class usacohelpcross {

  static class Interval {
    int a;
    int b;
    Interval(int a, int b){
      this.a=a;
      this.b=b;
    }
    @Override
    public String toString() {
      return "Interval [a=" + a + ", b=" + b + "]";
    }
  }

  public void run() {
    int C = in.nextInt();
    int N = in.nextInt();
    var map = new TreeMap<Integer, Integer>();
    for(int i= 0; i < C; ++i){
      int c = in.nextInt();
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    var list = new ArrayList<Interval>();
    for(int i = 0; i < N; ++i)
      list.add(new Interval(in.nextInt(),in.nextInt()));
    Collections.sort(list, Comparator.comparingInt(i -> i.b));
    int match = 0;
    for(var interval : list){
      var e = map.ceilingEntry(interval.a);
//      out.print(interval);
      if (e != null && e.getKey() <= interval.b){
        if (e.getValue() == 1) map.remove(e.getKey());
        else map.put(e.getKey(), e.getValue() - 1);
        match++;
//        out.println(" matched with " + e.getKey());
      } else {
//        out.println(" did not match");
      }
    }
    out.println(match);
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
  void main(String[]args){usacohelpcross t=new usacohelpcross();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "helpcross";
}
