package study.step2

class Calculator {
    val operands: MutableList<Int> = mutableListOf()
    val operators: MutableList<Operator> = mutableListOf()
    fun execute(operation: String? = null): Int {
        parse(operation)
        var result = 0
        for (index in 0 until operators.size) {
            val left = operands[index]
            val right = operands[index + 1]
            result = operators[index].apply(left, right)
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
                operands.add(it.toInt())
            } else {
                operators.add(Operator.of(it))
            }
        }
        if (operators.size + 1 != operands.size) {
            throw IllegalArgumentException()
        }
    }
}
