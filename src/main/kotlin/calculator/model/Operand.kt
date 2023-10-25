package calculator.model

data class Operand(
    val value: Int,
) {
    companion object {
        fun parseOperand(inputString: String): List<Operand> {
            TODO("Not yet implemented")
        }
    }
}
