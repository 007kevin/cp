
import java.io.*;
import java.util.*;

/**
 * Problem    = csesDistinctNumbers
 * Date       = Sun Jun 30 06:54:20 JST 2024
 */
public class csesDistinctNumbers {

  public void run() {
    int n = in.nextInt();
    Integer[] x = new Integer[n];
    for(int i = 0; i < n; ++i) x[i] = in.nextInt();
    Arrays.sort(x);
    int d = n == 0 ? 0 : 1;
    for(int i = 0; i < n-1; ++i)
      if (Integer.compare(x[i], x[i+1]) != 0)
        d++;
    out.println(d);
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
  void main(String[]args){csesDistinctNumbers t=new csesDistinctNumbers();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
