
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoDeye
 * Date       = Tue Oct  8 16:11:52 PDT 2024
 */
public class usacoDeye {

  public void run() {
    int N = in.nextInt();
    long K = in.nextLong();
    long[] d = new long[N];
    long[] p = new long[N];
    for(int i = 0; i < N; ++i)
      d[i]=in.nextLong();
    Arrays.sort(d);
    for(int i = 1; i < N; ++i){
      int l = 0;
      int r = i-1;
      int s = 0;
      while(l<=r){
        int m = (l+r)/2;
        if (d[i]-d[m] <= K){
          if (i-m+1 > s)
            s=i-m+1;
          r = m-1;
        } else
          l = m+1;
      }
      p[i]=s;
    }
    for(int i = 1; i < N; ++i)
      p[i]=Math.max(p[i],p[i-1]);
    long ans = 0;
    for(int i = 1; i < N; ++i){
      int l = i+1;
      int r = N-1;
      while(l<=r){
        int m = (l+r)/2;
        if (d[m] - d[i] <= K){
          ans = Math.max(ans, p[i-1] + m-i+1);
          l = m+1;
        } else
          r = m-1;
      }
    }
    out.println(ans);
    // print(p);
    // print(d);
  }

  void print(long[] a){
    for(long n : a)
      out.print(n + "\t");
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
  void main(String[]args){usacoDeye t=new usacoDeye();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "diamond";
}
