fun main() {
    val consola = Consola()
    val product = Producto(2, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")

    val productId = ProductoRepository(consola).agregarProducto(product)

    println("Product ID: $productId")
}