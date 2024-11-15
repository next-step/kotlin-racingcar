package stringCalculator

enum class Operator(val operator: String) {
    PLUS("+") {
        override fun apply(
            leftValue: Int,
            rightValue: Int,
        ) = leftValue + rightValue
    },

    SUBTRACT("-") {
        override fun apply(
            leftValue: Int,
            rightValue: Int,
        ) = leftValue - rightValue
    },

    MULTIPLE("*") {
        override fun apply(
            leftValue: Int,
            rightValue: Int,
        ) = leftValue * rightValue
    },

    DIVIDE("/") {
        override fun apply(
            leftValue: Int,
            rightValue: Int,
        ) = leftValue / rightValue
    }, ;

    abstract fun apply(
        leftValue: Int,
        rightValue: Int,
    ): Int

    companion object {
        fun findByOperator(str: String): Operator {
            val result = entries.firstOrNull { it.operator == str }
            if (result == null) (throw IllegalArgumentException("올바른 연산자가 아닙니다."))
            return result
        }
    }
}
