fun main() {
    // Declaración la consola.
    val consola = Consola()

    // Declaración del producto que vamos a insertar.
    val product = Producto(2, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")

    // Insertamos el producto en la base de datos.
    val productId = ProductoRepository(consola).agregarProducto(product)

    // Si la operación ha sido exitosa debe imprimirnos el producto agregado.
    println("Product ID: $productId")
}