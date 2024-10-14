
import java.io.*;
import java.util.*;

/**
 * Problem    = cses1163
 * Date       = Sun Oct 13 15:20:50 PDT 2024
 */
public class cses1163 {

  static class Pair implements Comparable<Pair> {
    int a;
    int b;
    Pair(int a, int b){
      this.a=a;
      this.b=b;
    }

    public int length() {
      return this.b - this.a;
    }

    @Override
    public int compareTo(Pair that){
      if (this.length() == that.length()){
        return this.hashCode() - that.hashCode();
      }
      return that.length() - this.length();
    }

    @Override
    public String toString() {
      return String.format("{%d, %d}", this.a, this.b);
    }
  }


  public void run() {
    int x =in.nextInt();
    int n = in.nextInt();
    var map = new TreeMap<Integer,Pair>();
    var pq = new PriorityQueue<Pair>();
    var pair = new Pair(0,x);
    map.put(0, pair);
    pq.add(pair);
    for(int i = 0; i < n; ++i){
      Integer l = in.nextInt();
      var e = map.floorEntry(l);
      pq.remove(e.getValue());
      map.remove(e.getKey());
      var pairLeft = new Pair(e.getValue().a, l);
      var pairRight = new Pair(l,e.getValue().b);
      pq.add(pairLeft);
      pq.add(pairRight);
      map.put(pairLeft.a, pairLeft);
      map.put(pairRight.a, pairRight);
      out.println(pq.peek().length());
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
  void main(String[]args){cses1163 t=new cses1163();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
