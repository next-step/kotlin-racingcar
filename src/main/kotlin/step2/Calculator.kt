package step2

class Calculator {

    fun calculate(string: String): Int {

        val splitString = CalculatorUtil.validateAndReturn(string)

        var result = splitString[0].toInt()

        for (i in 0..splitString.lastIndex step 2) {
            if (i + 2 > splitString.lastIndex) break
            result = calc(operator = splitString[i + 1], num1 = result, num2 = splitString[i + 2].toInt())
        }

        return result
    }

    private fun calc(operator: String, num1: Int, num2: Int): Int {
        if (operator == "+") return num1.plus(num2)
        if (operator == "-") return num1.minus(num2)
        if (operator == "*") return num1.times(num2)
        return num1.div(num2)
    }
}
