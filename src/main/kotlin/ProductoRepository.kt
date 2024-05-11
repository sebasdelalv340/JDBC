import java.sql.Connection
import java.sql.SQLException
import java.sql.Statement

class ProductoRepository(
    private val consola: IConsola
): IRepo {
    override fun agregarProducto(producto: Producto): Producto? {

        val sql = "INSERT INTO products (id, name, price, description, brand, category) VALUES (?, ?, ?, ?, ?, ?)"

        try {
            Database.getConnection().use { connection ->
                connection.prepareStatement(sql).use { stmt ->
                    stmt.setInt(1, producto.id)
                    stmt.setString(2, producto.name)
                    stmt.setFloat(3, producto.price)
                    stmt.setString(4, producto.description)
                    stmt.setString(5, producto.brand)
                    stmt.setString(6, producto.category)
                    val rs = stmt.executeUpdate()
                    return if (rs == 1) {
                        connection.commit()
                        producto
                    } else {
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
