package calculator.enums

enum class OperatorsEnum(val calculate: (Double, Double) -> Double) {

    PLUS({ left, right -> left + right }),
    MINUS({ left, right -> left - right }),
    MULTIPLY({ left, right -> left * right }),
    DIVIDE({ left, right -> left / right });

    companion object {
        private val charToOperator = mapOf(
            '+' to PLUS,
            '-' to MINUS,
            '*' to MULTIPLY,
            '/' to DIVIDE
        )

        fun fromChar(char: Char): OperatorsEnum? {
            return charToOperator[char]
        }
    }
}
