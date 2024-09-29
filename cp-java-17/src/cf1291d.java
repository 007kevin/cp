
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1291d
 * Date       = Sat Sep 21 11:06:33 PDT 2024
 */
public class cf1291d {

  public void run() {
    char[] s = in.next().toCharArray();
    int[][] p = new int[s.length+1][256];
    for(int i = 1; i <= s.length; ++i){
      p[i][s[i-1]] = 1;
      for(int j = 0; j < 256; ++j){
        p[i][j] += p[i-1][j];
      }
    }
    int q = in.nextInt();
    while(q-->0){
      if (irreducible(p,s, in.nextInt(),in.nextInt())){
        out.println("YES");
      } else {
        out.println("NO");
      }
    }
  }

  boolean irreducible(int[][] p, char[] s, int l, int r){
    if (l==r) return true;
    int cnt = 0;
    for(int i = 0; i < 256; ++i){
      if (p[r][i]-p[l-1][i] > 0){
//        out.println((char) i + ": " + (p[r][i]-p[l-1][i]) );
        cnt++;
      }
    }
    if (cnt==2){
      return s[l-1]!=s[r-1];
    }
    return cnt!=1;
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
  void main(String[]args){cf1291d t=new cf1291d();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
