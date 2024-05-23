
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoCensor
 * Date       = Sat May 18 13:17:08 PDT 2024
 */
public class usacoCensor {

  static class Node {
    char val;
    Node prev,next;
    Node(char val){
      this.val=val;
    }
  }

  Node head;
  char[] t;

  public void run() {
    String s = in.next();
    t = in.next().toCharArray();
    Node curr = head = new Node(s.charAt(0));
    for(int i = 1; i < s.length(); ++i){
      Node prev = curr;
      curr = new Node(s.charAt(i));
      prev.next = curr;
      curr.prev = prev;
    }
    print();
  }

  void print(){
    Node curr = head;
    StringBuilder sb = new StringBuilder();
    while(curr != null){
      sb.append(curr.val);
      curr=curr.next;
    }
    out.println(sb);
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
  void main(String[]args){usacoCensor t=new usacoCensor();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "censor";
}
