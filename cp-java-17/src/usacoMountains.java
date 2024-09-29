
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoMountains
 * Date       = Fri Sep 27 15:09:52 PDT 2024
 */
public class usacoMountains {

  static class M implements Comparable<M> {
    long base;
    long height;

    M(long base, long height){
      this.base=base;
      this.height=height;
    }

    @Override
    public int compareTo(M that) {
      if (this.left() == that.left()){
        return (int) (that.height - this.height);
      }
      return (int) (this.left() - that.left());
    }

    long left() {
      return base - height;
    }

    long right() {
      return base + height;
    }

    boolean contains(M that){
      if (this.left() <= that.left() && that.right() <= this.right())
        return true;
      return false;
    }

    @Override
    public String toString() {
      return String.format("{%d, %d, %d}", this.left(), this.base, this.right());
    }
  }

  public void run() {
    int n = in.nextInt();
    var ms = new ArrayList<M>(n);
    for(int i = 0; i < n; ++i)
      ms.add(new M(
          in.nextInt(),
          in.nextInt()));
    Collections.sort(ms);
//    out.println(ms);
    // out.println(ms.get(1).contains(ms.get(2)));
    int cnt = 1;
    int last = 0;
    int curr = 1;
    while(curr < n){
      M lastM = ms.get(last);
      while(curr < n && lastM.contains(ms.get(curr)))
        curr++;
      if (curr!=n){
        cnt++;
        last = curr;
      }
      curr++;
    }
    out.println(cnt);
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
  void main(String[]args){usacoMountains t=new usacoMountains();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "mountains";
}
