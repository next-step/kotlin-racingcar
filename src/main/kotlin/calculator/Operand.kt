package calculator

data class Operand(val value: Double) {
    constructor(input: String = "0.0") : this(
        input.toDoubleOrNull() ?: throw IllegalArgumentException("입력값이 잘못되었습니다. input: $input")
    )
}
