package study

enum class Operator(val description: String) {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    companion object {
        private val map = values().associateBy(Operator::description)
        fun fromDescription(type: String?): Operator = map[type] ?: throw IllegalArgumentException("존재하지 않는 연산자입니다.")
    }

    fun calculate(first: StringNumber, second: StringNumber): Long {
        return when (this) {
            PLUS -> plus(first, second)
            MINUS -> minus(first, second)
            DIVIDE -> divide(first, second)
            MULTIPLY -> multiply(first, second)
        }
    }

    private fun plus(first: StringNumber, second: StringNumber): Long {
        return first.longValue() + second.longValue()
    }

    private fun minus(first: StringNumber, second: StringNumber): Long {
        return first.longValue() - second.longValue()
    }

    private fun divide(first: StringNumber, second: StringNumber): Long {
        return first.longValue() / second.longValue()
    }

    private fun multiply(first: StringNumber, second: StringNumber): Long {
        return first.longValue() * second.longValue()
    }
}
