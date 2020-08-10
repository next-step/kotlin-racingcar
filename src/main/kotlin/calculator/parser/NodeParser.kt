package calculator.parser

import calculator.calculator.Node
import calculator.calculator.Number
import calculator.calculator.Operator
import java.util.regex.Pattern

class NodeParser {
    fun parse(text: String): List<Node> {
        return MATCHER.split(text)
            .trimAll()
            .exceptEmpty()
            .convertAllToNode()
    }

    private fun Array<String>.trimAll() = map { it.trim() }

    private fun List<String>.exceptEmpty() = filter { it.isNotEmpty() }

    private fun String.convertToNode(): Node {
        takeIf {
            Pattern.compile(PATTERN_FOR_NUMBER)
                .matcher(it).matches()
        }?.let {
            return Number(it)
        }

        return Operator.of(this)
    }

    private fun List<String>.convertAllToNode() = map { it.convertToNode() }

    companion object {
        private const val REGEX_FOR_NODE = "((?<=([-*/+\\s]))|(?=([-*/+\\s])))"
        private val MATCHER = Pattern.compile(REGEX_FOR_NODE)
        private const val PATTERN_FOR_NUMBER = "^[0-9]+$"
    }
}
