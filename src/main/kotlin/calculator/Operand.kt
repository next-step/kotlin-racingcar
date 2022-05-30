package calculator

class Operand(input: String = "0.0") {
    val value: Double = input.toDoubleOrNull() ?: throw IllegalArgumentException("입력값이 잘못되었습니다. input: $input")

    override fun toString(): String {
        return value.toString()
    }
}
