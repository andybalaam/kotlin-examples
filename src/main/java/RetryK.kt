const val NEVER = -1L
const val ONE_MINUTE = 1000L * 60L
const val ONE_HOUR = ONE_MINUTE * 60L

fun whenToRetry(
    now: Long, code: Int, tries: Int
): Long {
    return when (code) {
        451, 381, 2020 -> now + (ONE_HOUR * tries)
        711, 3010, 1522 -> now + ONE_MINUTE
        2, 815 -> NEVER
        else -> NEVER
    }
}
