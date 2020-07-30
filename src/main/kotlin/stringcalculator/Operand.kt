package stringcalculator

data class Operand(private val value: Double) {

    fun add(input: Operand) = Operand(this.value + input.value)

    fun minus(input: Operand) = Operand(this.value - input.value)

    fun multiply(input: Operand) = Operand(this.value * input.value)

    fun divide(input: Operand): Operand {
        validateInputIsNotZero(input)
        return Operand(this.value / input.value)
    }

    private fun validateInputIsNotZero(input: Operand) {
        if (input.value == 0.0) {
            throw IllegalArgumentException("0으로는 나눌 수 없습니다.")
        }
    }

    override fun toString(): String {
        return "$value"
    }
}
