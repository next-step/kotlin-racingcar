package study.step2

class Calculator {
    val operands: MutableList<Operand> = mutableListOf()
    val operators: MutableList<Operator> = mutableListOf()
    fun execute(operation: String? = null): Int {
        parse(operation)
        var result = 0
        for (index in 0 until operators.size) {
            result = operators[index].apply(operands[index], operands[index + 1])
        }

        return result
    }
    private fun parse(operation: String? = null) {
        if (operation.isNullOrBlank()) {
            throw IllegalArgumentException()
        }
        val splitted: List<String> = operation.split(" ")
        splitted.forEachIndexed { index, it ->
            if (index % 2 == 0) {
                operands.add(Operand.of(it))
            } else {
                operators.add(Operator.of(it))
            }
        }
        if (operators.size + 1 != operands.size) {
            throw IllegalArgumentException()
        }
    }
}
