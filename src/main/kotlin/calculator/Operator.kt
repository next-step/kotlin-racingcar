package calculator

class Operator {
    private lateinit var optype: OperatorType

    fun find(s: String) {
        optype = if (s.contains('+')) OperatorType.PLUS
        else throw IllegalArgumentException()
    }

    fun operate(a: Int, b: Int): Int {
        return when (optype) {
            OperatorType.PLUS -> plus(a, b)
            else -> throw IllegalStateException() // find() 메서드를 먼저 호출!
        }
    }

    private fun plus(a: Int, b: Int): Int {
        return a + b
    }
}
