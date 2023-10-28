package calculator

import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream

class Calculator(private val inputStream: InputStream, private val outputStream: OutputStream) {
    inner class Operation(val operator: Operator, val operand: Int)

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
        val parsedExpression = "+ $expression".split(" ").chunked(2).map { Pair(Operator from it[0], it[1]) }

        for (operationItem in parsedExpression) {
            operationList.add(Operation(operationItem.first, operationItem.second.toInt()))
        }

        return operationList.toList()
    }

    private fun calculate(expression: String): Int {
        var result = 0
        val parsedOperationList = parseExpression(expression)

        for (operation in parsedOperationList) {
            result = when (operation.operator) {
                Operator.PLUS -> calculateAdd(result, operation.operand)
                Operator.MINUS -> calculateSubtract(result, operation.operand)
                Operator.MULTIPLY -> calculateMultiply(result, operation.operand)
                Operator.DIVIDE -> calculateDivide(result, operation.operand)
            }
        }

        return result
    }

    private fun calculateAdd(x: Int, y: Int): Int = x + y

    private fun calculateSubtract(x: Int, y: Int): Int = x - y

    private fun calculateMultiply(x: Int, y: Int): Int = x * y

    private fun calculateDivide(x: Int, y: Int): Int = x / y
}
