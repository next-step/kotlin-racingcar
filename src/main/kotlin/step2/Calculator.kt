package step2

import java.util.LinkedList
import java.util.Queue

class Calculator(private val expr: String) {
    fun calculate(): Int {
        val tokens = parse()
        var result = 0
        while(tokens.isNotEmpty()) {
            var token = tokens.poll()
            if (token != "+" && token != "-" && token != "*" && token != "/") {
                result = token.toInt()
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

    private fun parse(): Queue<String> {
        return LinkedList(
            expr.split(" ")
                .toList()
        )
    }
}