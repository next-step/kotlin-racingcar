package caculator

enum class Operator(val operator: String, val calculate: (Int, Int) -> Int) {
    ADDITION("+", { x, y -> x + y }),
    SUBSTRACTION("-", { x, y -> x - y }),
    MULTIPLICATION("*", { x, y -> x * y }),
    DIVISION("/", { x, y ->
        require(y != 0) { "0으로 나눌 수 없음." }
        x / y
    });

    companion object {
        fun pickOperation(operator: String): Operator {
            return when (operator) {
                "+" -> ADDITION
                "-" -> SUBSTRACTION
                "*" -> MULTIPLICATION
                "/" -> DIVISION
                else -> throw IllegalArgumentException("사칙연산 기호가 아님.")
            }
        }
    }
}
