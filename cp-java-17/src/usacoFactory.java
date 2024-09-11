
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoFactory
 * Date       = Sat Jul 27 14:04:52 KST 2024
 */
public class usacoFactory {

  int N;
  int F[][];
  int V[][];

  public void run() {
    N = in.nextInt();
    F = new int[N+1][N+1];
    V = new int[N+1][N+1];
    for(int i = 0; i < N-1; ++i){
      int a = in.nextInt();
      int b = in.nextInt();
      F[a][b] = 1;
    }
    for(int i = 1; i <= N; ++i){
      traverse(i,i);
    }
    out.println(find());
  }

  void traverse(int I, int i){
    for(int j = 1; j <= N; ++j){
      if (i != j && F[i][j] == 1 && V[j][I] == 0){
        V[j][I] = 1;
        traverse(I,j);
      }
    }
  }

  int find() {
    for(int i = 1; i <= N; ++i){
      int cnt = 0;
      for(int j = 1; j <= N; ++j){
        if (i!=j&&V[i][j]==1)
          cnt++;
      }
      if (cnt == N-1)
        return i;
    }
    return -1;
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
  void main(String[]args){usacoFactory t=new usacoFactory();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "factory";
}
