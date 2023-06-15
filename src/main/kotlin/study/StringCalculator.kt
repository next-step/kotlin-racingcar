package study

class StringCalculator {
    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.")
        }

        val numbersAndOperands = input.split(" ")
        return numbersAndOperands
            .drop(1)
            .chunked(2)
            .fold(numbersAndOperands.first().toInt()) { acc, window ->
                val operator = window[0]
                val right = window[1].toInt()
                calculate(acc, operator, right)
            }
    }

    private fun calculate(left: Int, operator: String, right: Int): Int {
        return when (operator) {
            "+" -> left + right
            "-" -> left - right
            "*" -> left * right
            "/" -> left / right
            else -> throw IllegalArgumentException("${operator}는 지원하지 않는 연산자입니다.")
        }
    }
}
