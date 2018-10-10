public class Message {
    final String id;
    final String customer;
    final String to;
    final String from;
    final String body;

    public Message(
        String id,
        String customer,
        String to,
        String from,
        String body
    ) {
        this.id = id;
        this.customer = customer;
        this.to = to;
        this.from = from;
        this.body = body;
    }

    public Message(String id) {
        this(id, null, null, null, null);
    }

    public Message forCustomer(String customer) {
        return new Message(id, customer, to, from, body);
    }

    public Message withTo(String to) {
        return new Message(id, customer, to, from, body);
    }

    public Message withFrom(String from) {
        return new Message(id, customer, to, from, body);
    }
}
