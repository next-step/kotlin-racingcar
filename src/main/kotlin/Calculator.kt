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

    fun calc(input: String): Int {
        var result = 0

        val inputWithoutBlank = input.replace(" ", "")

        var tempStr: String = ""
        for (char in inputWithoutBlank) {
            when (char) {
                '+', '-', '*', '/' -> {
                    val applyExpression = selectExpression(char)
                    val num = tempStr.toInt()
                    result = applyExpression(num, result)
                }

                ' ' -> {
                    continue
                }

                else -> {
                    tempStr += char
                }
            }
        }
        return result
    }
}


