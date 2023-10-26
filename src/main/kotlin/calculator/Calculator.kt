package calculator

import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream

fun main() {
    Calculator(
        System.`in`,
        System.out
    ).run()
}

class Calculator(private val inputStream: InputStream, private val outputStream: OutputStream) {
    fun run() {
        val expression = readInput()

        PrintStream(outputStream).println(calculate(expression))
    }

    private fun readInput(): String {
        val expression = inputStream.reader().buffered().readLine()

        if (expression.isNullOrEmpty()) {
            throw IllegalArgumentException()
        }

        return expression
    }

    private fun calculate(expression: String): Int {
        throw NotImplementedError()
    }

    private fun parseExpression(expression: String): Int {
        throw NotImplementedError()
    }

    private fun calculateAdd(): Int {
        throw NotImplementedError()
    }

    private fun calculateSubtract(): Int {
        throw NotImplementedError()
    }

    private fun calculateMultiply(): Int {
        throw NotImplementedError()
    }

    private fun calculateDivide(): Int {
        throw NotImplementedError()
    }
}
