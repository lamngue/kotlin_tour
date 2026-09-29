data class ProductInfo(val priceInDollars: Double?)

class Product {
    fun getProductInfo(): ProductInfo? {
        return ProductInfo(100.0)
    }
}

// Rewrite this function
fun Product.getPriceInEuros(): Double? {
    val productInfo = this.getProductInfo()
    return productInfo?.priceInDollars?.let { convertToEuros(it) }
}

fun convertToEuros(dollars: Double): Double {
    return dollars * 0.85
}

fun updateEmail(user: User, newEmail: String): User =
    user.apply {
        this.email = newEmail
    }.also {
        println("Updating email for user with ID: ${this.id}")
    }


fun main() {
    val product = Product()
    val priceInEuros = product.getPriceInEuros()

    if (priceInEuros != null) {
        println("Price in Euros: €$priceInEuros")
        // Price in Euros: €85.0
    } else {
        println("Price information is not available.")
    }
    
    val user = User(1, "old_email@example.com")
    val updatedUser = updateEmail(user, "new_email@example.com")
    // Updating email for user with ID: 1

    println("Updated User: $updatedUser")
    // Updated User: User(id=1, email=new_email@example.com)
}