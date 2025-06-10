
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoconvention
 * Date       = Sat Oct 26 14:10:54 PDT 2024
 */
public class usacoconvention {

  public void run() {
    int N = in.nextInt();
    int M = in.nextInt();
    int C = in.nextInt();
    int[] a = new int[N];
    for(int i = 0; i < N; ++i) a[i] = in.nextInt();
    Arrays.sort(a);
    int left = 0;
    int right = 1000000000;
    int ans = 0;
    while(left <= right){
      int time = (left + right)/2;
      if (ok(N,M,C,time,a)){
        ans = time;
        right = time-1;
      } else {
        left = time+1;
      }
    }
    out.println(ans);
  }

  boolean ok(int N, int M, int C, int time, int[] a){
    int m = 0;
    for(int i = 0; i < N;){
      int j = i;
      while(j < N && j-i < C && a[j] - a[i] <= time) j++;
      m++;
      i = j;
    }
    return m <= M;
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
  void main(String[]args){usacoconvention t=new usacoconvention();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "convention";
}
