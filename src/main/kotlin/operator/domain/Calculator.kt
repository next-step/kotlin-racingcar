package operator.domain

class Calculator {
    private val operands = ArrayDeque<Operand>()
    private val operatorTokens = ArrayDeque<OperatorToken>()

    fun calculate(input: String): Double {
        if (input.length == 1) {
            return input.toDouble()
        }
        val inputNotBlank = input.replace(" ", "")

        parse(inputNotBlank)
        operatorTokens.forEach {
            val operandOne = operands.removeFirst()
            val operandTwo = operands.removeFirst()

            operands.addFirst(it.calculate(operandOne, operandTwo))
        }

        return operands.last().num
    }

    private fun parse(input: String) {
        var startSliceIndex = 0

        for (i in input.indices) {
            if (!input[i].isDigit()) {
                validationInput(startSliceIndex, i)

                operatorTokens.add(OperatorToken.getInstance(input[i].toString()))
                operands.add(Operand(input.slice(startSliceIndex until i).toDouble()))
                startSliceIndex = i + 1
            }
        }

        operands.add(Operand(input.slice(startSliceIndex until input.length).toDouble()))
    }

    private fun validationInput(startSliceIndex: Int, i: Int) {
        if (startSliceIndex == i) {
            throw IllegalArgumentException("잘못된 인풋값입니다.")
        }
    }
}
