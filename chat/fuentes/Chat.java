// Chat.java

/**
 * @author Jean Paul
 *  @author Rodrigo
 */
public class Chat {
    // Punto de entrada al programa
    public static void main(String args[]) {
        Thread threadServidor;
        int numPuertoServidor = 0;

        if (args.length == 0) {
            System.out.println("Utilizacion: java Chat numero_puerto_servidor");
            System.exit(0);
        } else {
            // Convierte el argumento en un numero
            try {
                numPuertoServidor = Integer.valueOf(args[0]).intValue();
            } catch (NumberFormatException e) {
                System.out.println(e);
            }

            // Crea una nueva ventana para hacer chat
            new VentanaChat(numPuertoServidor);

            // Lanza el thread del servidor que atendera las llamadas entrantes
            threadServidor = new Thread(new HiloServidor(
                    numPuertoServidor));
            threadServidor.start();
        }
    }
}