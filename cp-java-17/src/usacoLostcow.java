
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoLostcow
 * Date       = Mon May  6 23:11:59 PDT 2024
 */
public class usacoLostcow {

    /**
       ----x---- 0
       -----x--- 1
       ---x----- 2
       -------x- 4
       x-------- 7

     */
    public void run() {
        int x = in.nextInt();
        int y = in.nextInt();
        if (x==y){
            out.println(0);
            return;
        }
        int pos = x;
        int prev = 0;
        int step = 1;
        boolean dir = true;
        int travel = 0;
        while(pos!=y){
            prev=pos;
            if(dir) {
                pos=x+step;
                if(prev < y && y < pos)
                    pos=y;
            } else {
                pos=x-step;
                if (pos < y && y < prev)
                    pos=y;
            }
            travel+=Math.abs(prev-pos);
            step*=2;
            dir=!dir;
        }
        out.println(travel);
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
    void main(String[]args){usacoLostcow t=new usacoLostcow();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////////
    static String file = "lostcow";
}
