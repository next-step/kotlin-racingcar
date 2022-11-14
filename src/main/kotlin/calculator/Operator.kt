package calculator

class Operator {
    private lateinit var optype: OperatorType

    fun find(s: String) {
        optype = if (s.contains('+')) OperatorType.PLUS
        else if (s.contains('-')) OperatorType.MINUS
        else if (s.contains('*')) OperatorType.TIMES
        else throw IllegalArgumentException()
    }

    fun operate(a: Int, b: Int): Int {
        return when (optype) {
            OperatorType.PLUS -> plus(a, b)
            OperatorType.MINUS -> minus(a, b)
            OperatorType.TIMES -> times(a, b)
            else -> throw IllegalStateException() // find() 메서드를 먼저 호출!
        }
    }

    private fun plus(a: Int, b: Int): Int {
        return a + b
    }

    private fun minus(a: Int, b: Int): Int {
        return a - b
    }

    private fun times(a: Int, b: Int): Int {
        return a * b
    }
}
