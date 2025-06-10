
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoangry
 * Date       = Sat Nov  2 10:05:07 PDT 2024
 */
public class usacoangry {

  public void run() {
    int N = in.nextInt();
    int K = in.nextInt();
    int[] x = new int[N];
    for(int i = 0; i < N; ++i)
      x[i]=in.nextInt();
    Arrays.sort(x);
    int l = 0;
    int r = 1000000000;
    int R = 0;
    while(l<=r){
      int p = (l+r)/2;
      int k = run(x,p);
      if (k <= K){
        R = p;
        r = p-1;
      } else
        l = p+1;
    }
    out.println(R);
  }

  int run(int[] x, int p){
    int d = 0;
    int r = -1;
    for(int i = 0; i < x.length; ++i){
      if (x[i] > r){
        d++;
        r=x[i]+(2*p);
      }
    }
    //out.println(String.format("for power %d, d=%d", p, d));
    return d;
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
  void main(String[]args){usacoangry t=new usacoangry();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "angry";
}
