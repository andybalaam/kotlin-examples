import java.util.HashMap

private val wordValues = mapOf(
    Pair("purple", 3),
    Pair("lavender", 5),
    Pair("amethyst", 50)
)

class ScorerK {
    val scores = mutableMapOf<String, Int>()

    fun scoreRequest(user: String, path: String) {
        scores.merge(
            user,
            wordValues[path] ?: 0,
            Integer::sum
        )
    }

    fun total(user: String): Int {
        return scores[user] ?: 0
    }
}
