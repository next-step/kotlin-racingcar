package calculator

import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream

class Calculator(private val inputStream: InputStream, private val outputStream: OutputStream) {
    companion object {
        val validOperator = charArrayOf('+', '-', '*', '/')
    }

    inner class Operation(val operator: Char, val operand: Int)

    fun run() {
        val expression = readInput()

        PrintStream(outputStream).print(calculate(expression))
    }

    private fun readInput(): String {
        val expression = inputStream.reader().buffered().readLine()
        require(!expression.isNullOrEmpty()) { "Empty expression!" }

        return expression
    }

    private fun parseExpression(expression: String): List<Operation> {
        val operationList = arrayListOf<Operation>()
        val parsedExpression = "+ $expression".split(" ").chunked(2).map { it -> Pair(it[0], it[1]) }

        for (operationItem in parsedExpression) {
            require(validOperator.contains(operationItem.first[0])) { "Wrong operator!" }

            operationList.add(Operation(operationItem.first[0], operationItem.second.toInt()))
        }

        return operationList.toList()
    }

    private fun calculate(expression: String): Int {
        var result = 0
        val parsedOperationList = parseExpression(expression)

        for (operation in parsedOperationList) {
            when (operation.operator) {
                '+' -> result = calculateAdd(result, operation.operand)
                '-' -> result = calculateSubtract(result, operation.operand)
                '*' -> result = calculateMultiply(result, operation.operand)
                '/' -> result = calculateDivide(result, operation.operand)
            }
        }

        return result
    }

    private fun calculateAdd(x: Int, y: Int): Int = x + y

    private fun calculateSubtract(x: Int, y: Int): Int = x - y

    private fun calculateMultiply(x: Int, y: Int): Int = x * y

    private fun calculateDivide(x: Int, y: Int): Int = x / y
}
