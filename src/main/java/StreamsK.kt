val hotDrinks = listOf("tea", "coffee")

class StreamsK(
    private vararg val customers: Customer
) {
    class Customer(val name: String, val drink: String)

    fun hotCustomers(): List<String> {
        return customers
            .filter {
                cust -> hotDrinks.any {
                    cust.drink.contains(it)
                }
            }
            .map {it.name} // or .map(Customer::name)
    }
}
