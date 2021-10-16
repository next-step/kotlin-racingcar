package domain.step2.domain.expression

data class Operand(val operand: Int) {
    constructor(operand: String) : this(
        operand.toIntOrNull() ?: throw IllegalArgumentException(NOT_PARSING_OPERAND_MESSAGE)
    )

    companion object {
        const val NOT_PARSING_OPERAND_MESSAGE = "해당 문자열은 피연산자가 될 수 없습니다."
    }
}
