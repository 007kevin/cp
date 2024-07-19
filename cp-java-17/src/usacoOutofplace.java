
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoOutofplace
 * Date       = Fri Jul 12 17:07:12 KST 2024
 */
public class usacoOutofplace {

  public void run() {
    int n = in.nextInt();
    List<Integer> h = new ArrayList<>();
    for(int i = 0; i < n; ++i){
      int v = in.nextInt();
      if (h.isEmpty() || h.get(h.size()-1) != v)
        h.add(v);
    }
    int cnt = 0;
    boolean flag = true;
    while(flag){
      flag = false;
      for(int i = 0; i < h.size()-1; ++i){
        if(h.get(i) > h.get(i+1)){
          swap(h,i,i+1);
          cnt++;
          flag=true;
          break;
        }
      }
    }
    out.println(cnt);
  }

  void swap(List<Integer> h, int i, int j){
    Integer t = h.get(i);
    h.set(i, h.get(j));
    h.set(j, t);
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
  void main(String[]args){usacoOutofplace t=new usacoOutofplace();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "outofplace";
}
