package cp;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App
{
    public record Test(String name){}
    public static void main( String[] args )
    {
        Test h = new Test("World");
        System.out.println(h.name());

    }
}
