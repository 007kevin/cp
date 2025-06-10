
import java.io.*;
import java.util.*;
/**
 * Problem    = atcoder203d
 * Date       = Fri Nov  8 17:30:58 PST 2024
 */
public class atcoder203d {

  public void run() {
    int N = in.nextInt();
    int K = in.nextInt();
    int[][] a = new int[N+1][N+1];
    int maxA = 0;
    for(int i = 1; i <= N; ++i)
      for(int j = 1; j <= N; ++j){
        a[i][j]=in.nextInt();
        maxA=Math.max(maxA, a[i][j]);
      }
    int l = 0;
    int r = maxA;
    // int l = 4;
    // int r = 4;
    while(l<=r){
      int m = (l+r)/2;
      int[][] p = new int[N+1][N+1];
      for(int i = 1; i <= N; ++i)
        for(int j = 1; j <= N; ++j){
          p[i][j] = a[i][j] <= m ? 1 : 0;
          p[i][j]+=p[i-1][j] + p[i][j-1] - p[i-1][j-1];
        }
      boolean exist = false;
      for(int i = K; i <= N; ++i){
        for(int j = K; j <= N ; ++j){
          int sum = p[i][j];
          sum-=p[i-K][j];
          sum-=p[i][j-K];
          sum+=p[i-K][j-K];
          if (sum >= ((K*K-1)/2 + 1)){
            exist = true;
            break;
          }
        }
      }
      if (exist){
        r = m-1;
      } else
        l = m+1;
    }
    out.println(l);
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
  void main(String[]args){atcoder203d t=new atcoder203d();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
