
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoMilkorder
 * Date       = Sun Jul  7 22:35:46 KST 2024
 */
public class usacoMilkorder {

  public void run() {
    int N = in.nextInt();
    int M = in.nextInt();
    int K = in.nextInt();
    int[] o = new int[N+1];
    int[] m = new int[M];
    boolean[] d = new boolean[M];
    for(int i = 0; i < M; ++i) m[i]=in.nextInt();
    for(int i = 0; i < K; ++i){
      int c = in.nextInt();
      int p = in.nextInt();
      o[p]=c;
      // might need to optimize
      for(int j = 0; j < M; ++j)
        if (c == m[j])
          d[j]=true;
    }
    for(int i = 1; i <= N; ++i){
      if(o[i]!=0)
        continue;
      o[i]=1;
      boolean filled = true;
      for(int j = 0; j < M; ++j){
        if (d[j]) continue;
        int p = 1;
        while(j!=0&&o[p]!=m[j-1]&&p<=N) p++;
        while(p<=N&&o[p]!=0){
          if (j!=M-1&&o[p]==m[j+1]){
            filled=false;
            break;
          }
          p++;
        }
        if (!filled || p>N){
          filled = false;
          break;
        }
      }
      o[i]=0;
      if (filled) {
        out.println(i);
        break;
      }
      // else
      //   System.out.println("failed " + i);
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
  void main(String[]args){usacoMilkorder t=new usacoMilkorder();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "milkorder";
}
