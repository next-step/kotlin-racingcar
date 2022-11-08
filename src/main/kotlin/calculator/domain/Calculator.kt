package calculator.domain

class Calculator(private val inputs: List<String>) {

    init {
        require(inputs.size % 2 == 1) { "올바르지 않은 식입니다" }
    }

    fun execute(): Double {
        var total = Operand.from(inputs[0]).number

        for (i in 1 until inputs.size step 2) {
            val operation = Operator.from(inputs[i])
            val operand = Operand.from(inputs[i + 1])

            total = operation.apply(total, operand.number)
        }

        return total
    }
}
