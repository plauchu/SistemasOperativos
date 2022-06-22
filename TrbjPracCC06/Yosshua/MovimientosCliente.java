import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MovimientosCliente extends Thread{

   private Integer clvCliente;
   private String nomCliente;
   private int resultado;

   public MovimientosCliente(String clvCliente, String nomCliente) {
      this.clvCliente = Integer.parseInt(clvCliente);
      this.nomCliente = nomCliente;
      this.resultado = -2;
   }   

   public int getResultado(){
      return resultado;
   }

   @Override
    public void run() {
      long start = System.currentTimeMillis();
      BufferedReader filein; // para entrada
      PrintWriter fileout = null; // para salida
      String linea;
      int clave1, clave2;
      int numOps = 0;
      try {
         clave1 = clvCliente;

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
            
         }
         if (!created) {
            System.out.println("No existe el cliente con clave " + clave1);
            resultado = -1;
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