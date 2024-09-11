
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoSquare
 * Date       = Wed Sep  4 22:02:38 PDT 2024
 */
public class usacoSquare {

  static class Rectangle {
    int x1,y1,x2,y2;
    public Rectangle(int x1, int y1, int x2, int y2) {
      this.x1=x1;
      this.y1=y1;
      this.x2=x2;
      this.y2=y2;
    }
    int square(Rectangle that){
      int w = Math.max(this.x2, that.x2) - Math.min(this.x1, that.x1);
      int l = Math.max(this.y2, that.y2) - Math.min(this.y1, that.y1);
      return Math.max(w,l);
    }
  }

  public void run() {
    var r1 = new Rectangle(
        in.nextInt(),
        in.nextInt(),
        in.nextInt(),
        in.nextInt());
    var r2 = new Rectangle(
        in.nextInt(),
        in.nextInt(),
        in.nextInt(),
        in.nextInt());
    var s = r1.square(r2);
    out.println(s*s);
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
  void main(String[]args){usacoSquare t=new usacoSquare();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "square";
}
