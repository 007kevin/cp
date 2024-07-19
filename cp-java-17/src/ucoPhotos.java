
import java.io.*;
import java.util.*;

/**
 * Problem    = ucoPhotos
 * Date       = Thu Jul 11 21:50:13 KST 2024
 */
public class ucoPhotos {

  public void run() {
    int n = in.nextInt();
    int odd=0;
    int even=0;
    for(int i = 0; i < n; ++i){
      int x = in.nextInt();
      if (x%2==0) even++;
      else odd++;
    }
    int ans = Math.min(odd,even);
    odd-=ans;
    even-=ans;
    ans*=2;
    if(odd==0)
      ans+=Math.min(1,even);
    else {
      ans+=(odd/3)*2;
      if (odd%3==1)
        ans--;
      else if (odd%3==2)
        ans++;
    }
    out.println(ans);
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
  void main(String[]args){ucoPhotos t=new ucoPhotos();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
