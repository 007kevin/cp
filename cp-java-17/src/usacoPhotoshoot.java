
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoPhotoshoot
 * Date       = Tue Jul 16 16:01:01 KST 2024
 */
public class usacoPhotoshoot {

  public void run() {
    int n = in.nextInt();
    String s = in.next();
    int[] g = new int[n+1];
    for(int i = 1; i <= n; ++i){
      char c = s.charAt(i-1);
      if (c=='G'){
        if(i%2==0) g[i]=g[i-1]-1;
        else g[i]=g[i-1]+1;
      } else
        g[i]=g[i-1];
    }
    List<Integer> list = new ArrayList<>(n);
    for(int i = 0; i <= n; i+=2)
      if (list.isEmpty() || list.get(list.size()-1) != g[i])
        list.add(g[i]);
    int m = list.size();
    int cnt = 0;
    for(int i = 1; i < m-1; ++i){
      int a = list.get(i-1);
      int b = list.get(i);
      int c = list.get(i+1);
      if ((a < b && b > c) || (a > b && b < c))
        cnt++;
      if (i == m-2)
        if (b < c)
          cnt++;
    }
    out.println(cnt);
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
  void main(String[]args){usacoPhotoshoot t=new usacoPhotoshoot();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
