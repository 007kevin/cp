
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoDiamond
 * Date       = Thu May 30 22:05:10 PDT 2024
 */
public class usacoDiamond {

  public void run() {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] d = new int[n];
    for(int i = 0; i < n; ++i) d[i] = in.nextInt();
    Arrays.sort(d);
    int a = 0;
    for(int i = 0; i < n; ++i){
      int j = i+1;
      while(j < n && d[j] - d[i] <= k) j++;
      a = Math.max(a, j-i);
    }
    out.println(a);
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
  void main(String[]args){usacoDiamond t=new usacoDiamond();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "diamond";
}
