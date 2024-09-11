
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoRace
 * Date       = Tue Jul 23 23:18:45 KST 2024
 */
public class usacoRace {

  public void run() {
    long K = in.nextLong();
    int N = in.nextInt();
    long[][] X = new long[N][2];
    for(int i = 0; i < N; ++i){
      X[i][0] =in.nextLong();
      X[i][1] = Long.MAX_VALUE;
    }

    long s = 1;
    while(d(s) <= K){
      for(long[] x : X){
        long p = d(s) + Math.max(0, d(s-1) - d(x[0]-1));
        if (p > K)
          continue;
        long r = K-p;
//        System.out.println(String.format("s:%d, p:%d, r:%d", s, p, r));
        x[1]=Math.min(x[1], s + Math.max(0,s - x[0]) + ceil(r,s));
      }
      s++;
    }

    for(var x : X)
      out.println(x[1]);
  }

  long d(long s){
    return (s*(s+1))/2;
  }

  long ceil(long a, long b){
    return (long) Math.ceil((double) a / (double) b);
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
  void main(String[]args){usacoRace t=new usacoRace();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "race";
}
