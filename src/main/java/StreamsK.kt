val britishDrinks = listOf("tea", "squash")

class StreamsK(
    private vararg val customers: Customer
) {
    class Customer(val name: String, val drink: String)

    fun britishCustomers(): List<String> {
        return customers
            .filter {
                cust -> britishDrinks.any {
                    cust.drink.contains(it)
                }
            }
            .map {it.name} // or .map(Customer::name)
    }
}
