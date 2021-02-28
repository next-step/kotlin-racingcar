package calculator.notation

import calculator.NotationTransformer
import calculator.Number
import calculator.Operator
import calculator.Word
import java.util.Stack

class SequencePostfixNotationTransformer : NotationTransformer {

    override fun transform(line: String): List<Word> {
        val tokens = line.split(DELIMITER)
        val operators = Stack<Word>()
        val words = mutableListOf<Word>()

        for (token in tokens) {
            addWordWhenNumber(words, operators, token)
            addWordWhenOperator(operators, token)
        }
        return words
    }

    private fun addWordWhenNumber(words: MutableList<Word>, operators: Stack<Word>, token: String) {
        if (token.matches(REGEX_NUMBER)) {
            words.add(Number.of(token))
            popOperatorIfNotEmpty(words, operators)
        }
    }

    private fun popOperatorIfNotEmpty(words: MutableList<Word>, operators: Stack<Word>) {
        if (operators.isEmpty()) {
            return
        }
        words.add(operators.pop())
    }

    private fun addWordWhenOperator(operators: Stack<Word>, token: String) {
        if (token.matches(REGEX_NUMBER).not()) {
            operators.add(Operator.of(token))
        }
    }

    companion object {
        private const val DELIMITER = " "
        private val REGEX_NUMBER = "^\\d+$".toRegex()
    }
}
