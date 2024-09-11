
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoRace2
 * Date       = Fri Jul 26 10:15:15 KST 2024
 */
public class usacoRace2 {

  public void run() {
    int K = in.nextInt();
    int N = in.nextInt();
    for(int i = 0; i < N; ++i){
      out.println(find(K, in.nextInt()));
    }
    }

    int find(int K, int x){
      int a = 0;
      int as = 0;
      int b = 0;
      int bs = x;
      for(; a <= K; as++){
        a+=as;
        if (a+b >= K)
          return as + bs - x;
        if (as >= x){
          b+=bs;
          if (a+b >= K)
            return as + bs - x + 1;
          bs++;
        }
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
  void main(String[]args){usacoRace2 t=new usacoRace2();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "race";
}
