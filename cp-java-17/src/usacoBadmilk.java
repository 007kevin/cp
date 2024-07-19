
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoBadmilk
 * Date       = Wed Jun 26 12:58:28 PDT 2024
 */
public class usacoBadmilk {

  public void run() {
    int N = in.nextInt();
    int M = in.nextInt();
    int D = in.nextInt();
    int S = in.nextInt();
    Map<Integer, Map<Integer, Integer>> milkSet = new HashMap<>();
    for(int i = 0; i < D; ++i){
      int p = in.nextInt();
      int m = in.nextInt();
      int t = in.nextInt();
      add(milkSet,p,m,t);
    }
    int[][] s = new int[S][2];
    for(int i = 0; i < S; ++i){
      s[i][0]=in.nextInt();
      s[i][1]=in.nextInt();
    }
    int ans = -1;
    for(int i = 1; i <= M; ++i){
      ans=Math.max(ans, check(milkSet,i,s));
    }
    out.println(ans);
  }

  void add(
      Map<Integer, Map<Integer, Integer>> milkSet,
      int p,
      int m,
      int t){
    milkSet.computeIfAbsent(m, k -> new HashMap<>())
        .compute(p, (k,v) -> (v == null || t < v) ? t : v);
  }

  int check(Map<Integer, Map<Integer, Integer>> milkSet,
      int m,
      int[][] s){
    if (!milkSet.containsKey(m))
      return -1;
    var milk = milkSet.get(m);
    for(int[] p : s){
      var t = milk.getOrDefault(p[0], Integer.MAX_VALUE);
      if (p[1] <= t)
        return -1;
    }
    return milk.size();
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
  void main(String[]args){usacoBadmilk t=new usacoBadmilk();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "badmilk";
}
