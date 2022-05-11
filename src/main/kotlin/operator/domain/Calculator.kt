package operator.domain

class Calculator{
    private val operands: ArrayDeque<Operand> = ArrayDeque()
    private val operatorTokens: ArrayDeque<OperatorToken> = ArrayDeque()

    fun calculate(input: String): Double {
        validationEmptyInput(input)
        val inputNotBlank = input.replace(" ", "")
        if (input.length == 1) {
            return input.toDouble()
        }

        parse(inputNotBlank)
        operatorTokens.forEach {
            val operandOne = operands.removeFirst()
            val operandTwo = operands.removeFirst()
            validationDivZero(it, operandTwo)

            operands.addFirst(it.calculate(operandOne, operandTwo))
        }

        return operands.last().num
    }

    private fun parse(input: String) {
        var startSliceIndex = 0

        for (i in input.indices) {
            startSliceIndex = findOperator(input, i, startSliceIndex)
        }
        operands.add(Operand(input.slice(startSliceIndex until input.length).toDouble()))
    }

    private fun findOperator(input: String, index: Int, startSliceIndex: Int): Int {
        var changedStartSliceIndex = startSliceIndex

        if (!input[index].isDigit()) {
            validationContinueOperationToken(changedStartSliceIndex, index)

            operatorTokens.add(OperatorToken.getInstance(input[index].toString()))
            operands.add(Operand(input.slice(changedStartSliceIndex until index).toDouble()))
            changedStartSliceIndex = index + 1
        }
        return changedStartSliceIndex
    }

    private fun validationEmptyInput(input: String) {
        require(input.last().isDigit()) {
            "연산자로 끝날 수 없습니다."
        }
    }

    private fun validationContinueOperationToken(startSliceIndex: Int, i: Int) {
        require(startSliceIndex != i) {
            "연속된 연산자 입니다."
        }
    }

    private fun validationDivZero(operatorToken: OperatorToken, operand: Operand) {
        require(!(operatorToken == OperatorToken.DIV && operand.num == 0.0)) {
            "0으로 나눌 수 없습니다."
        }
    }
}
