
import java.io.*;
import java.util.*;

/**
 * Problem    = cf632c
 * Date       = Sun Sep 29 15:19:33 PDT 2024
 */
public class cf632c {

  static class Test implements Comparable<Test> {

    @Override
    public int compareTo(cf632c.Test o) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

  }

  public void run() {
    int n = in.nextInt();
    List<String> list = new ArrayList<>();
    for(int i = 0; i < n; ++i)
      list.add(in.next());

    Collections.sort(list, (a, b) -> {
      String ab = a+b;
      String ba = b+a;
      return ab.compareTo(ba);
    });

    StringJoiner joiner = new StringJoiner("");
    list.forEach(joiner::add);
    out.println(joiner);
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
  void main(String[]args){cf632c t=new cf632c();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
