
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoPails
 * Date       = Thu May 30 21:59:13 PDT 2024
 */
public class usacoPails {

  public void run() {
    int x = in.nextInt();
    int y = in.nextInt();
    int m = in.nextInt();
    int u = 0;
    for(int i = 0; i <= 1000; ++i){
      for(int j = 0; j <= 1000; ++j){
        int a = i*x + y*j;
        if (a <= m)
          u = Math.max(u, a);
      }
    }
    out.println(u);
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
  void main(String[]args){usacoPails t=new usacoPails();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "pails";
}
