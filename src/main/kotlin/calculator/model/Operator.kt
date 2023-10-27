package calculator.model

enum class Operator(
    val value: String,
    val action: (Int, Int) -> Int
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTI("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b }),
    ;

    fun operate(first: Int, second: Int): Int {
        return this.action(first, second)
    }

    companion object {
        fun parseOperators(inputString: String): List<Operator> {
            return Tokenizer(inputString).toTokens()
                .filter { !Operand.isOperand(it) }
                .map { Operator.toOperator(it) }
                .toList()
        }

        private fun toOperator(string: String): Operator {
            return requireNotNull(
                Operator.values()
                    .first { it.value.equals(string) }
            )
        }

        private fun isOperator(string: String): Boolean {
            return values().any { it.value == string }
        }
    }
}
