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
            val token = tokens.poll()
            if (isNumber(token)) {
                result = token.toInt()
            }
            if (!isNumber(token)) {
                result = Operator.getOperator(token).applyAsInt(result, tokens.poll().toInt())
            }
        }
        return result
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