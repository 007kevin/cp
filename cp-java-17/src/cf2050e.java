
import java.io.*;
import java.util.*;

/**
 * Problem    = cf2050e
 * Date       = Sun Feb 23 16:06:55 PST 2025
 */
public class cf2050e {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      solve();
    }
  }

  char[] a;
  char[] b;
  char[] c;
  int[][] dp;

  void solve(){
    a = in.next().toCharArray();
    b = in.next().toCharArray();
    c = in.next().toCharArray();
    dp = new int[a.length+1][b.length+1];
    for(int[] r : dp) Arrays.fill(r, -1);
    out.println(f(0,0));
  }

  int f(int i, int j){
    if (dp[i][j]!=-1) return dp[i][j];

    if (i == a.length && j == b.length) return 0;
    if (i == a.length){
      dp[i][j] = (c[i+j] == b[j] ? 0 : 1) + f(i, j+1);
      return dp[i][j];
    }
    if (j == b.length){
      dp[i][j] = (c[i+j] == a[i] ? 0 : 1) + f(i+1, j);
      return dp[i][j];
    }
    dp[i][j] = Math.min(
        (c[i+j] == a[i] ? 0 : 1) + f(i+1,j),
        (c[i+j] == b[j] ? 0 : 1) + f(i,j+1));
    return dp[i][j];
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
  void main(String[]args){cf2050e t=new cf2050e();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
