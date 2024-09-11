
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoRevegetate
 * Date       = Sat Jul 27 13:37:23 KST 2024
 */
public class usacoRevegetate {

  public void run() {
    int N = in.nextInt();
    int M = in.nextInt();
    int[][] p = new int[N+1][N+1];
    int q[][] = new int[N+1][5];
    for(int i = 0; i < M; ++i){
      int a = in.nextInt();
      int b = in.nextInt();
      p[a][b]=1;
      p[b][a]=1;
    }
    for(int i = 1; i <= N; ++i){
      for(int g = 1; g <= 4; ++g){
        if (q[i][g]==0){
          for(int j = 1; j <= N; ++j){
            if (p[i][j]==1){
              q[j][g]=1;
            }
          }
          break;
        }
      }
    }
    for(int i = 1; i <= N; ++i){
      for(int g = 1; g <= 4; ++g){
        if(q[i][g]==0){
          out.print(g);
          break;
        }
      }
    }
    out.println();
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
  void main(String[]args){usacoRevegetate t=new usacoRevegetate();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "revegetate";
}
