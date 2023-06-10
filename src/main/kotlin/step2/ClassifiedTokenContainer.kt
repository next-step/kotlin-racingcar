package step2

class ClassifiedTokenContainer private constructor(
    private val operands: List<Operand>,
    private val operators: List<Operator>
) {
    fun tokens(): Tokens {
        return Tokens(
            operands = operands,
            operators = operators
        )
    }

    init {
        require(operators.size + 1 == operands.size) { "피연산자의 개수가 부족합니다." }
    }

    companion object {
        fun from(input: String): ClassifiedTokenContainer {
            val tokenStrings = input.trim().split(Regex("\\s+"))

            val (operands, operators) = transform(tokenStrings)

            return ClassifiedTokenContainer(operands = operands, operators = operators)
        }

        private fun transform(
            tokenStrings: List<String>,
        ): Tokens {
            val operands = mutableListOf<Operand>()
            val operators = mutableListOf<Operator>()

            tokenStrings.forEachIndexed { index, token ->
                if (index % 2 == 0) {
                    val operand = Operand.from(token) ?: throw IllegalArgumentException()
                    operands.add(operand)
                    return@forEachIndexed
                }
                val operator = Operator.from(token) ?: throw IllegalArgumentException()
                operators.add(operator)
            }

            return Tokens(operands, operators)
        }
    }

    data class Tokens(
        val operands: List<Operand>,
        val operators: List<Operator>
    )
}
