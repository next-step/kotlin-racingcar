package study.racinggame.util // ktlint-disable filename

fun repeat(n: Int, action: () -> Unit) {
    require(n >= 0) { "Count 'n' must be non-negative, but was $n." }

    for (i in 0 until n) {
        action()
    }
}
