package calculator

class Operator {
    private lateinit var optype: OperatorType

    fun find(ch: Char) {
        optype = when (ch) {
            '+' -> OperatorType.PLUS
            '-' -> OperatorType.MINUS
            '*' -> OperatorType.TIMES
            '/' -> OperatorType.DIVIDED_BY
            else -> throw IllegalArgumentException()
        }
    }

    fun operate(a: Int, b: Int): Int {
        return when (optype) {
            OperatorType.PLUS -> plus(a, b)
            OperatorType.MINUS -> minus(a, b)
            OperatorType.TIMES -> times(a, b)
            OperatorType.DIVIDED_BY -> dividedBy(a, b)
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

    private fun dividedBy(a: Int, b: Int): Int {
        return a / b
    }
}
