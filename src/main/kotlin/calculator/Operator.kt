package calculator

enum class Operator(
    val operatorName: String,
    val exec: (Int, Int) -> Int
) {

    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        fun of(symbol: String): Operator {
            return values().find { it.operatorName == symbol }
                ?: throw IllegalArgumentException("사칙연산 기호를 사용하지 않았습니다.")
        }
    }
}
