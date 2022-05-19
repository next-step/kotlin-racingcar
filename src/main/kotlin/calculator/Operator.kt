package calculator

enum class Operator(val symbol: String, val evaluate: (source: Int, other: Int) -> Int) {
    PLUS("+", { source, other -> source.plus(other) }),
    MINUS("-", { source, other -> source.minus(other) }),
    MULTIPLY("*", { source, other -> source.times(other) }),
    DIVIDE("/", { source, other ->
        if (other == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        source.div(other)
    });

    companion object {
        fun findBy(symbol: String): Operator {
            return values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException("잘못된 사칙연산 기호입니다.")
        }
    }
}
