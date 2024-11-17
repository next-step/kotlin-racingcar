package stringCalculator

enum class Operator(
    val operator: String,
    val apply: (leftValue: Int, rightValue: Int) -> Int,
) {
    PLUS(
        "+",
        { leftValue, rightValue -> leftValue + rightValue },
    ),
    SUBTRACT(
        "-",
        { leftValue, rightValue -> leftValue - rightValue },
    ),

    MULTIPLE(
        "*",
        { leftValue, rightValue -> leftValue * rightValue },
    ),

    DIVIDE(
        "/",
        { leftValue, rightValue -> leftValue / rightValue },
    ), ;

    companion object {
        fun findByOperator(str: String): Operator {
            val result = entries.firstOrNull { it.operator == str }
            return requireNotNull(result) { "올바른 연산자가 아닙니다." }
        }
    }
}
