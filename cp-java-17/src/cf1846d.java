
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1846d
 * Date       = Thu Sep  5 09:58:28 PDT 2024
 */
public class cf1846d {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt();
      double d = in.nextInt();
      double h = in.nextInt();
      double r = (d/2.0)/h;
      double[] b = new double[n];
      for(int i = 0; i < n; ++i) b[i]=in.nextDouble();
      double ink = (d*h)/2.0;
      for(int i = 0; i < n-1; ++i){
        ink += (d*h)/2.0;
        if (b[i] + h > b[i+1]){
          double e = b[i]+h-b[i+1];
          double m = e * r;
          ink-=e*m;
        }
      }
      out.println(ink);
    }
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
  void main(String[]args){cf1846d t=new cf1846d();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
