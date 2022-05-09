package calculator

class Expression(values: List<String>) {

    companion object {
        const val FIRST_INDEX = 0
    }

    private val operands: MutableList<Int> = mutableListOf()
    private val operators: MutableList<String> = mutableListOf()

    init {
        values.forEach {
            try {
                val toInt = it.toInt()
                operands.add(toInt)
            } catch (e: NumberFormatException) {
                operators.add(it)
            }
        }
    }

    fun calculate(): Int {

        operators.forEach {
            val operator = Operators.getOperator(it)
            val first = operands.removeFirst()
            val second = operands.first()
            val result = operator?.calculate(first, second)!!.toInt()
            operands[FIRST_INDEX] = result
        }
        return operands.removeFirst()
    }
}
