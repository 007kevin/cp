
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoGymnastics
 * Date       = Fri May 31 18:37:40 PDT 2024
 */
public class usacoGymnastics {

  public void run() {
    int k = in.nextInt();
    int n = in.nextInt();
    int[][] p = new int[k][n+1];
    for(int i = 0; i < k; ++i){
      for(int j = 1; j <= n; ++j){
        int c = in.nextInt();
        p[i][c]=j;
      }
    }
    // for(int i = 0; i < k; ++i){
    //   for(int j = 1; j <=n; ++j){
    //     out.print(p[i][j] + " ");
    //   }
    //   out.println();
    // }
    // out.println("==========");

    int a = 0;
    for(int i = 1; i <= n; ++i){
      for(int j = 1; j <= n; ++j){
        int w = 0;
        for(int s = 0; s < k; ++s){
          if (p[s][i] < p[s][j]) w++;
        }
        // out.println(i + " > " + j + ": " + w);

        if (w == k){
          a++;
        }
      }
    }
    out.println(a);
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
  void main(String[]args){usacoGymnastics t=new usacoGymnastics();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "gymnastics";
}
