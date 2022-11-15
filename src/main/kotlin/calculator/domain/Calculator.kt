package calculator.domain

class Calculator {
    companion object {
        const val ADDITION = "+"
        const val SUBTRACT = "-"
        const val DIVISION = "/"
        const val MULTIPLICATION = "*"
        const val ROUND = 100
    }

    fun calculate(inputValue: CalculationExpression): Double {
        var operandIndex: Int
        var result = inputValue.operand.getOperandValues(0)
        var calculatorType = makeCalculatorTypeMapper()
        checkLastOperandExist(inputValue)

        for ((operatorIndex, arithmeticOperator) in inputValue.arithmeticOperator.getOperatorsWithIndex()) {
            operandIndex = operatorIndex + 1
            checkDivideToZero(
                arithmeticOperator,
                inputValue.operand.getOperandValues(operandIndex)
            )
            result = calculatorType[arithmeticOperator]?.mathematicalExpression?.let {
                it(
                    result,
                    inputValue.operand.getOperandValues(operandIndex)
                )
            }!!
        }
        return result
    }

    private fun makeCalculatorTypeMapper(): Map<String, CalculatorType> {
        return mapOf(
            ADDITION to CalculatorType.ADDITION, SUBTRACT to CalculatorType.SUBTRACT,
            DIVISION to CalculatorType.DIVISION, MULTIPLICATION to CalculatorType.MULTIPLICATION
        )
    }

    private fun checkLastOperandExist(inputValue: CalculationExpression) {
        try {
            inputValue.operand.operands[inputValue.arithmeticOperator.getOperatorsSize()]
        } catch (e: IndexOutOfBoundsException) {
            // "1 +"와 같이 마지막 피연산자가 없을 경우에 대한 처리
            throw IllegalArgumentException("Empty Operand")
        }
    }

    private fun checkDivideToZero(operator: String, operand: Double) {
        if (operator == DIVISION && operand == 0.0) {
            throw IllegalArgumentException()
        }
    }
}
