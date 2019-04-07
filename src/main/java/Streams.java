import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static class Customer {
        private final String name;
        private final String drink;
        public Customer(String name, String drink) {
            this.name = name;
            this.drink = drink;
        }

        public String getName() {
            return name;
        }
    }

    static final List<String> hotDrinks =
        Arrays.asList("tea", "coffee");

    final List<Customer> customers;

    Streams(Customer... customers) {
        this.customers = Arrays.asList(customers);
    }

    public List<String> hotCustomers() {
        return customers.stream()
            .filter(
                cust -> hotDrinks.stream().anyMatch(
                    drink -> cust.drink.contains(drink)
                )
            )
            .map(Customer::getName)
            .collect(Collectors.toList());
    }
}
