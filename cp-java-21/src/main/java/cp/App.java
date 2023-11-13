package cp;

/**
 * Hello world!
 *
 */
public class App
{
    public record Hello(String name){}
    public static void main( String[] args )
    {
        Hello h = new Hello("World");
        System.out.println(h.name());
    }
}
