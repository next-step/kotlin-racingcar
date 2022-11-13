package calculator

class Operators {

    private val operators: ArrayDeque<Operator> = ArrayDeque()

    fun add(operator: Operator) {
        require(operators.size < CALCULABLE_SIZE) { "유효하지 않은 입력값입니다." }
        operators.add(operator)
    }

    fun removeFirst() = operators.removeFirst()

    fun isCalculable(): Boolean = this.operators.size == CALCULABLE_SIZE

    companion object {
        private const val CALCULABLE_SIZE = 1
    }
}
