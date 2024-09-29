
import java.io.*;
import java.util.*;

/**
 * Problem    = usacohps
 * Date       = Tue Sep 17 20:32:04 PDT 2024
 */
public class usacohps {

  public void run() {
    int n = in.nextInt();
    int[][] g = new int[n+1][3];
    for(int i = 1; i <= n; ++i){
      String s = in.next();
      switch(s){
        case "H":
          g[i][0]++;
          break;
        case "P":
          g[i][1]++;
          break;
        default:
          g[i][2]++;
      }
      for(int j = 0; j < 3; ++j){
        g[i][j]+=g[i-1][j];
      }
    }
    int ans = 0;
    for(int i = 1; i <= n; ++i){
      for(int j = 0; j < 3; ++j){
        for(int k = 0; k < 3; ++k){
          int left = g[i][j];
          int right = g[n][k] - g[i][k];
          ans = Math.max(ans, left + right);
        }
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
  void main(String[]args){usacohps t=new usacohps();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "hps";
}
