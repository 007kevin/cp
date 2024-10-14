
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1478c
 * Date       = Tue Oct  1 00:27:22 PDT 2024
 */
public class cf1478c {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt()*2;
      var a = new ArrayList<Long>(n);
      for(int i = 0; i < n; ++i) a.add(in.nextLong());
      if (!check(a)){
        out.println("NO");
      } else {
        out.println("YES");
      }
    }
  }

  boolean check(List<Long> a){
    int n = a.size();
    var map = new HashMap<Long,Long>();
    for(Long v : a){
      if (v==0 || v%2 != 0)
        return false;
      map.put(v, map.getOrDefault(v,0L)+1L);
    }
    for(var e : map.entrySet())
      if(e.getValue() != 2)
        return false;

    Collections.sort(a);
//    out.println(a);

    if (a.get(n-1)%n != 0)
      return false;
    long start = a.get(n-1)/n;
    for(int i = n-3; i >= 0; i -= 2){
      long gap = a.get(i+1)-a.get(i);
      long step = i+1;
      if (gap%step != 0) return false;
      long calc = gap/step;
      start-=calc;
    }
    return start > 0;
  }


  public void run2() {
    int n = in.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; ++i)
      a[i]=in.nextInt();
    for(int i = 0; i < n; ++i)
      out.print(d(i,a) + " ");
    out.println();
  }

  int d(int i, int[] a){
    int r = 0;
    for(int x : a){
      r +=Math.abs(a[i] - x);
    }
    return r;
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
  void main(String[]args){cf1478c t=new cf1478c();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
