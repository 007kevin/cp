
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoBlocks
 * Date       = Sat May 11 10:30:37 PDT 2024
 */
public class usacoBlocks {

  public void run() {
    int n = in.nextInt();
    int[] ans = new int[256];
    for(int i = 0; i < n; ++i){
      int[] a = new int[256];
      int[] b = new int[256];
      for(char c : in.next().toCharArray()) a[c]++;
      for(char c : in.next().toCharArray()) b[c]++;
      for(int j = 0; j < 256; ++j) ans[j]+=Math.max(a[j],b[j]);
    }
    for(int i = 0; i < 26; ++i) out.println(ans['a'+i]);
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
  void main(String[]args){usacoBlocks t=new usacoBlocks();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "blocks";
}
