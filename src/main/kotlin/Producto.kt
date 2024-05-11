
/**
 * Clase de datos que representa un producto.
 * @property id El identificador único del producto.
 * @property name El nombre del producto.
 * @property price El precio del producto.
 * @property description La descripción del producto.
 * @property brand La marca del producto.
 * @property category La categoría del producto.
 */
data class Producto(
    val id: Int,
    val name: String,
    val price: Float,
    val description: String,
    val brand: String,
    val category: String
)
