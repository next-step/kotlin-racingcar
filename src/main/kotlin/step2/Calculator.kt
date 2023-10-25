package step2

import java.util.LinkedList
import java.util.Queue

class Calculator(private val expr: String) {

    init {
        if (expr.isBlank()) {
            throw IllegalArgumentException("수식이 존재하지 않습니다.")
        }
    }

    fun calculate(): Int {
        val tokens = parse()
        var result = 0
        while (tokens.isNotEmpty()) {
            var token = tokens.poll()
            if (isNumber(token) and !isOperator(token)) {
                result = token.toInt()
            }
            if (!isNumber(token) and !isOperator(token)) {
                throw IllegalArgumentException("수식에 올바른 연산자가 아닙니다.")
            }
            if (token == "+") {
                token = tokens.poll()
                result += token.toInt()
            }
            if (token == "-") {
                token = tokens.poll()
                result -= token.toInt()
            }
            if (token == "*") {
                token = tokens.poll()
                result *= token.toInt()
            }
            if (token == "/") {
                token = tokens.poll()
                result /= token.toInt()
            }
        }
        return result
    }

    private fun isOperator(token: String): Boolean {
        return token == "+" || token == "-" || token == "*" || token == "/"
    }

    private fun isNumber(token: String): Boolean {
        return token.toIntOrNull() != null
    }

    private fun parse(): Queue<String> {
        return LinkedList(
            expr.split(" ")
                .toList()
        )
    }
}