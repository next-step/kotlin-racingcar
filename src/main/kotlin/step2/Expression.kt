package step2

class Expression(inputStr: String) {

    private val validArgRegex = Regex("[\\d */+-]")
    private val operatorRegex = Regex("[+*/-]")

    var operands: List<Double>
    var operators: List<Operator>

    init {
        val validationCheckedStr = validArgRegex.findAll(inputStr).toList()
        require(inputStr.length == validationCheckedStr.size) {
            "inputStr contains non-digit or non-arithmetic characters"
        }

        operands = operatorRegex.split(inputStr)
            .map { it.toDouble() }

        operators = listOf(Operator.PLUS) +
            operatorRegex.findAll(inputStr)
                .map { Operator.find(it.value) }
                .toList()
    }

    override fun toString(): String {
        val operators = operators
            .drop(1)
            .map { it.symbol }
        return operands.foldIndexed("") { idx, acc, operand ->
            acc + operand.toInt() + operators[idx]
        }
    }
}
