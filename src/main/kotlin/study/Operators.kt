package study

class Operators(stringsParam: List<String>) {

    private val operators: MutableList<Operator>

    init {
        operators = stringsParam.map { Operator.fromDescription(it) }.toMutableList()
    }

    fun removeFirst(): Operator {
        return operators.removeFirst()
    }

    fun isNotEmpty(): Boolean {
        return operators.isNotEmpty()
    }

    fun size(): Int {
        return operators.size
    }
}
