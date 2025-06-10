
import java.io.*;
import java.util.*;

/**
 * Problem    = cf2055c
 * Date       = Sat Feb  8 22:45:23 PST 2025
 */
public class cf2055c {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt();
      int m = in.nextInt();
      char[] s = in.next().toCharArray();
      long[][] g = new long[n+1][m+1];
      for(int i = 1; i <= n; ++i){
        for(int j = 1; j <= m; ++j){
          g[i][j]=in.nextLong();
          g[i][0]+=g[i][j];
          g[0][j]+=g[i][j];
        }
      }
      int x = 1, y = 1;
      for(char c : s){
        if (c == 'D'){
          g[x][y]=-g[x][0];
          g[0][y]+=g[x][y];
          x++;
        }
        if (c == 'R'){
          g[x][y]=-g[0][y];
          g[x][0]+=g[x][y];
          y++;
        }
      }
      g[n][m]=-g[n][0];
      print(g);
    }
  }

  void print(long[][] g){
    for(int i = 1; i < g.length; ++i){
      for(int j = 1; j < g[i].length; ++j){
        out.print(g[i][j] + " ");
      }
      out.println();
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
  void main(String[]args){cf2055c t=new cf2055c();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
