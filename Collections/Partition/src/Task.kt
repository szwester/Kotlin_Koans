// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> = customers.partition {
    it.orders.count { !it.isDelivered } > (it.orders.size / 2)
}.first.toSet()
