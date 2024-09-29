
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoRut
 * Date       = Sat Sep 28 00:12:48 PDT 2024
 */
public class usacoRut {

  public void run() {
    int N = in.nextInt();
    List<Integer> north = new ArrayList<>(N);
    List<Integer> east = new ArrayList<>(N);
    int[] x = new int[N];
    int[] y = new int[N];
    for(int i = 0; i < N; ++i){
      char d = in.next().charAt(0);
      if (d == 'N')
        north.add(i);
      else
        east.add(i);
      x[i]=in.nextInt();
      y[i]=in.nextInt();
    }
    east.sort(Comparator.comparingInt(i -> y[i]));
    north.sort(Comparator.comparingInt(i -> x[i]));
    boolean[] blocked = new boolean[N];
    int[] blocks = new int[N];
    for(int e : east){
      for(int n : north){
        if (!blocked[n] && !blocked[e]){
          if (y[n] < y[e] && x[e] < x[n]){
            int nd = y[e] - y[n];
            int ed = x[n] - x[e];
            if (nd == ed) continue;
            if (ed > nd){
              blocked[e] = true;
              blocks[n]+=blocks[e]+1;
            } else {
              blocked[n] = true;
              blocks[e]+=blocks[n]+1;
            }
          }
        }
      }
    }
    for(int i : blocks){
      out.println(i);
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
  void main(String[]args){usacoRut t=new usacoRut();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
