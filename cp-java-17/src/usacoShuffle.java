
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoShuffle
 * Date       = Tue May  7 22:02:32 PDT 2024
 */
public class usacoShuffle {

  public void run() {
    int n = in.nextInt();
    int[] a = new int[n+1];
    int[] l = new int[n+1];
    for(int i = 1; i <= n; ++i) a[i] = in.nextInt();
    for(int i = 1; i <= n; ++i) l[i] = in.nextInt();
    for(int i = 0; i < 3; ++i){
      l = unshuffle(a,l);
    }
    print(l);
  }

  int[] unshuffle(int[] a, int[] l){
    int n = l.length - 1;
    int[] m = new int[n+1];
    for(int i = 1; i <= n; ++i){
      m[i]=l[a[i]];
    }
    return m;
  }

  void print(int[] l){
    for(int i = 1; i < l.length; ++i)
      out.println(l[i]);
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
  void main(String[]args){usacoShuffle t=new usacoShuffle();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "shuffle";
}
