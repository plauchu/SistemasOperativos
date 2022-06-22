import java.io.*;

public class MovimientosCliente extends Thread {

   private String clvCliente;
   private String nomCliente;
   private int resultado;

   public MovimientosCliente(String clvCliente2, String nomCliente2) {
      
   }

   public int generaEdo() {
      run();
      return resultado;
   }

   public int getResultado() {
      return resultado;
   }

   public static void main(String[] args) {
      long start = System.currentTimeMillis();
      for (int i = 0; i < 10000000; i++)
         for (int j = 0; i < 10000000; i++)
            for (int k = 0; i < 10000000; i++)
               ;

      BufferedReader filein; // para entrada
      PrintWriter fileout = null; // para salida

      clvCliente = args[0];
      nomCliente = args[1];

      MovimientosCliente t = new MovimientosCliente(clvCliente, nomCliente);
   }

   public void run() {
      long start = System.currentTimeMillis();
      BufferedReader filein; // para entrada
      PrintWriter fileout = null; // para salida
      String linea, nomCliente;
      int clave1, clave2;
      int numOps = 0;
      try {
         clave1 = Integer.parseInt(clvCliente);

         filein = new BufferedReader(new FileReader("movimientos.txt"));

         // Transacciones
         linea = filein.readLine();
         Boolean created = false;
         while (linea != null) {
            if (linea.length() != 0) {
               String[] data = linea.split(" ");
               clave2 = Integer.parseInt(data[0]);

               if (clave1 == clave2) {
                  if (!created) {
                     created = true;
                     fileout = new PrintWriter(new FileWriter("EdoCta" + nomCliente + ".txt"));
                     fileout.println("Clave del cliente: " + clave1);
                  }
                  fileout.println("Medio : " + data[1] + " - Monto: " + data[2]);
                  numOps++;
               }
            }

            linea = filein.readLine();
            if (!created) {
               System.out.println("No existe el cliente con clave " + clave1);
               resultado = -1;
            }
         }
      } catch (Exception ex) {
         System.out.println(ex.toString());
         System.out.println("\nAlgo fallo con algun archivo.\n");
         resultado = -2;
      }
      long end = System.currentTimeMillis();
      long duration = end - start;
      fileout.println("Total de transacciones: " + numOps);
      fileout.println("Tiempo de duración " + duration + " milisegundos");
      fileout.close();
      resultado = 0;
   }

}