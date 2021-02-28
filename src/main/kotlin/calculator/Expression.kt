package calculator

class Expression {
    private var numbers: MutableList<Int> = mutableListOf()
    private var operators: MutableList<Operator> = mutableListOf()

    fun addExpToken(token: String) {
        if (isOperatorTurn()) {
            this.operators.add(Operator.ofToken(token))
            return
        }
        numbers.add(token.toInt())
    }

    fun execute(): Int {
        if (numbers.isEmpty()) {
            return 0
        }

        var result = numbers[0]
        for (numberIndex in 1 until numbers.size) {
            result = operators[numberIndex - 1].operation(result, numbers[numberIndex])
        }
        return result
    }

    private fun isOperatorTurn(): Boolean {
        return numbers.size > operators.size
    }

    private enum class Operator(
        private val token: String,
        val operation: (Int, Int) -> Int
    ) {
        PLUS("+", { x, y -> x + y }),
        MINUS("-", { x, y -> x - y }),
        MULTIPLY("*", { x, y -> x * y }),
        DIVIDE("/", { x, y -> x / y });

        companion object {
            fun ofToken(token: String): Operator {
                return values().firstOrNull { it.token == token }
                    ?: throw IllegalArgumentException("unknown token $token")
            }
        }
    }
}
