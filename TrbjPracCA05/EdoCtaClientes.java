import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EdoCtaClientes {
    public static void main(String args[])
            throws IOException {
        BufferedReader filein = null; // para entrada
        String cmdargs[] = new String[4];
        Process proc[] = new Process[10];
        int i, totProc;
        String linea, nomCliente, clvCliente;

        long time = System.currentTimeMillis();
        String p[] = new String[10];

        // Arranque de todos los procesos, uno por uno
        i = 0;
        try {
            filein = new BufferedReader(new FileReader("clientes.txt"));
            linea = filein.readLine();
            while (linea != null) {
                if (linea.length() != 0) {
                    String[] componentes = linea.split(" ");
                    clvCliente = componentes[0];
                    nomCliente = componentes[1];

                    cmdargs[0] = "java";
                    cmdargs[1] = "MovimientosCliente";
                    cmdargs[2] = clvCliente;
                    cmdargs[3] = nomCliente;

                    ProcessBuilder pb = new ProcessBuilder(cmdargs);
                    proc[i] = pb.start();
                    p[i] = nomCliente;

                    i++;
                }
                linea = filein.readLine();
            }
        } catch (Exception e) {
            System.out.println("Algo fallo: " + e.getMessage() + " error " + e.toString());
            filein.close();
            System.exit(2);
        }
        filein.close();
        totProc = i;

        // A esperar por todos los procesos hijos
        int terminaron = 0;
        boolean y, noHanTerm;
        boolean terminado[] = new boolean[totProc];
        List<String> noCreo = new ArrayList<String>();
        for (int k = 0; i < terminado.length; k++) {
            terminado[k] = false;
        }
        noHanTerm = true;
        while (terminaron < totProc) {
            i = 0;
            while (i < totProc) {
                try {
                    if (!terminado[i]) {
                        y = proc[i].isAlive();
                        terminado[i] = true;
                        terminaron++;
                        if (y) {
                            int exitCode = proc[i].getResultado();
                            if (exitCode == 0) {
                                System.out.println("--YA TERMINO--: " + i);
                                System.out.println("exit code= " + y);
                            } else if (exitCode == -1) {
                                noCreo.add(p[i]);

                            } else {
                                System.out.println("Hubo algun error: " + p[i]);
                            }

                        } else {
                            System.out.println("No ha terminado: " + p[i]);
                        }
                    }

                } catch (IllegalThreadStateException e) {
                    System.out.println("Falta algun proceso por terminar.");
                }
                i++;
            }
        }
        long finaltime = System.currentTimeMillis() - time;
        System.out.println("Tiempo total: " + finaltime + " ms");
        for (String nom : noCreo) {
            System.out.println("No se creo el de: " + nom);
        }
    }
}