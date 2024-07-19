
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoGuess
 * Date       = Sun Jun  9 21:06:55 PDT 2024
 */
public class usacoGuess {

  public void run() {
    int n = in.nextInt();
    var list = new ArrayList<Set<String>>(n);
    for(int i = 0; i < n; ++i){
      in.next();
      int k = in.nextInt();
      var set = new HashSet<String>();
      while(k-->0){
        set.add(in.next());
      }
      list.add(set);
    }
    int ans = 0;
    for(int i = 0; i < n; ++i){
      for(int j = i+1; j < n; ++j){
        var merged = new HashSet<>(list.get(i));
        merged.retainAll(list.get(j));
        ans = Math.max(ans, merged.size());
      }
    }
    out.println(ans+1);
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
  void main(String[]args){usacoGuess t=new usacoGuess();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "guess";
}
