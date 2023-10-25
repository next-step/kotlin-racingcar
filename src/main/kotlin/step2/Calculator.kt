package step2

import java.lang.IllegalArgumentException

class Calculator {
    private val checker: CalculatorChecker = CalculatorChecker()
    fun calculate(input: Input): Int {
        val formulaList = input.text!!.split(Regex("\\s+"))
        if (!checker.isFormulaValid(formulaList)) throw IllegalArgumentException()

        return operate(formulaList)
    }

    private fun operate(formulaQueue: List<String>): Int {
        var result = 0
        var expression = ""
        formulaQueue.forEachIndexed { index, str ->
            if (checker.isEven(index)) {
                val number = str.toInt()
                result = if (index == 0) {
                    number
                } else {
                    when (expression) {
                        "+" -> result.add(number)
                        "-" -> result.subtract(number)
                        "*" -> result.multiply(number)
                        "/" -> result.divide(number)
                        else -> throw IllegalArgumentException()
                    }
                }
            } else {
                expression = str
            }
        }
        return result
    }

    private fun Int.add(num: Int): Int {
        return this + num
    }

    private fun Int.subtract(num: Int): Int {
        return this - num
    }

    private fun Int.multiply(num: Int): Int {
        return this * num
    }

    private fun Int.divide(num: Int): Int {
        return this / num
    }
}
