// Conex.java

import java.net.*;
import java.io.*;

/**
 * @author Jean Paul
 *  
 */
public class Conex {
    
    Socket socket = null;

   
    InputStream is = null;


    OutputStream os = null;

   
    ObjectOutputStream oos = null;

    ObjectInputStream ois = null;

   
    boolean correcto = false;

    /**
     * @param socketAceptadoPorElServidor 
     */
    public Conex(Socket socketAceptadoPorElServidor) {
        socket = socketAceptadoPorElServidor;
        abrirCanalesDeEntradaYSalida();
    }

    /**
     * @param dirIPRemota Direccion IP del Pc remoto
     * @param numPuertoRemoto Numero del Puerto del PC Remoto
     */
    public Conex(String dirIPRemota, int numPuertoRemoto) {
        try {
            socket = new Socket(dirIPRemota, numPuertoRemoto);
            if (socket == null) {
                socket.close();
            } else {
                abrirCanalesDeEntradaYSalida();
            }
        } catch (IOException e) {
            System.err.println("Error creando socket: " + e);
        }
    }

    /**
     *  
     */
    public void abrirCanalesDeEntradaYSalida() {
        try {
            os = socket.getOutputStream();
            is = socket.getInputStream();
            oos = new ObjectOutputStream(os);
            // OIS se creara al leer por primera vez del stream
            if (oos != null) {
                correcto = true;
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * @return
     */
    public Mensj recibeMensaje() {
        Mensj mensajeRecibido = null;
        try {
            if (ois == null) {
                ois = new ObjectInputStream(is);
            }
            mensajeRecibido = (Mensj) ois.readObject();
        } catch (OptionalDataException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
        return mensajeRecibido;
    }

    /**
     * @param mensajeAEnviar
     */
    public void enviaMensaje(Mensj mensajeAEnviar) {
        try {
            oos.writeObject(mensajeAEnviar);
            oos.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}