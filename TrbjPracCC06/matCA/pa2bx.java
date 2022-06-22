import java.io.*;

public class pa2bx
{
    public static void main (String args[])
        throws InterruptedException, IOException
    {
        Runtime rt = Runtime.getRuntime();
        String cmdargs [] = new String [2];
        cmdargs[0] = "java";
        cmdargs[1] = "subpro2";
        Process pro1 = rt.exec(cmdargs);
        System.out.println("Comando emitido: "+
                            cmdargs[0]+" "+cmdargs[1]);
		
		int cont=0;
		int y= -20;
        boolean b = false;
        while(!b)
        {	System.out.println("¿Ya terminó?");
        	try
        	{
                //OTRAS ACTIVIDADES ....
                y = pro1.exitValue();
				System.out.println("YA TERMINó");
                b = true;
        	}
        	catch(IllegalThreadStateException e)
        	{	System.out.println("No ha terminado aún.");
                //OTRAS ACTIVIDADES ....
				cont++;
			}
        }
        System.out.println("y= " + y);
        System.out.println("cont= " + cont);

        //IllegalThreadStateException
    }
	
	/*
		int cont=0;
        boolean b = false;
        while(!b)
        {	System.out.println("¿Ya terminó?");
        	try
        	{
                //OTRAS ACTIVIDADES ....
                y = pro1.exitValue();
				System.out.println("YA TERMINó");
                b = true;
        	}
        	catch(IllegalThreadStateException e)
        	{	System.out.println("No ha terminado aún.");
                //OTRAS ACTIVIDADES ....
				cont++;
			}
        }
        System.out.println("y= " + y);
        System.out.println("cont= " + cont);

	*/
}