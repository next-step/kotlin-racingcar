package study

import java.lang.IllegalArgumentException

class Calculator {
    private val checker: CalculatorChecker = CalculatorChecker()
    fun calculate(input: String?): Int {
        if (!checker.isInputValid(input)) throw IllegalArgumentException()
        val formulaQueue = input!!.split(Regex("\\s+"))

        return operate(formulaQueue)
    }

    private fun operate(formulaQueue: List<String>): Int {
        var result = 0
        var expression = ""
        formulaQueue.forEachIndexed { index, str ->
            if (checker.isEven(index)) {
                if (!checker.isNumber(str)) throw IllegalArgumentException()
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
                if (!checker.isExpression(str)) throw IllegalArgumentException()
                if (index == formulaQueue.size - 1) throw IllegalArgumentException()
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
