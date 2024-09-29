
import java.io.*;
import java.util.*;

/**
 * Problem    = coci17c5p2
 * Date       = Thu Sep 12 15:35:45 PDT 2024
 */
public class usacoBcount {

  public void run() {
    int N = in.nextInt();
    int Q = in.nextInt();
    int[][] n = new int[4][N+1];
    for(int i = 1; i <= N; ++i){
      int b = in.nextInt();
      for(int j = 1; j <= 3; ++j)
        n[j][i] += n[j][i-1] + (j==b?1:0);
    }
    for(int i = 1; i <= Q; ++i){
      int a = in.nextInt();
      int b = in.nextInt();
      out.println(
          String.format("%d %d %d",
              n[1][b]-n[1][a-1],
              n[2][b]-n[2][a-1],
              n[3][b]-n[3][a-1]));
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
  void main(String[]args){usacoBcount t=new usacoBcount();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "bcount";
}
