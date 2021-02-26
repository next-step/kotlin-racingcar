package step2.operator

enum class Operator(
    private val token: String,
    private val delegate: Delegate
) {
    PLUS(
        "+",
        object : Delegate {
            override fun operate(x: Int, y: Int) = x + y
        }
    ),
    MINUS(
        "-",
        object : Delegate {
            override fun operate(x: Int, y: Int) = x - y
        }
    ),
    TIMES(
        "*",
        object : Delegate {
            override fun operate(x: Int, y: Int) = x * y
        }
    ),
    DIVIDE(
        "/",
        object : Delegate {
            override fun operate(x: Int, y: Int) = x / y
        }
    );

    fun operate(x: Int, y: Int) = delegate.operate(x, y)

    companion object {
        fun findBy(token: String) = when (token) {
            PLUS.token -> PLUS
            MINUS.token -> MINUS
            TIMES.token -> TIMES
            DIVIDE.token -> DIVIDE
            else -> throw IllegalArgumentException("$token 존재하지 않는 연산자")
        }
    }
}

private interface Delegate {
    fun operate(x: Int, y: Int): Int
}
