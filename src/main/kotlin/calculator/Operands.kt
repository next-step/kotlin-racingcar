package calculator

class Operands {

    private val CALCULABLE_SIZE = 2
    private val operands: ArrayDeque<Int> = ArrayDeque()

    fun add(operand: Int) {
        require(operands.size < CALCULABLE_SIZE) { "유효하지 않은 입력값입니다." }
        this.operands.add(operand)
    }

    fun add(operand: String) {
        try {
            this.add(operand.toInt())
        } catch (e: java.lang.NumberFormatException) {
            throw IllegalArgumentException("피연산자는 숫자여야만 합니다.")
        }
    }

    fun isCalculable() = this.operands.size == CALCULABLE_SIZE

    fun firstOperand() = this.operands.removeFirst()

    fun getResult(): Int {
        require(operands.size == 1) { throw IllegalArgumentException("유효하지 않은 입력값입니다.") }
        return firstOperand()
    }
}
