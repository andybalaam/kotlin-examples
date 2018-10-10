val urls = mapOf(
    Pair("012", "http://example.com")
)

class EmitterK {

    fun handleMessage(
        receiver: Receiver,
        m: Message
    ) {
        val start: Long
        val end: Long

        // ...

        start = System.currentTimeMillis()
        val url = urls[m.to]

        if (url == null) {
            println("No url!")
            return
        }

        // start += 3; compile error

        // ... url is now known to be non-null

        end = System.currentTimeMillis()
        println(m.id + " took " + (end - start))

        // ...

        val event =
            if (m.customer.contains("Acme")) {
                AcmeEvent(m)
            } else {
                NormalEvent(m)
            }
        receiver.sendEvent(event)

        // ...
    }

    open class Event

    inner class AcmeEvent(m: Message) : Event()

    private inner class NormalEvent(m: Message) : Event()

    interface Receiver {
        fun sendEvent(event: Event)
    }
}
