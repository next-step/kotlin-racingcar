package calculator

import java.util.Stack

class SequenceCalculator(
    private val notationTransformer: NotationTransformer
) : Calculator {

    private var result = Number.of("0")

    private val words = mutableListOf<Word>()

    override fun parse(line: String) {
        words.clear()
        words.addAll(notationTransformer.transform(line))
    }

    override fun calculate() {
        val resultStack = Stack<Number>()
        for (w in words) {
            w.calculate(resultStack)
        }

        this.result = resultStack.pop()
    }

    override fun result(): Number {
        return result
    }
}
