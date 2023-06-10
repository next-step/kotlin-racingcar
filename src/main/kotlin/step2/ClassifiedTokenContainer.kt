package step2

class ClassifiedTokenContainer private constructor(
    private val operands: List<Operand>,
    private val operators: List<Operator>
) {
    fun tokens(): Tokens {
        return Tokens(
            operands = operands.iterator(),
            operators = operators.iterator()
        )
    }

    companion object {
        fun from(input: String): ClassifiedTokenContainer {
            val tokens = input.trim().split(Regex("\\s+"))

            val operands = mutableListOf<Operand>()
            val operators = mutableListOf<Operator>()

            populate(tokens, operands, operators)

            require(operators.size + 1 == operands.size) { "피연산자의 개수가 부족합니다." }
            return ClassifiedTokenContainer(operands = operands, operators = operators)
        }

        private fun populate(
            tokens: List<String>,
            operands: MutableList<Operand>,
            operators: MutableList<Operator>
        ) {
            for (index in tokens.indices) {
                val token = tokens[index]
                if (index % 2 == 0) {
                    val operand = Operand.from(token) ?: throw IllegalArgumentException()
                    operands.add(operand)
                    continue
                }
                val operator = Operator.from(token) ?: throw IllegalArgumentException()
                operators.add(operator)
            }
        }
    }

    data class Tokens(
        val operands: Iterator<Operand>,
        val operators: Iterator<Operator>
    )
}
