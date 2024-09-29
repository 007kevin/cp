
import java.io.*;
import java.util.*;

/**
 * Problem    = usacomaxcross
 * Date       = Thu Sep 19 13:58:42 PDT 2024
 */
public class usacomaxcross {

  public void run() {
    int N = in.nextInt();
    int K = in.nextInt();
    int B = in.nextInt();
    int[] a = new int[N+1];
    for(int i = 1; i <= B; ++i)
      a[in.nextInt()] = 1;
    for(int i = 1; i <= N; ++i){
      a[i]+=a[i-1];
    }
    int ans = Integer.MAX_VALUE;
    for(int i = K; i <= N; ++i)
      ans=Math.min(ans, a[i]-a[i-K]);
    out.println(ans);
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
  void main(String[]args){usacomaxcross t=new usacomaxcross();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "maxcross";
}
