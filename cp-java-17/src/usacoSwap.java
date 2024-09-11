
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoSwap
 * Date       = Sat Jul 27 14:31:28 KST 2024
 */
public class usacoSwap {

  public void run() {
    int N = in.nextInt();
    int K = in.nextInt();
    int[] a = new int[N+1];
    for(int i = 1; i <= N; ++i)
      a[i] = i;
    int a1=in.nextInt(), a2=in.nextInt();
    int b1=in.nextInt(), b2=in.nextInt();
    int c = 0;
    do {
      rev(a,a1,a2);
      rev(a,b1,b2);
      c++;
    } while(!sorted(a));
    int mod = K%c;
    while(mod>0){
      rev(a,a1,a2);
      rev(a,b1,b2);
      mod--;
    }
    print(a);
  }

  void rev(int[] a, int a1, int a2){
    while(a1<a2){
      swap(a,a1,a2);
      a1++;
      a2--;
    }
  }

  void swap(int[] a, int i, int j){
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  boolean sorted(int[] a){
    for(int i = 1; i < a.length-1; ++i){
      if(a[i] > a[i+1])
        return false;
    }
    return true;
  }

  void print(int[] a){
    for(int i = 1; i < a.length; ++i)
      out.println(a[i]);
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
  void main(String[]args){usacoSwap t=new usacoSwap();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "swap";
}
