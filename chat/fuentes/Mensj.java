// Mensj.java

/**
 * @author Jean Paul
 *  
 */
public class Mensj implements java.io.Serializable {

    String comando;
    String texto;

    boolean correcto;

    /**
     * @param comando Comando asociaso al texto del Mensaje de Chat
     * @param texto Información del mensaje
     */
    public Mensj(String comando, String texto) {
        this.comando = comando;
        this.texto = texto;
    }
}