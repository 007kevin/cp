
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1889a
 * Date       = Thu Nov 16 22:12:52 PST 2023
 */
public class cf1889a {

    static char[] buf = new char[1000];

    public void run() {
        int t = in.nextInt();
        while(t-->0) solve();
    }

    public void solve() {
        int n = in.nextInt();
        char[] s = in.next().toCharArray();
        if(!valid(s)){
            out.println(-1);
            return;
        }
        Deque<Character> ll = new LinkedList<>();
        List<Integer> x = new LinkedList<>();
        for(char c : s) ll.add(c);
        int i = 0, j = n;
        while(!ll.isEmpty() && ll.size() <= 300){
            char a = ll.getFirst();
            char b = ll.getLast();
            if (a != b){
                i++;
                j--;
                ll.removeFirst(); ll.removeLast();
            } else {
                if (a == '0'){
                    ll.addLast('0');
                    ll.addLast('1');
                    x.add(j);
                    j+=2;
                } else {
                    ll.addFirst('1');
                    ll.addFirst('0');
                    x.add(i);
                    j+=2;
                }
            }
        }
        if (x.size() > 300){
            out.println(-1);
            return;
        }
        out.println(x.size());
        for(int y : x)
            out.print(y + " ");
        out.println();
    }

    public boolean valid(char[] s){
        int o=0,z=0;
        for(char c : s)
            if (c=='0') z++;
            else o++;
        return o==z;
    }

    /////////////////////////////////////////////////////////////////////////////
    IR in=new IR(System.in);PrintWriter out=new PrintWriter(System.out);void c(){
    out.close();}static class IR {BufferedReader r; StringTokenizer t= null; IR (
    InputStream s){r=new BufferedReader(new InputStreamReader(s), 32768);}boolean
    p(){while(t==null||!t.hasMoreTokens()){try{String l=r. readLine();if(l==null)
    return false; t = new StringTokenizer(l); } catch (IOException e) { throw new
    RuntimeException(e);}}return true;}boolean hasNext(){return p();}String next(
    ){ p();return t.nextToken();}int nextInt() {return Integer.parseInt(next());}
    long nextLong() { return Long.parseLong(next());} double nextDouble(){ return
    Double.parseDouble( next() ); } } public static void main ( String[ ]args ) {
    cf1889a t=new cf1889a();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
