package study.racingcar.step2

import study.racingcar.step2.operation.AbstractCalculation
import study.racingcar.step2.operation.DivisionCalculation
import study.racingcar.step2.operation.MinusCalculation
import study.racingcar.step2.operation.MultiplicationCalculation
import study.racingcar.step2.operation.PlusCalculation
import java.util.HashMap

class Calculator {
    private val COMMON_SPACE = " "
    private val calculationMap: MutableMap<String, AbstractCalculation>
    private var expression: String? = null
    private lateinit var expressionValues: Array<String>

    init {
        calculationMap = HashMap()
        calculationMap["+"] = PlusCalculation()
        calculationMap["-"] = MinusCalculation()
        calculationMap["/"] = DivisionCalculation()
        calculationMap["*"] = MultiplicationCalculation()
    }

    fun expression(expression: String): Calculator {
        this.expression = expression
        checkEmptyExpression()
        return this
    }

    fun calculation(): Int {
        checkEmptyExpression()
        expressionValues = expression!!.split(COMMON_SPACE.toRegex()).toTypedArray()
        return calculation(0)
    }

    private fun checkEmptyExpression() {
        require(!(expression == null || expression!!.length == 0)) {
            throw IllegalArgumentException("expression is empty")
        }
    }

    private fun calculation(index: Int): Int {
        var index = index
        val leftValue = expressionValues[index]
        val symbol = expressionValues[++index]
        val rightValue = expressionValues[++index]
        val abstractCalculation = calculationMap[symbol]
            ?: throw IllegalArgumentException("Symbol is fault -> $symbol")

        val result = abstractCalculation.calculate(leftValue, rightValue)
        if (expressionValues.size == index + 1) {
            return result
        }

        expressionValues[index] = result.toString()
        return calculation(index)
    }
}
