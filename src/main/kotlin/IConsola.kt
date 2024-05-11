
/**
 * Interfaz que define un método para mostrar mensajes en la consola.
 */
interface IConsola {

    /**
     * Muestra un mensaje en la consola.
     * @param message El mensaje que se va a mostrar.
     * @param lineBreak Indica si se debe agregar un salto de línea al final del mensaje. Por defecto es true.
     */
    fun showMessage(message: String, lineBreak: Boolean = true)

}