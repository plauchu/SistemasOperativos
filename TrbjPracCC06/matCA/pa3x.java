import java.io.*;

public class pa3x
{
    public static void main (String args[])
        throws InterruptedException, IOException
    {
        Runtime rt = Runtime.getRuntime();
        String cmdargs [] = new String [3];
        cmdargs[0] = "java";
        cmdargs[1] = "subpro3";
        cmdargs[2] = "Alla voy 989";
        Process pro1 = rt.exec(cmdargs);
        System.out.println("Comando emitido: "+
                            cmdargs[0]+" "+cmdargs[1]);
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

        //IllegalThreadStateException
    }
}