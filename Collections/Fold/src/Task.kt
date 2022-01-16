// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {

    val setOfAll = customers.flatMap { it.orders }.flatMap { it.products }.toSet()
    return customers.fold(setOfAll) { acc, customer -> acc.intersect(customer.getOrderedProducts().toSet()) }
}

fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap { it.products }