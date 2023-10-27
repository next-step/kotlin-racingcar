package step2

enum class FourArithmeticOperation(val operation: String) {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    companion object {
        private const val NOT_SUPPORTED_OPERATION = "지원하지 않는 연산자가 포함되어 있어요"

        fun getArithmeticOperationFromString(char: Char) = when (char) {
            '+' -> PLUS
            '-' -> MINUS
            '*' -> MULTIPLY
            '/' -> DIVIDE
            else -> error(NOT_SUPPORTED_OPERATION)
        }
    }
}
