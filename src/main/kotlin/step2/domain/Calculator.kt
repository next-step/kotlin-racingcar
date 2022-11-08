package step2.domain

enum class Calculator(val operator: String, val operation: (Operand, Operand) -> Int) {
    PLUS("+", { operand1, operand2 -> operand1.value + operand2.value }),
    MINUS("-", { operand1, operand2 -> operand1.value - operand2.value }),
    MULTIPLY("*", { operand1, operand2 -> operand1.value * operand2.value }),
    DIVIDE("/", { operand1, operand2 -> operand1.value / operand2.value });

    companion object {
        private fun findCalculator(operator: String): Calculator {
            return values().find { it.operator == operator }
                ?: throw IllegalArgumentException("연산자가 올바르지 않습니다.")
        }

        fun calculate(operator: String, operand1: Int, operand2: Int): Int {
            return findCalculator(operator).operation(Operand(operand1), Operand(operand2))
        }
    }
}
