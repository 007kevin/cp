
import java.io.*;
import java.util.*;

import javax.management.RuntimeErrorException;

/**
 * Problem    = usacopairup
 * Date       = Sun Oct  6 14:13:51 PDT 2024
 */
public class usacopairup {

  static class Iterator {
    int[] x;
    int[] y;
    List<Integer> sort;
    int c1 = 0;
    int c2 = 0;
    Iterator(int[] x, int[] y, List<Integer> sort){
      this.x=x;
      this.y=y;
      this.sort=sort;
    }

    int getMilk() {
      return y[sort.get(c1)];
    }

    boolean equals(Iterator that){
      return this.c1 == that.c1 && this.c2 == that.c2;
    }

    boolean lt(Iterator that){
      if (this.c1 < that.c1)
        return true;
      if (this.c1 == that.c1)
        return this.c2 < that.c2;
      return false;
    }

    public String toString() {
      return String.format("{c1:%d, c2:%d}", c1, c2);
    }

  }

  static class Forward extends Iterator {
    Forward(int[] x, int[] y, List<Integer> sort){
      super(x,y,sort);
      c1 = 0;
      c2 = 0;
    }

    void next() {
      if (c2 == x[sort.get(c1)] - 1){
        c2 = 0;
        c1++;
      } else{
        c2++;
      }
    }
  }

  static class Reverse extends Iterator {
    Reverse(int[] x, int[] y, List<Integer> sort){
      super(x,y,sort);
      c1 = sort.size()-1;
      c2 = x[sort.get(c1)];
    }

    void next() {
      if (c2 == 1){
        c1--;
        c2 = x[sort.get(c1)];
      } else {
        c2--;
      }
    }
  }


  public void run() {
    int n = in.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    var sort = new ArrayList<Integer>(n);
    for(int i = 0; i < n; ++i){
      x[i]=in.nextInt();
      y[i]=in.nextInt();
      sort.add(i);
    }
    Collections.sort(sort, Comparator.comparingInt(v -> y[v]));
    var forward = new Forward(x, y, sort);
    var reverse = new Reverse(x, y, sort);
    int time = 0;
    while(forward.lt(reverse)){
//      out.println(forward + " " + reverse + " " + (forward.getMilk() + reverse.getMilk()));
      time = Math.max(time, forward.getMilk() + reverse.getMilk());
      forward.next();
      reverse.next();
    }
    out.println(time);
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
  void main(String[]args){usacopairup t=new usacopairup();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "pairup";
}
