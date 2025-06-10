
import java.io.*;
import java.util.*;

/**
 * Problem    = cf2053c
 * Date       = Sat Jan 25 15:49:44 PST 2025
 */
public class cf2053c {

  long n,k,a;

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      n=in.nextLong();
      k=in.nextLong();
      find(n);
      out.println(a);
      a=0;
    }
  }

   long find (long r){
    if (r < k)
      return 0;
    long m = (r+1)/2;
    long c = find(r%2==0?m:m-1);
    a+=(a + m*c);
    a+=m*(r%2);
    return (2*c)+r%2;
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
  void main(String[]args){cf2053c t=new cf2053c();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
