package calculator.domain

class Calculator(private val tokens: List<String>) {

    init {
        require(tokens.size % 2 == 1) { "올바르지 않은 식입니다" }
    }

    fun execute(): Operand {
        var operand1 = Operand.of(tokens[0])
        for (i in 1 until tokens.size step 2) {
            val calculatorOperator = Operator.of(tokens[i])
            val operand2 = Operand.of(tokens[i + 1])
            operand1 = calculatorOperator.operation(operand1, operand2)
        }
        return operand1
    }
}
