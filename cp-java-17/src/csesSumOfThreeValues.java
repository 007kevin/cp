
import java.io.*;
import java.util.*;

/**
 * Problem    = csesSumOfThreeValues
 * Date       = Sun Oct  6 14:00:43 PDT 2024
 */
public class csesSumOfThreeValues {

  public void run() {
    int n = in.nextInt();
    int x = in.nextInt();
    var map = new HashMap<Integer, Set<Integer>>();
    int[] a = new int[n];
    for(int i = 0; i < n; ++i){
      a[i] = in.nextInt();
      map.computeIfAbsent(a[i], k -> new HashSet<>()).add(i);
    }
    for(int i = 0; i < n; ++i){
      for(int j = i+1; j < n; ++j){
        if (a[i] + a[j] < x){
          int c = x - a[i] - a[j];
          for(int k : map.getOrDefault(c, new HashSet<>())){
            if(k!=i&&k!=j){
              out.println((i+1) + " " + (j+1) + " " + (k+1));
              return;
            }
          }
        }
      }
    }
    out.println("IMPOSSIBLE");
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
  void main(String[]args){csesSumOfThreeValues t=new csesSumOfThreeValues();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
