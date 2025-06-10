
import java.io.*;
import java.util.*;

/**
 * Problem    = csesTowers
 * Date       = Thu Oct 17 22:44:01 PDT 2024
 */
public class csesTowers {

  public void run() {
    int n = in.nextInt();
    var set = new TreeSet<Integer>();
    for(int i = 0; i < n; ++i){
      int k = in.nextInt();
      Integer h = set.higher(k);
      if (h==null)
        set.add(k);
      else {
        set.remove(h);
        set.add(k);
      }
    }
    out.println(set.size());
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
  void main(String[]args){csesTowers t=new csesTowers();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
