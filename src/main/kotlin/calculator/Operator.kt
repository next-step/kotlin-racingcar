package calculator

enum class Operator(private val symbol: String, val evaluate: (augend: Float, addend: Float) -> Float) {
    PLUS("+", { augend, addend -> augend + addend }),
    MINUS("-", { augend, addend -> augend - addend }),
    MULTIPLE("*", { augend, addend -> augend * addend }),
    DIVIDE("/", { augend, addend -> augend / addend });

    companion object {
        fun find(symbol: String): Operator {
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException("유효하지 않은 연산자 입니다.")
        }
    }
}
