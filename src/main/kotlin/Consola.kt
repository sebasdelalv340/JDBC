/**
 * Clase que implementa la interfaz IConsola para mostrar mensajes en la consola.
 */

class Consola: IConsola {

    /**
     * Muestra un mensaje en la consola.
     * @param message El mensaje que se va a mostrar.
     * @param lineBreak Indica si se debe agregar un salto de línea al final del mensaje.
     */
    override fun showMessage(message: String, lineBreak: Boolean) {
        if (lineBreak) {
            println(message)
        } else {
            print(message)
        }
    }
}