
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoCensor
 * Date       = Sat May 18 13:17:08 PDT 2024
 */
public class usacoCensor1 {

  public void run() {
    String s = in.next();
    String t = in.next();
    while(s.contains(t)){
      s = s.replaceFirst(t, "");
    }
    out.println(s);
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
  void main(String[]args){usacoCensor1 t=new usacoCensor1();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "censor";
}
