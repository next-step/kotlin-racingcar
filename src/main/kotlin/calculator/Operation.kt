package calculator

enum class Operation(
    val symbol: String,
    val operate: (Int, Int) -> Int
) {
    PLUS("+", { a, b -> a.plus(b) }),
    MINUS("-", { a, b -> a.minus(b) }),
    MULTIPLE("*", { a, b -> a.times(b) }),
    DIVIDE("/", { a, b -> a.div(b) });

    companion object {
        fun of(inputSymbol: String): Operation {
            return values().find { operation -> operation.symbol == inputSymbol }
                ?: throw IllegalArgumentException("사칙연산 기호가 아니에요. $inputSymbol")
        }
    }
}
