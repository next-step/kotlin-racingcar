package calculator

import java.util.Stack

class Calculator {

    fun calculate(words: List<Word>): Number {
        val acc = Stack<Number>()
        for (w in words) {
            w.calculate(acc)
        }

        return acc.pop()
    }
}
