package calculator.parser

import calculator.calculator.Node
import calculator.calculator.Number
import calculator.calculator.Operator

class NodeParser {
    fun parse(text: String): List<Node> {
        return REGEX_FOR_NODE.split(text)
            .trimAll()
            .exceptEmpty()
            .convertAllToNode()
    }

    private fun List<String>.trimAll() = map { it.trim() }

    private fun List<String>.exceptEmpty() = filter { it.isNotEmpty() }

    private fun String.convertToNode(): Node {
        takeIf {
            REGEX_FOR_NUMBER.matches(it)
        }?.let {
            return Number(it)
        }

        return Operator.of(this)
    }

    private fun List<String>.convertAllToNode() = map { it.convertToNode() }

    companion object {
        private const val REGEX_STRING = "((?<=([-*/+\\s]))|(?=([-*/+\\s])))"
        private val REGEX_FOR_NODE = Regex(REGEX_STRING)
        private const val PATTERN_FOR_NUMBER = "^[0-9]+$"
        private val REGEX_FOR_NUMBER = Regex(PATTERN_FOR_NUMBER)
    }
}
