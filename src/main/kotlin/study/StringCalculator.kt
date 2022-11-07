package study

class StringCalculator(private val stringNumbers: StringNumbers, private val operators: Operators) {

    fun calculate(): Long {
        validateListSize()
        while (operators.isNotEmpty()) {
            val first: StringNumber = stringNumbers.removeFirst()
            val operator: Operator = operators.removeFirst()
            val second: StringNumber = stringNumbers.removeFirst()
            val result: Long = operator.calculate(first, second)
            stringNumbers.addFirst(StringNumber(result))
        }
        return stringNumbers.first().longValue()
    }

    private fun validateListSize() {
        if (stringNumbers.size() != operators.size() + 1) {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }
}
