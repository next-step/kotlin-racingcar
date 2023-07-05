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

enum class Operator(
    private val value: String,
    private val calculator: (Int, Int) -> Int,
) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLY("*", { left, right -> left * right }),
    DIVIDE("/", { left, right -> left / right }),
    ;

    fun calculate(left: Int, right: Int): Int = calculator(left, right)

    companion object {
        fun getOperator(operator: String): Operator {
            return values().find { it.value == operator }
                ?: throw IllegalArgumentException("${operator}는 지원하지 않는 연산자입니다.")
        }
    }
}
