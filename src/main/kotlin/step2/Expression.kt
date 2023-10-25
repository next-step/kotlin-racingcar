package step2

import java.util.LinkedList
import java.util.Queue

class Expression(val expr: String) {

    init {
        if (expr.isBlank()) {
            throw IllegalArgumentException("수식이 비었습니다")
        }
    }

    fun parse(): Queue<String> {
        return LinkedList(
            expr.split(" ")
                .toList()
        )
    }
}
