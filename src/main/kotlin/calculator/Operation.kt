package calculator

enum class Operation(val exp: String, val compute: (Int, Int) -> Int) {
    PLUS("+", { v1, v2 -> v1 + v2 }),
    MINUS("-", { v1, v2 -> v1 - v2 }),
    MULTIPLY("*", { v1, v2 -> v1 * v2 }),
    DIVIDE("/", { v1, v2 ->
        if (v2 == 0) throw IllegalArgumentException()
        v1 / v2
    }),
    ;

    companion object {
        fun of(exp: String) = values().first { it.exp == exp }

        fun contains(exp: String): Boolean = of(exp) in values()
    }
}
