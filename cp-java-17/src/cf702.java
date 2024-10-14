
import java.io.*;
import java.util.*;

/**
 * Problem    = cf702
 * Date       = Sun Oct 13 14:30:00 PDT 2024
 */
public class cf702 {

  public void run() {
    int n = in.nextInt();
    int m = in.nextInt();
    long[] a = new long[n];
    for(int i = 0; i < n; ++i)
      a[i]=in.nextLong();
    var set = new TreeSet<Long>();
    for(int i = 0; i < m; ++i)
      set.add(in.nextLong());
    long ans = 0;
    for(int i = 0; i < n; ++i){
      Long low = set.floor(a[i]);
      Long high = set.ceiling(a[i]);
      if (low == null) low = -20000000001L;
      if (high == null) high = 20000000001L;
      ans = Math.max(ans, Math.min(a[i]-low, high-a[i]));
    }
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
  void main(String[]args){cf702 t=new cf702();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
