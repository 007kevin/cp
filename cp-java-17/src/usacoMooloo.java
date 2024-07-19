
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoMooloo
 * Date       = Thu Jul 18 17:47:31 KST 2024
 */
public class usacoMooloo {

  public void run() {
    int n = in.nextInt();
    long k = in.nextLong();
    long[] d = new long[n];
    for(int i = 0; i < n; ++i)
      d[i]=in.nextLong();
    long cost = 0;
    for(int i = 0; i < n;){
      cost+=1+k;
      int j = i+1;
      while(j < n && k+d[j]-d[i] < d[j-1]-d[i]+2+2*k) j++;
      cost+=d[j-1]-d[i];
      i=j;
    }
    out.println(cost);
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
  void main(String[]args){usacoMooloo t=new usacoMooloo();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
