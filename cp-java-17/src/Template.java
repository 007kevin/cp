
import java.io.*;
import java.util.*;

/**
 * Problem    = Template
 * Date       = INSERT_DATE
 */
public class Template {

    public void run() {

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
    void main(String[]args){Template t=new Template();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////////
    static String file;
}
