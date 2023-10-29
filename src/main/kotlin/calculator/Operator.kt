package calculator

import java.math.BigDecimal

enum class Operator(
    private val text: String,
    private val regex: String = text
) {
    ADD("+", "\\+"), SUBTRACT("-"), MULTIPLY("*", "\\*"), DIVIDE("/");

    fun apply(left: BigDecimal, right: BigDecimal): BigDecimal {
        return when (this) {
            ADD -> left.add(right)
            SUBTRACT -> left.subtract(right)
            MULTIPLY -> left.multiply(right)
            DIVIDE -> left.divide(right)
        }
    }

    companion object {
        fun regex(): Regex {
            val regex = values().joinToString(separator = "|", prefix = "(", postfix = ")") { it.regex }
            return Regex(regex)
        }

        fun findBy(text: String): Operator {
            return values().first { it.text == text }
        }
    }
}
