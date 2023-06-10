package step2

class ClassifiedTokenContainer private constructor(
    private val operands: List<Double>,
    private val operators: List<Operator>
) {
    init {
        require(operators.size + 1 == operands.size) { "피연산자의 개수가 부족합니다." }
    }

    fun tokens(): Tokens {
        return Tokens(
            operands = operands,
            operators = operators
        )
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
            val operands = mutableListOf<Double>()
            val operators = mutableListOf<Operator>()

            tokenStrings.forEachIndexed { index, token ->
                if (index % 2 == 0) {
                    val operand = token.toDoubleOrNull() ?: throw IllegalArgumentException("숫자 입력이 아닙니다!")
                    operands.add(operand)
                    return@forEachIndexed
                }
                val operator = Operator.from(token) ?: throw IllegalArgumentException("연산자 문자열이 아닙니다!")
                operators.add(operator)
            }

            return Tokens(operands, operators)
        }
    }

    data class Tokens(
        val operands: List<Double>,
        val operators: List<Operator>
    )
}
