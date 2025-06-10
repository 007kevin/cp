
import java.io.*;
import java.util.*;

/**
 * Problem    = cf2061d
 * Date       = Sat Feb  1 12:03:21 PST 2025
 */
public class cf2061d {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      solve();
    }
  }

  void solve(){
    int n = in.nextInt();
    int m = in.nextInt();
    var a = new HashMap<Integer,Integer>();
    var b = new PriorityQueue<Integer>(Comparator.reverseOrder());
    for(int i = 0; i < n; ++i){
      int p = in.nextInt();
      a.put(p, a.getOrDefault(p, 0)+1);
    }
    for(int i = 0; i < m; ++i)
      b.add(in.nextInt());
    int s = 0;
    while (!a.isEmpty() && !b.isEmpty() && s <= n - m){
      // out.println(a);
      // out.println(b);
      // out.println("-------");
      var p = b.poll();
      if (a.containsKey(p)){
        int c = a.get(p);
        if (c == 1) a.remove(p);
        else a.put(p, c-1);
      } else {
        if (p == 1){
          out.println("No");
          return;
        }
        b.add(p/2);
        b.add(p/2 + (p%2));
        s++;
      }
    }
    out.println(a.size()==0 && b.size() == 0 ? "Yes" : "No");
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
  void main(String[]args){cf2061d t=new cf2061d();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
