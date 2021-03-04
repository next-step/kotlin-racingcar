package step2_string_calculator.calculator.engine

import step2_string_calculator.calculator.ui.Printer
import step2_string_calculator.calculator.ui.Receiver
import java.util.Stack

const val DELIMITER = " "

class Calculator(private val receiver: Receiver = Receiver(), private val printer: Printer = Printer()) {

    private val stack = Stack<Operator>()
    private var result = 0

    fun run(): Int {
        val expr = receiver.run().split(DELIMITER)

        for (token in expr) {
            if (!parseOperator(token)) {
                calculate(convertToken2Int(token))
            }
        }

        printer.print(result)

        return result
    }

    private fun convertToken2Int(token: String): Int {
        try {
            return token.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("token: $token 은 허용 되지 않는 연산자입니다.")
        }
    }

    private fun parseOperator(token: String): Boolean {
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

    private fun calculate(token: Int) {
        if (!stack.isEmpty()) {
            result = stack.pop().run(result, token)
        } else {
            result = token
        }
    }
}
