
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoCbarn
 * Date       = Sat May 11 01:53:30 PDT 2024
 */
public class usacoCbarn {

  public void run() {
    int n = in.nextInt();
    int[] r = new int[n];
    for(int i = 0; i < n; ++i) r[i]=in.nextInt();
    int a = Integer.MAX_VALUE;
    for(int i = 0; i < n; ++i){
      int w = 0;
      for(int j = 1; j < n; ++j){
        w+=j*r[(i+j)%n];
      }
      a = Math.min(a,w);
    }
    out.println(a);
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
  void main(String[]args){usacoCbarn t=new usacoCbarn();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "cbarn";
}
