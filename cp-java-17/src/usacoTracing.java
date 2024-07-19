
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoTracing
 * Date       = Thu Jun 27 09:04:39 PDT 2024
 */
public class usacoTracing {
  int N,T;
  int[][] M;
  int[] A;

  class result {
    int[] a = new int[N+1];
    int mink = 0;
    int maxk = Integer.MAX_VALUE;
  }

  public void run() {
    N = in.nextInt();
    T = in.nextInt();
    M = new int[N+1][N+1];
    A = new int[N+1];
    String s = in.next();
    for(int i = 0; i < N; ++i){
      A[i+1]=s.charAt(i)-'0';
    }
    for(int i = 0; i < T; ++i){
      int t = in.nextInt();
      int x = in.nextInt();
      int y = in.nextInt();
      M[x][y]=t;
    }
    int x = 0;
    int y = 0;
    int z = Integer.MAX_VALUE;
    for(int i = 1; i <= N; ++i){
      if (A[i]==1){
        result r = new result();
        check(r, i, 0);
        if (same(r.a, A)){
          x++;
          y = Math.max(y, r.mink);
          z = Math.min(z, r.maxk);
        }
      }
    }
    out.println(
        String.format("%d %d %s", x, y,
            z == Integer.MAX_VALUE ? "Infinity" : String.valueOf(z)));
  }

  void check(result r, int c, int t){
    if (r.a[c]==1)
      return;
    r.a[c]=1;
    int cnt = 0;
    int inf = 0;
    for(int i = 1; i <= N; ++i){
      if (M[c][i] > t){
        cnt++;
        if (A[i]==1)
          inf++;
      }
    }
    r.mink = Math.max(r.mink, inf);
    if (cnt != inf){
      r.maxk = inf;
    }
    for(int i = 1; i <= N; ++i){
      if (M[c][i] > t && A[i]==1){
        check(r, i, M[c][i]);
      }
    }
  }

  boolean same(int[] a, int[] b){
    int n = a.length;
    for(int i = 0; i < n; ++i)
      if (a[i] != b[i])
        return false;
    return true;
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
  void main(String[]args){usacoTracing t=new usacoTracing();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "tracing";
}
