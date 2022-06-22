import java.io.*;
import java.util.*;

public class subpro3
{
    static PrintWriter fileout;

    public static void main( String args[] ) throws IOException
    {
        fileout = new PrintWriter( new FileWriter("resul.txt") );
        String fecha1 = (new Date()).toString() ;
        fileout.println( "Hola que tal." + fecha1 );
        System.out.println( "Hola que tal." + fecha1 );

        fileout.println( "Hola que tal." + args[0]);

        for( int d = 0; d < 60000; d++)
        {  for( int f = 0; f < 60000; f++);
        }

        String fecha2 = (new Date()).toString() ;
        fileout.println( "Hasta luego."  + fecha2 );
        fileout.close();
        System.out.println( "Hasta luego."  + fecha2 );

        System.exit(17);
    }
}
