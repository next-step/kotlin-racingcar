package calculator

class Operand(
    private val value: String
) {
    init {
        validateValue()
    }

    fun getValue(): Int {
        return value.toInt()
    }

    private fun validateValue() {
        require(isNumeric(value)) { "수식의 형식이 잘못되었습니다." }
    }

    private fun isNumeric(input: String): Boolean {
        return input.all { it.isDigit() }
    }

    companion object {
        fun from(value: String): Operand {
            return Operand(value)
        }
    }
}
