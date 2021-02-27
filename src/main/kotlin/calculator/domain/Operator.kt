package calculator.domain

enum class Operator(val code: String, val operate: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLE("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        @JvmStatic
        fun of(codetype: String): Operator {
            return values().firstOrNull { it.code == codetype } ?: throw IllegalArgumentException("허용하지 않는 연산자")
        }
    }
}
