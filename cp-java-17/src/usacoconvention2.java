
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoconvention2
 * Date       = Mon Oct 14 09:59:09 PDT 2024
 */
public class usacoconvention2 {

  static class Cow {
    int s;
    int a;
    int t;

    public Cow(int s, int a, int t) {
      this.s = s;
      this.a = a;
      this.t = t;
    }

    public int total() {
      return this.a + this.t;
    }

    @Override
    public String toString() {
      return "{s=" + s + "}";
    }

  }

  public void run() {
    int n = in.nextInt();
    var list = new ArrayList<Cow>(n);
    var pq = new PriorityQueue<Cow>(Comparator.comparingInt(c -> c.s));
    var order = new ArrayList<Cow>(n);
    for(int i = 1; i <= n; ++i)
      list.add(new Cow(i,in.nextInt(), in.nextInt()));
    Collections.sort(list, Comparator.comparingInt(c -> c.a));
    var cow = list.get(0);
    int i = 1;
    while(cow != null){
      order.add(cow);
      while(i < n && cow.total() >= list.get(i).a){
        pq.add(list.get(i++));
      }
      if (pq.isEmpty()){
        if (i == n) cow = null;
        else cow = list.get(i++);
      } else {
        cow = pq.poll();
      }
    }
    int curr = 0;
    int maxTime = 0;
    for(i = 0; i < order.size(); ++i){
      cow = order.get(i);
      if (cow.a < curr){
        maxTime = Math.max(maxTime, curr - cow.a);
        curr = curr + cow.t;
      } else
        curr = cow.total();
      out.println(curr);
    }
    out.println(maxTime);
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
  void main(String[]args){usacoconvention2 t=new usacoconvention2();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "convention2";
}
