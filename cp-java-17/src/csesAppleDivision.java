
import java.io.*;
import java.util.*;

/**
 * Problem    = csesAppleDivision
 * Date       = Sat Jun 29 16:05:49 JST 2024
 */
public class csesAppleDivision {

  public void run() {
    int n = in.nextInt();
    long[] p = new long[n];
    long sum = 0;
    for(int i = 0; i < n; ++i){
      p[i]=in.nextInt();
      sum+=p[i];
    }
    long ans = Long.MAX_VALUE;
    for(int i = 0; i < Math.pow(2,n); ++i){
      ans = Math.min(ans, Math.abs(sum - 2*get(p,i)));
    }
    out.println(ans);
  }

  long get(long[] p, int i){
    long s = 0;
    int j = 0;
    while(i > 0){
      if ((i&1)>0)
        s+=p[j];
      j++;
      i>>=1;
    }
    return s;
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
  void main(String[]args){csesAppleDivision t=new csesAppleDivision();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
