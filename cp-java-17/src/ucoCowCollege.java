
import java.io.*;
import java.util.*;

/**
 * Problem    = ucoCowCollege
 * Date       = Sat Jul  6 09:21:09 KST 2024
 */
public class ucoCowCollege {

  public void run() {
    int n = in.nextInt();
    long[] c = new long[n];
    for(int i = 0; i < n; ++i) c[i]=in.nextLong();
    Arrays.sort(c);
    long maxMoney = 0;
    long optTuition = 0;
    for(int i = 0; i < n; ++i){
      long money = c[i] * (n-i);
      if (money > maxMoney){
        maxMoney = money;
        optTuition = c[i];
      }
    }
    out.println(maxMoney + " " + optTuition);
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
  void main(String[]args){ucoCowCollege t=new ucoCowCollege();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
