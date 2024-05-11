/**
 * Interfaz que define las operaciones básicas para un repositorio de productos.
 */
interface IRepo {

    /**
     * Agrega un nuevo producto al repositorio.
     * @param producto El producto que se va a agregar.
     * @return El producto agregado, o null si no se pudo agregar.
     */
    fun agregarProducto(producto: Producto): Producto?
}