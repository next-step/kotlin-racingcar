package calculator.data

import calculator.util.Message.Companion.INDIVISIBLE_NUMBER
import calculator.util.Message.Companion.NOTICE_NOT_DIVIDE_ZERO

data class Operand(private val value: Double) {

    fun add(input: Operand) = Operand(this.value + input.value)

    fun minus(input: Operand) = Operand(this.value - input.value)

    fun multiply(input: Operand) = Operand(this.value * input.value)

    fun divide(input: Operand): Operand {
        validateToDivide(input)
        return Operand(this.value / input.value)
    }

    private fun validateToDivide(input: Operand) {
        if (input.value == INDIVISIBLE_NUMBER) {
            throw IllegalArgumentException(NOTICE_NOT_DIVIDE_ZERO)
        }
    }

    override fun toString(): String {
        return "$value"
    }
}
