package calculator

import java.lang.IllegalArgumentException

class BasicCalculator : Calculator {
    private var currOperationSymbol = '+'
    private var result = 0
    override fun calculate(operation: String?): Int {
        validateOperation(operation)
        initCalculator()

        operation!!.split(" ")
            .forEach { op ->
                if (isNumeric(op)) {
                    result = execute(op.toInt())
                    return@forEach
                }
                currOperationSymbol = toOperationSymbol(op)
            }

        return result
    }

    private fun initCalculator() {
        currOperationSymbol = '+'
        result = 0
    }

    private fun toOperationSymbol(op: String): Char {
        if (op.length > 1) throw IllegalArgumentException() // FIXME: 추가적인 예외처리 사항도 고려

        return op.first()
    }

    private fun execute(operand: Int) = when (currOperationSymbol) {
        '+' -> result + operand
        '-' -> result - operand
        '*' -> result * operand
        '/' -> result / operand
        else -> { 0 } // FIXME: sealed class or enum 이용하기
    }

    private fun isNumeric(op: String) = op.toIntOrNull() != null

    private fun validateOperation(operation: String?) {
        if (operation.isNullOrEmpty()) throw IllegalArgumentException("Operation is null or empty")
    }
}
