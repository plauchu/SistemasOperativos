import java.io.*;

public class pa3x1
{
    public static void main (String args[])
        throws InterruptedException, IOException
    {
        Runtime rt = Runtime.getRuntime();
        Process pro1 = rt.exec(args);
        int y = -20;
        boolean b = true;
        while(b)
        {	System.out.println("Ya termino");
        	try
        	{
                //OTRAS ACTIVIDADES ....

                y = pro1.exitValue();
                b = false;
        	}
        	catch(IllegalThreadStateException e)
        	{   System.out.println("No ha terminado aun");
                b=true;
        	}
        }
        System.out.println("--YA TERMINO--");
        System.out.println("y= " + y);

        for(int j=0; j<args.length ; j++)
            System.out.println("Comando emitido: "+
                            args[j]);

        //IllegalThreadStateException
    }
}