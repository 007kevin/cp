import java.io.*;
import java.util.*;

/**
 * Problem    = cf2063c
 * Date       = Sun Feb  2 10:51:51 PST 2025
 */
public class cf2063c {

  public void run() {
    int t = in.nextInt();
    while(t-->0)
      solve();
  }

  void solve() {
    int n = in.nextInt();
    var g = new HashMap<Integer, Set<Integer>>();
    var l = new ArrayList<Integer>(n+1);
    for(int i = 0; i <= n; ++i) l.add(i);
    g.put(0, Collections.emptySet());
    for(int i = 0; i < n-1; ++i){
      Integer u = in.nextInt();
      Integer v = in.nextInt();
      g.computeIfAbsent(u, k -> new HashSet<>()).add(v);
      g.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }
    Collections.sort(l, (u,v) -> g.get(v).size() - g.get(u).size());
    //out.println(l.stream().map(u -> g.get(u).size()).toList());
    int ans = 0;
    for(int i = 0; i < 3; ++i){
      int u = l.get(i);
      for(int j = 1; j <= n; ++j){
        if (i==j) continue;
        int v = l.get(j);
        int com = g.get(u).size() + g.get(v).size() - 1 - (g.get(u).contains(v) ?  1 : 0);
        ans = Math.max(ans, com);
      }
    }
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
  void main(String[]args){cf2063c t=new cf2063c();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}