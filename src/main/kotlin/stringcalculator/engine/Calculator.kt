package stringcalculator.engine

import stringcalculator.ui.Printer
import stringcalculator.ui.Receiver
import java.util.Stack

const val DELIMITER = " "

class Calculator(private val receiver: Receiver = Receiver(), private val printer: Printer = Printer()) {

    private val stack = Stack<Operator>()
    private var result = 0

    fun run(): Int {
        val expr = receiver.run().split(DELIMITER)
        expr.forEach { parse(it) }
        printer.print(result)
        return result
    }

    private fun parse(it: String) {
        if (!isOperator(it)) {
            result = calculate(convertToken2Int(it))
        }
    }

    private fun convertToken2Int(token: String): Int {
        try {
            return token.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("token: $token 은 허용 되지 않는 연산자입니다.")
        }
    }

    private fun calculate(token: Int): Int {
        if (!stack.isEmpty()) {
            return stack.pop().method(result, token)
        }
        return token
    }

    private fun isOperator(token: String): Boolean {
        when (token) {
            "+" -> {
                stack.push(Operator.PLUS); return true
            }
            "-" -> {
                stack.push(Operator.MINUS); return true
            }
            "*" -> {
                stack.push((Operator.MULTIPLY)); return true
            }
            "/" -> {
                stack.push(Operator.DIVIDE); return true
            }
        }
        return false
    }
}
