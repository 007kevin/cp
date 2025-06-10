
import java.io.*;
import java.util.*;

/**
 * Problem    = csesTasks
 * Date       = Thu Oct 17 22:34:41 PDT 2024
 */
public class csesTasks {

  static class Task {
    int a;
    int d;
    public Task(int a, int d){
      this.a=a;
      this.d=d;
    }
  }

  public void run() {
    int n = in.nextInt();
    var list = new ArrayList<Task>(n);
    for(int i = 0; i < n; ++i){
      list.add(new Task(in.nextInt(), in.nextInt()));
    }
    Collections.sort(list, Comparator.comparingInt(t -> t.a));
    long c = 0;
    long r = 0;
    for(var t : list){
      c+=t.a;
      r+=t.d-c;
    }
    out.println(r);
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
  void main(String[]args){csesTasks t=new csesTasks();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
