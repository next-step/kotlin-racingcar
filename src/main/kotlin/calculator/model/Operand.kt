package calculator.model

data class Operand(
    val value: Int,
) {
    constructor(string: String) : this(string.toInt())

    companion object {
        fun parseOperands(inputString: String): List<Operand> {
            return Tokenizer.toTokens(inputString)
                .asSequence()
                .filter { isOperand(it) }
                .map { Operand(it) }
                .toList()
        }

        fun isOperand(it: String): Boolean {
            return it.chars().allMatch { Character.isDigit(it) }
        }
    }
}
