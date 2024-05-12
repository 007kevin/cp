
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoTttt
 * Date       = Sat May 11 11:12:04 PDT 2024
 * Comment    = and moreover if characters from both
 *              cows (not just one) are used in this
 *              row,column, or diagonal....
 */
public class usacoTttt {

  public void run() {
    char[] t = new char[9];
    for(int i = 0; i < 3; ++i){
      char[] r = in.next().toCharArray();
      for(int j = 0; j < 3; ++j){
        t[(i*3)+j] = r[j];
      }
    }
    int w = 0;
    for(char c = 'A'; c <= 'Z'; c++)
      w += win1(t,c);
    out.println(w);
    w = 0;
    for(char c = 'A'; c <= 'Z'; c++)
      for(char d = (char)(c+1); d <= 'Z'; d++)
        w += win2(t,c,d);
    out.println(w);
  }

  int win1(char[] t, char c){
    return(eq(c,t[0],t[1],t[2]) ||
        eq(c,t[3],t[4],t[5]) ||
        eq(c,t[6],t[7],t[8]) ||
        eq(c,t[0],t[3],t[6]) ||
        eq(c,t[1],t[4],t[7]) ||
        eq(c,t[2],t[5],t[8]) ||
        eq(c,t[0],t[4],t[8]) ||
        eq(c,t[2],t[4],t[6])) ? 1 : 0;
  }

  int win2(char[] t, char c, char d){
    return(eq(c,d,t[0],t[1],t[2]) ||
        eq(c,d,t[3],t[4],t[5]) ||
        eq(c,d,t[6],t[7],t[8]) ||
        eq(c,d,t[0],t[3],t[6]) ||
        eq(c,d,t[1],t[4],t[7]) ||
        eq(c,d,t[2],t[5],t[8]) ||
        eq(c,d,t[0],t[4],t[8]) ||
        eq(c,d,t[2],t[4],t[6])) ? 1 : 0;
  }

  boolean eq(char c, char x, char y, char z){
    return c == x && c == y && c == z;
  }

  boolean eq(char c, char d, char x, char y, char z){
    Set<Character> set = new HashSet<>();
    set.add(x);
    set.add(y);
    set.add(z);
    // if (set.size() == 1){
    //   return set.contains(c) || set.contains(d);
    // }
    if (set.size() == 2){
      return set.contains(c) && set.contains(d);
    }
    return false;
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
  void main(String[]args){usacoTttt t=new usacoTttt();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "tttt";
}
