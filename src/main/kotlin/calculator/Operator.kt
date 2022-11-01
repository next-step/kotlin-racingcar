package calculator

enum class Operator(
    val operator: String,
    val calculate: (Int, Int) -> Int
) {

    PLUS("+", { currentOperand, nextOperand -> currentOperand + nextOperand }),
    MINUS("-", { currentOperand, nextOperand -> currentOperand - nextOperand }),
    MULTIPLE("*", { currentOperand, nextOperand -> currentOperand * nextOperand }),
    DIVIDE("/", { currentOperand, nextOperand -> currentOperand / nextOperand });

    companion object {
        fun of(input: String): Operator = values().find { operator: Operator ->
            operator.operator == input
        } ?: throw IllegalArgumentException("연산자가 아닙니다.")
    }

}