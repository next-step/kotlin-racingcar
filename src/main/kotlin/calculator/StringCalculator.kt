package calculator

class StringCalculator {
    fun calculate(arithmeticExpression: String): Float {
        if (arithmeticExpression.isBlank()) {
            throw IllegalArgumentException("문자열이 비어있습니다.")
        }

        val splitedExpression = splitByBlank(arithmeticExpression)
        val numbers = splitedExpression.filter { isNumber(it) }
        val arithmeticSymbols = splitedExpression.filter { isOperator(it) }

        validate(splitedExpression, numbers, arithmeticSymbols)

        val result = numbers.map { it.toFloat() }
            .toTypedArray()
            .reduceIndexed { index, acc, s ->
                doCalculate(acc, s, arithmeticSymbols[index - 1])
            }

        println(result)
        return result
    }

    private fun validate(splitedExpression: List<String>, numbers: List<String>, arithmeticSymbols: List<String>) {
        if (splitedExpression.size != numbers.size + arithmeticSymbols.size) {
            throw IllegalArgumentException("숫자와 기호외의 문자가 포함되었습니다.")
        }

        if (numbers.size != arithmeticSymbols.size + 1) {
            throw IllegalArgumentException("숫자는 기호보다 1개 많아야 합니다.")
        }
    }

    private fun splitByBlank(arithmeticExpression: String): List<String> {
        return arithmeticExpression.split(Regex(" +"))
    }

    private fun isNumber(input: String): Boolean {
        return Regex("\\d+(\\.\\d+)?").matches(input)
    }

    private fun isOperator(input: String): Boolean {
        return input == "+" || input == "-" || input == "*" || input == "/"
    }

    private fun doCalculate(num1: Float, num2: Float, operator: String): Float {
        return when (operator) {
            "+" -> add(num1, num2)
            "-" -> subtract(num1, num2)
            "*" -> multiply(num1, num2)
            "/" -> divide(num1, num2)
            else -> throw IllegalArgumentException("기호가 올바르지 않습니다.")
        }
    }

    fun add(num1: Float, num2: Float) = num1 + num2

    fun subtract(num1: Float, num2: Float) = num1 - num2

    fun multiply(num1: Float, num2: Float) = num1 * num2

    fun divide(num1: Float, num2: Float): Float {
        if (num2 == 0F) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }

        return num1 / num2
    }
}
