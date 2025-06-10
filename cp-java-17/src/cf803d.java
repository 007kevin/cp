
import java.io.*;
import java.util.*;

/**
 * Problem    = cf803d
 * Date       = Tue Nov  5 21:26:12 PST 2024
 */
public class cf803d {

  public void run() {
    int k = in.nextInt();
    List<String> tokens = new ArrayList<>();
    while(in.hasNext()){
      String word = in.next();
      StringTokenizer tokenizer = new StringTokenizer(word, "-");
      int cnt = tokenizer.countTokens() - 1;
      while(tokenizer.hasMoreTokens()){
        tokens.add(tokenizer.nextToken() + (cnt != 0 ? "-" : " "));
        cnt--;
      }
    }
    fixLast(tokens);
    int l = 1;
    int r = 1000000;
    int ans = 0;
    while(l <= r){
      int m = (l+r)/2;
      List<StringBuilder> lines = new ArrayList<>();
      StringBuilder line = new StringBuilder();
      boolean flag = true;
      for(String word : tokens){
        if (word.length() > m){
          flag = false;
          break;
        }
        if (line.length() + word.length() <= m)
          line.append(word);
        else {
          lines.add(line);
          line = new StringBuilder(word);
        }
      }
      lines.add(line);
      if (flag && lines.size() <= k){
        ans = m;
        r = m-1;
      } else
        l = m+1;
    }
    out.println(ans);
  }

  void fixLast(List<String> tokens){
    int n = tokens.size();
    String last = tokens.get(n-1);
    tokens.set(n-1, last.substring(0, last.length()-1));
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
  void main(String[]args){cf803d t=new cf803d();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
