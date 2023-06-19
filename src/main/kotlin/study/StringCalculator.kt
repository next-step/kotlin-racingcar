package study

class StringCalculator {
    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank()) { "입력값이 null이거나 빈 공백 문자입니다." }

        val numbersAndOperands = input.split(" ")
        return numbersAndOperands
            .drop(1)
            .chunked(2)
            .fold(numbersAndOperands.first().toInt()) { acc, window ->
                val operator = Operator.getOperator(window[0])
                val right = window[1].toInt()
                operator.calculate(acc, right)
            }
    }
}

sealed class Operator {
    abstract fun calculate(left: Int, right: Int): Int

    object Plus : Operator() {
        override fun calculate(left: Int, right: Int): Int = left + right
    }

    object Minus : Operator() {
        override fun calculate(left: Int, right: Int): Int = left - right
    }

    object Multiply : Operator() {
        override fun calculate(left: Int, right: Int): Int = left * right
    }

    object Divide : Operator() {
        override fun calculate(left: Int, right: Int): Int = left / right
    }

    companion object {
        fun getOperator(operator: String): Operator {
            return when (operator) {
                "+" -> Plus
                "-" -> Minus
                "*" -> Multiply
                "/" -> Divide
                else -> throw IllegalArgumentException("${operator}는 지원하지 않는 연산자입니다.")
            }
        }
    }
}
