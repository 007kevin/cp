
import java.io.*;
import java.util.*;

/**
 * Problem    = csesCreatingStrings
 * Date       = Sat Jun 29 16:18:16 JST 2024
 */
public class csesCreatingStrings {

  static char NULL = '\0';
  Set<String> set = new TreeSet<>();

  public void run() {
    char[] c = in.next().toCharArray();
    print(new StringBuilder(), c);
    out.println(set.size());
    for(String s : set){
      out.println(s);
    }
  }

  void print(StringBuilder s, char[] c){
    if (s.length() == c.length){
      set.add(s.toString());
      return;
    }
    for(int i = 0; i < c.length; ++i){
      if (c[i] != NULL){
        char tmp = c[i];
        s.append(tmp);
        c[i] = NULL;
        print(s, c);
        c[i] = tmp;
        s.deleteCharAt(s.length()-1);
      }
    }
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
  void main(String[]args){csesCreatingStrings t=new csesCreatingStrings();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
