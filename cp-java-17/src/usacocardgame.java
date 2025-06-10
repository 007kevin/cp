
import java.io.*;
import java.util.*;

/**
 * Problem    = usacocardgame
 * Date       = Sun Oct 20 12:32:59 PDT 2024
 */
public class usacocardgame {

  public void run() {
    int N = in.nextInt();
    var set = new TreeSet<Integer>();
    for(int i = 1; i <= 2*N; ++i)
      set.add(i);
    Integer[] r1 = new Integer[N/2];
    Integer[] r2 = new Integer[N/2];
    for(int i = 0; i < N/2; ++i){
      r1[i] = in.nextInt();
      set.remove(r1[i]);
    }
    for(int i = 0; i < N/2; ++i){
      r2[i] = in.nextInt();
      set.remove(r2[i]);
    }
    Arrays.sort(r1, Collections.reverseOrder());
    Arrays.sort(r2);
    int p = 0;
    for(int i = 0; i < N/2; ++i){
      int b = set.last();
      if (r1[i] < b) {
        set.remove(b);
        p++;
      }
    }
    for(int i = 0; i < N/2; ++i){
      int b = set.first();
      if (r2[i] > b){
        set.remove(b);
        p++;
      }
    }
    out.println(p);
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
  void main(String[]args){usacocardgame t=new usacocardgame();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "cardgame";
}
