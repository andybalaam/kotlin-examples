class RequesterK(val scheme: String, val host: String, val client: HttpClient) {
    constructor(
        user: String, pass: String, host: String, useSsl: Boolean)
    : this(useSsl, host, SimpleClient(user, pass))

    constructor(
        useSsl: Boolean, host: String, client: HttpClient)
    : this(if (useSsl) "https" else "http", host, client)

    interface HttpClient {
        operator fun get(path: String): String
    }

    class SimpleClient(private val user: String, private val pass: String) : HttpClient {
        override fun get(path: String): String {
            return "demo$user$pass"
        }
    }
}
