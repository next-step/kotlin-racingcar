package calculator

class StringCalculator {
    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank()) { "null이나 빈 문자열일 수 없습니다." }

        return Expression(input).evaluate()
    }
}
