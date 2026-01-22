class Calculator {
    companion object {
        const val PLUS = '+'
        const val MINUS = '-'
        const val MULTIPLY = '*'
        const val DIVIDE = '/'
    }


    fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun minus(num1: Int, num2: Int): Int {
        return num1 - num2
    }

    fun multiply(num1: Int, num2: Int): Int {
        return num1 * num2
    }

    fun divide(num1: Int, num2: Int): Int {
        return num1 / num2
    }

    private fun selectExpression(exp: Char): (Int, Int) -> Int {
        when (exp) {
            PLUS -> {
                return ::add
            }

            MINUS -> {
                return this::minus
            }

            MULTIPLY -> {
                return ::multiply
            }

            DIVIDE -> {
                return ::divide
            }

            else -> {
                throw IllegalArgumentException("$PLUS, $MINUS, $MULTIPLY, $DIVIDE 연산자를 사용하세요")
            }
        }
    }

    private fun calcTwoNums(num1: Int, expression: Char, num2: Int): Int {
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


