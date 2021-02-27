package study.racingcar.step2

import study.racingcar.step2.operation.AbstractCalculation
import study.racingcar.step2.operation.DivisionCalculation
import study.racingcar.step2.operation.MinusCalculation
import study.racingcar.step2.operation.MultiplicationCalculation
import study.racingcar.step2.operation.PlusCalculation
import java.util.HashMap

class Calculator(private val expression: String) {
    private val COMMON_SPACE = " "
    private val calculationMap: MutableMap<String, AbstractCalculation>

    init {
        calculationMap = HashMap()
        calculationMap["+"] = PlusCalculation()
        calculationMap["-"] = MinusCalculation()
        calculationMap["/"] = DivisionCalculation()
        calculationMap["*"] = MultiplicationCalculation()
    }

    fun calculation(): Int {
        checkEmptyExpression()
        var expressionValues = expression.split(COMMON_SPACE.toRegex()) as MutableList<String>
        return calculation(expressionValues, 0)
    }

    private fun checkEmptyExpression() {
        require(expression.trim().isNotEmpty()) { "expression is empty" }
    }

    private fun calculation(expressionValues: MutableList<String>, index: Int): Int {
        var idx = index
        val leftValue = expressionValues[idx]
        val symbol = expressionValues[++idx]
        val rightValue = expressionValues[++idx]
        val abstractCalculation = calculationMap[symbol]
            ?: throw IllegalArgumentException("Symbol is fault -> $symbol")

        val result = abstractCalculation.calculate(leftValue, rightValue)
        if (expressionValues.size == idx + 1) {
            return result
        }

        expressionValues[idx] = result.toString()
        return calculation(expressionValues, idx)
    }
}
