package calculator

import calculator.view.InputView

class Calculator (private val inputView: InputView){
    fun calculate(): Int {
        val elements = inputView.inputFormula()
        var result = elements[0].toInt()

        for (i in 1 until elements.size step 2) {
            val operator = elements[i]
            val operand = elements[i + 1].toInt()

            result = Operator.from(operator).calculate(result, operand)
        }

        return result
    }
}
