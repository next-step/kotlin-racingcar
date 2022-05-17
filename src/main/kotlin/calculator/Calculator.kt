package calculator

import java.lang.IllegalArgumentException

class Calculator {

    fun calculate(value: String): CalculatorNumber {
        require(value.isNotBlank())
        val pair = partitionValue(value = value)
        val calculatorNumbers = pair.first.map { CalculatorNumber.from(value = it.value) }
        val operators = pair.second.map { Operator.findBySign(sign = it.value) }
        validateSize(calculatorNumbers = calculatorNumbers, operators = operators)

        return calculateNumbers(calculatorNumbers = calculatorNumbers, operators = operators)
    }

    private fun partitionValue(value: String) = value.split(REGEX)
        .withIndex()
        .partition { isNumberIndex(it.index) }

    private fun isNumberIndex(value: Int) = value % 2 == 0

    private fun validateSize(calculatorNumbers: List<CalculatorNumber>, operators: List<Operator>) {
        if (calculatorNumbers.size - 1 != operators.size) {
            throw IllegalArgumentException("입력된 수식이 올바르지 않습니다.")
        }
    }

    private fun calculateNumbers(
        calculatorNumbers: List<CalculatorNumber>,
        operators: List<Operator>
    ): CalculatorNumber {
        var calculateValue = calculatorNumbers[0]

        for (i in 1 until calculatorNumbers.size) {
            calculateValue = operators[i - 1].calculate(calculateValue, calculatorNumbers[i])
        }

        return calculateValue
    }

    companion object {
        private const val REGEX = " "
    }
}
