
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoCowtip
 * Date       = Thu Jul 11 21:38:13 KST 2024
 */
public class usacoCowtip {

  public void run() {
    int n = in.nextInt();
    int[][] g = new int[n][n];
    for(int i = 0; i < n; ++i){
      char[] c = in.next().toCharArray();
      for(int j = 0; j < n; ++j)
        g[i][j]=c[j]-'0';
    }
    out.println(solve(g));
  }

  int solve(int[][] g){
    int n=g.length;
    int r=-1;
    int d=-1;
    for(int i = 0; i < n; ++i){
      for(int j = 0; j < n; ++j){
        if (g[i][j]==1){
          d=i;
          r=j;
        }
      }
    }
    if(r==-1&&d==-1)
      return 0;
    for(int i = 0; i <= d; ++i){
      for(int j = 0; j <= r; ++j){
        g[i][j]=(g[i][j]+1)%2;
      }
    }
    return 1 + solve(g);
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
  void main(String[]args){usacoCowtip t=new usacoCowtip();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "cowtip";
}
