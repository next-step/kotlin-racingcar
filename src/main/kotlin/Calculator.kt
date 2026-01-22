class Calculator {
    fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun selectExpression(exp: Char): (Int, Int) -> Int {
        when (exp) {
            '+' -> {
                return ::add
            }

            else -> {
                return ::add
            }
        }
    }

    fun calcTwoNums(num1: Int, expression: Char, num2: Int): Int {
        val applyExpression = selectExpression(expression)
        return applyExpression(num1, num2)
    }

    fun calc(input: String): Int {
        var result = 0
        var expression: Char = '+'

        val inputWithoutBlank = input.replace(" ", "")

        var tempStr: String = ""
        for (char in inputWithoutBlank) {
            when (char) {
                '+', '-', '*', '/' -> {
                    val prevNum = tempStr.toInt()
                    result = calcTwoNums(prevNum, expression, result)

                    tempStr = ""
                    expression = char
                }

                ' ' -> {
                    continue
                }

                else -> {
                    tempStr += char
                }
            }
        }
        val prevNum = tempStr.toInt()
        result = calcTwoNums(prevNum, expression, result)

        return result
    }
}


