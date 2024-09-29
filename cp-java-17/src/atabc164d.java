

import java.io.*;
import java.util.*;

/**
 * Problem    = atabc164d
 * Date       = Sun Sep 22 14:33:47 PDT 2024
 */
public class atabc164d {

  public void run() {
    int i = 2019;
    int m = 1;
    Set<String> set = new HashSet<>();
    while(m*i <= 200000){
      if(!hasZero(m*i)){
        set.add(String.valueOf(m*i));
      }
      m++;
    }
    // 5 -> 7
    String s = in.next();

  }

  boolean hasZero(int v){
    while(v%10!=0){
      v/=10;
    }
    return v!=0;
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
  void main(String[]args){atabc164d t=new atabc164d();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
