
import java.sql.SQLException

/**
 * Clase que implementa la interfaz IRepo para gestionar operaciones de productos en una base de datos.
 * @param consola La consola utilizada para mostrar mensajes de error o información.
 */
class ProductoRepository(
    private val consola: IConsola
): IRepo {

    /**
     * Agrega un nuevo producto al repositorio.
     * @param producto El producto que se va a agregar.
     * @return El producto agregado, o null si no se pudo agregar.
     */override fun agregarProducto(producto: Producto): Producto? {
        // Sentencia SQL para insertar un producto en la base de datos
        val sql = "INSERT INTO products (id, name, price, description, brand, category) VALUES (?, ?, ?, ?, ?, ?)"

        try {
            // Establecer conexión con la base de datos y ejecutar la consulta preparada
            Database.getConnection().use { connection ->
                connection.prepareStatement(sql).use { stmt ->
                    stmt.setInt(1, producto.id)
                    stmt.setString(2, producto.name)
                    stmt.setFloat(3, producto.price)
                    stmt.setString(4, producto.description)
                    stmt.setString(5, producto.brand)
                    stmt.setString(6, producto.category)

                    // Ejecutar la consulta y obtener el número de filas afectadas
                    val rs = stmt.executeUpdate()

                    // Comprobar si la inserción fue exitosa
                    return if (rs == 1) {
                        connection.commit()
                        producto
                    } else {
                        // Mostrar un mensaje de error si la inserción falla
                        consola.showMessage("*Error* insert query failed! ($rs records inserted)")
                        null
                    }
                }
            }
        } catch (e: SQLException) {
            consola.showMessage("*Error* insert query failed! (${e.message})")
            return null
        }
    }

}
