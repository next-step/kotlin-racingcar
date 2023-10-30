package step2

import java.lang.IllegalArgumentException

data class Token(
    val index: Int,
    val string: String
) {
    fun isEven() = index % 2 == 0

    fun toNumber(): Int {
        if (isEven() && !isNumber()) throw IllegalArgumentException()
        return string.toInt()
    }

    private fun isNumber(): Boolean {
        return string.toIntOrNull() != null
    }

    fun toArithmetic(): Arithmetic {
        return Arithmetic.findBy(string)
    }
}
