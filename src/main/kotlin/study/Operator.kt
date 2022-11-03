package study

enum class Operator(val description: String) {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    fun isPlus(): Boolean {
        return this == PLUS
    }

    fun isMinus(): Boolean {
        return this == MINUS
    }

    fun isDivide(): Boolean {
        return this == DIVIDE
    }

    fun isMultiply(): Boolean {
        return this == MULTIPLY
    }

    companion object {
        private val map = values().associateBy(Operator::description)
        fun fromDescription(type: String?): Operator = map[type] ?: throw IllegalArgumentException("존재하지 않는 연산자입니다.")
    }
}
