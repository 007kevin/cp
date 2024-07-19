
import java.io.*;
import java.util.*;

/**
 * Problem    = cfCasino
 * Date       = Sun Jun 30 07:02:18 JST 2024
 */
public class cfCasino {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt();
      int m = in.nextInt();
      int[][] g = new int[n][m];
      for(int i = 0; i < n; ++i)
        for(int j = 0; j < m; ++j)
          g[i][j]=in.nextInt();
      long sum = 0;
      for(int i = 0; i < n; ++i){
        for(int j = i+1; j < n; ++j){
          for(int k = 0; k < m; ++k){
            sum+=Math.abs(g[i][k] - g[j][k]);
          }
        }
      }
      out.println(sum);
    }
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
  void main(String[]args){cfCasino t=new cfCasino();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
