import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.SQLTimeoutException



object Database {
    private const val URL = "jdbc:h2:./default"
    private const val USER = "user"
    private const val PASSWORD = "password"
    init {
        try {
            // Asegurarse de que el driver JDBC de MySQL esté disponible
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (e: ClassNotFoundException) {
            e.printStackTrace();
        }
    }


    fun getConnection(): Connection =
        try {
            DriverManager.getConnection(URL, USER, PASSWORD)
        } catch (e: SQLTimeoutException) {
            throw Exception("La conexión ha excedido el tiempo de espera permitido.")
        } catch (e: SQLException) {
            throw Exception("Error de SQL: ${e.message}")
        }
}