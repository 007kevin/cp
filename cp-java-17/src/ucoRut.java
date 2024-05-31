
import java.io.*;
import java.util.*;

/**
 * Problem    = ucoRut
 * Date       = Mon May 27 10:27:03 PDT 2024
 */
public class ucoRut {

  static class Cow {
    String dir;
    int x,y,dist=Integer.MAX_VALUE;
    Cow(String dir, int x, int y){
      this.dir=dir;
      this.x=x;
      this.y=y;
    }
    @Override
    public String toString() {
      return dist == Integer.MAX_VALUE ?
          "Infinity" :
          String.valueOf(dist);
    }
    public boolean faces(String dir){
      return this.dir.equals(dir);
    }
  }

  public void run() {
    int n = in.nextInt();
    Cow[] cows = new Cow[n];
    Map<Cow, Set<Cow>> b = new HashMap<>();
    for(int i = 0; i < n; ++i)
      cows[i] = new Cow(
          in.next(),
          in.nextInt(),
          in.nextInt());
    for(int i = 0; i < n; ++i){
      Cow c = null;
      int d = Integer.MAX_VALUE;
      for(int j = 0; j < n; ++j){
        if (i!=j){
          int s = stoppingDistance(cows[i], cows[j]);
          if (s < d){
            c = cows[j];
            d = s;
          }
        }
      }
      if (c != null){
        b.computeIfAbsent(c, k -> new HashSet<>()).add(cows[i]);
      }
    }
    for(int i = 0; i < n; ++i){
      Cow c = null;
      int d = Integer.MAX_VALUE;
      for(int j = 0; j < n; ++j){
        if (i!=j){
          int s = stoppingDistance(cows[i], cows[j]);
          if (s < d && b.containsKey(cows[j]) && b.get(cows[j]).contains(cows[i])){
            c = cows[j];
            d = s;
          }
        }
      }
      if (c == null){
        out.println("Infinity");
      } else {
        out.println(d);
      }
    }
    for(Cow c : b.get(cows[3]))
      out.println(c.x + " " + c.y);
  }


  /**
   * The amount of grass cow a eats before colliding with cow b (if any)
   */
  int stoppingDistance(Cow a, Cow b) {
    if (a.faces("N") && b.faces("N")){
      if (a.x == b.x){
        if (a.y <= b.y)
          return b.y-a.y;
      }
    }
    if (a.faces("E") && b.faces("E")){
      if (a.y == b.y){
        if (a.x <= b.x)
          return b.x-a.x;
      }
    }
    if (a.faces("N") && b.faces("E")) {
      if (a.x >= b.x) {
        if(a.y <= b.y){
          int ab = b.y - a.y;
          int ba = a.x - b.x;
          if (ab > ba){
            return ab;
          }
        }
      }
    }
    if (a.faces("E") && b.faces("N")) {
      if (a.x <= b.x) {
        if(a.y >= b.y){
          int ab = b.x - a.x;
          int ba = a.y - b.y;
          if (ab > ba){
            return ab;
          }
        }
      }
    }
    return Integer.MAX_VALUE;
  }

  void compareAndSet(Cow a, Cow b){
    if (a.faces("N") && b.faces("N")){
      if (a.x == b.x){
        if (a.y > b.y)
          b.dist = Math.min(b.dist, a.y-b.y);
        else
          a.dist = Math.min(b.dist, b.y-a.y);
      }
      return;
    }
    if (a.faces("E") && b.faces("E")){
      if (a.y == b.y){
        if (a.x > b.x)
          b.dist = Math.min(b.dist, a.x-b.x);
        else
          a.dist = Math.min(b.dist, b.x-a.x);
      }
      return;
    }
    if (a.faces("E")){
      Cow tmp = a;
      a = b;
      b = tmp;
    }
    if (!(a.faces("N") && b.faces("E"))){
      throw new RuntimeException("Should not happen");
    }
    if (a.x >= b.x)
      if(a.y <= b.y){
        int ab = b.y - a.y;
        int ba = a.x - b.x;
        if (ab > ba){
          a.dist = Math.min(a.dist, ab);
        }
        if (ab < ba){
          b.dist = Math.min(b.dist, ba);
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
  void main(String[]args){ucoRut t=new ucoRut();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
