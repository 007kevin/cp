
import java.io.*;
import java.util.*;

/**
 * Problem    = usacostacking
 * Date       = Thu Sep 19 16:59:52 PDT 2024
 */
public class usacostacking {

  public void run() {
    int N = in.nextInt();
    int K = in.nextInt();
    int[] a = new int[N];
    for(int i = 0; i < K; ++i){
      int x = in.nextInt();
      int y = in.nextInt();
      a[x-1]++;
      if (y!=N)
        a[y]--;
    }
    for(int i = 1; i < N; ++i){
      a[i]+=a[i-1];
    }
    Arrays.sort(a);
    out.println(a[N/2]);
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
  void main(String[]args){usacostacking t=new usacostacking();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "stacking";
}
