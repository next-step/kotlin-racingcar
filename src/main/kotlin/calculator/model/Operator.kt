package calculator.model

enum class Operator(
    val value: String,
) {
    PLUS("+"),
    MINUS("-"),
    MULTI("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun parseOperators(inputString: String): List<Operator> {
            return Tokenizer(inputString).toTokens()
                .filter { !Operand.isOperand(it) }
                .map { Operator.toOperator(it) }
                .toList()
        }

        private fun toOperator(string: String): Operator {
            return when (string) {
                PLUS.value -> PLUS
                MINUS.value -> MINUS
                MULTI.value -> MULTI
                DIVIDE.value -> DIVIDE
                else -> throw IllegalArgumentException(String.format("잘뭇된 문자 [%s] 가 입력됨", string))
            }
        }

        private fun isOperator(string: String): Boolean {
            return values().any { it.value == string }
        }
    }
}
