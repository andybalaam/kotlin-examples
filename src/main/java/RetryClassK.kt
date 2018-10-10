sealed class Response(val code: Long);
class Ok : Response(0)
class FatalError(code: Long) : Response(code)
class FastError(code: Long) : Response(code)
class SlowError(code: Long) : Response(code)

fun whenToRetry(
    now: Long, code: Response, tries: Int
): Long? {
    return when (code) {
        is SlowError -> now + (ONE_HOUR * tries)
        is FastError -> now + ONE_MINUTE
        is FatalError -> null
        is Ok -> null
    }
}
