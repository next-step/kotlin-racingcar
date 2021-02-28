package calculator.notation

import calculator.NotationTransformer
import calculator.Number
import calculator.Operator
import calculator.Word
import java.util.Stack

class SequencePostfixNotationTransformer : NotationTransformer {

    private val regex = "^\\d+$".toRegex()

    override fun transform(line: String): List<Word> {
        val tokens = line.split(" ")
        val operators = Stack<Word>()
        val words = mutableListOf<Word>()

        for (token in tokens) {
            addNumberIf(words, operators, token)
            addOperatorIf(operators, token)
        }
        return words
    }

    private fun addNumberIf(words: MutableList<Word>, operators: Stack<Word>, token: String) {
        if (token.matches(regex)) {
            words.add(Number.of(token))
            popOperator(words, operators)
        }
    }

    private fun popOperator(words: MutableList<Word>, operators: Stack<Word>) {
        if (operators.isEmpty()) {
            return
        }
        words.add(operators.pop())
    }

    private fun addOperatorIf(operators: Stack<Word>, token: String) {
        if (token.matches(regex).not()) {
            operators.add(Operator.of(token))
        }
    }
}
