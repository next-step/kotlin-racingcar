package domain

import kotlin.math.round

class Calculator {
    companion object {
        const val ADDITION = "+"
        const val SUBTRACT = "-"
        const val DIVISION = "/"
        const val MULTIPLICATION = "*"
        const val ROUND = 100
    }

    enum class CalculatorType(val expression: (Double, Double) -> Double) {
        ADDITION({ a, b -> round((a + b) * ROUND) / ROUND }),
        SUBTRACT({ a, b -> round((a - b) * ROUND) / ROUND }),
        DIVISION({ a, b -> round((a / b) * ROUND) / ROUND }),
        MULTIPLICATION({ a, b -> round((a * b) * ROUND) / ROUND });
    }

    fun calculate(inputData: CalculationExpression): Double {
        var operandIndex: Int
        var result = inputData.operand.operandList[0]
        val calculatorTypeMapping = mutableMapOf<String?, CalculatorType>()

        makeCalculatorTypeMapper(calculatorTypeMapping)
        checkLastOperandExist(inputData)

        for (operatorIndex in 0 until inputData.operator.operatorList.size) {
            operandIndex = operatorIndex + 1
            checkDivideToZero(
                inputData.operator.operatorList[operatorIndex],
                inputData.operand.operandList[operandIndex]
            )
            result = calculatorTypeMapping[inputData.operator.operatorList[operatorIndex]]?.expression?.let {
                it(
                    result,
                    inputData.operand.operandList[operandIndex]
                )
            }!!
        }
        return result
    }

    private fun makeCalculatorTypeMapper(calculatorTypeMapper: MutableMap<String?, CalculatorType>) {
        calculatorTypeMapper[ADDITION] = CalculatorType.ADDITION
        calculatorTypeMapper[SUBTRACT] = CalculatorType.SUBTRACT
        calculatorTypeMapper[DIVISION] = CalculatorType.DIVISION
        calculatorTypeMapper[MULTIPLICATION] = CalculatorType.MULTIPLICATION
    }

    private fun checkLastOperandExist(inputData: CalculationExpression) {
        try {
            inputData.operand.operandList[inputData.operator.operatorList.size]
        } catch (e: IndexOutOfBoundsException) {
            // "1 +"와 같이 마지막 피연산자가 없을 경우에 대한 처리
            throw IllegalArgumentException("Empty Operand")
        }
    }

    private fun checkDivideToZero(operator: String?, operand: Double) {
        if (operator == DIVISION && operand == 0.0) {
            throw IllegalArgumentException()
        }
    }
}
