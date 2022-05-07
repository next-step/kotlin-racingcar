package step2

class ExpressionParser(private val inputStr: String) {

    private val validArgRegex = Regex("[\\d */+-]")
    private val operatorRegex = Regex("[+*/-]")

    init {
        require(validArgRegex.containsMatchIn(inputStr)) {
            "숫자 혹은 사칙연산 기호가 아닌 입력이 존재합니다"
        }
    }

    fun getOperands(): List<Double> =
        operatorRegex.split(inputStr)
            .map { it.toDouble() }

    fun getOperators(): List<Operator> = listOf(Operator.PLUS) +
        operatorRegex.findAll(inputStr)
            .map { find(it.value) }
            .toList()

    override fun toString(): String {
        val operators = getOperators()
            .drop(1)
            .map { it.symbol }
        return getOperands().foldIndexed("") { idx, accum, operand ->
            accum + operand.toInt() + operators[idx]
        }
    }

    private fun find(targetSymbol: String): Operator {
        return Operator.values()
            .find { op ->
                op.symbol == targetSymbol
            } ?: run {
            throw IllegalArgumentException("사칙연산 기호가 아닌 입력이 존재합니다. symbol = $targetSymbol")
        }
    }
}