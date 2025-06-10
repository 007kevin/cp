
import java.io.*;
import java.util.*;

/**
 * Problem    = usacopairup
 * Date       = Tue Nov 26 22:09:52 PST 2024
 */
public class usacopairup {

  static class Pair {
    int x,y;
    Pair(int x, int y){
      this.x=x;
      this.y=y;
    }
  }

  public void run() {
    int N = in.nextInt();
    List<Pair> p = new ArrayList<>(N);
    for(int i = 0; i < N; ++i)
      p.add(new Pair(in.nextInt(), in.nextInt()));
    Collections.sort(p, Comparator.comparingInt(a -> a.y));
    int ans = 0;
    int i = 0;
    int j = N-1;
    while(i<j){
      var a = p.get(i);
      var b = p.get(j);
      int c = Math.min(a.x, b.x);
      ans=Math.max(ans,a.y+b.y);
      a.x-=c;
      b.x-=c;
      if (a.x == 0) i++;
      if (b.x == 0) j--;
    }
    if (i == j && p.get(i).x > 1)
      ans = Math.max(ans, p.get(i).y * 2);
    out.println(ans);
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
