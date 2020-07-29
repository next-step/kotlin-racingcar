package step2.parser

import step2.calculator.Node
import step2.calculator.OperatorString
import java.util.regex.Pattern

class NodeParserImpl : NodeParser {
    private val REGEX_FOR_NODE = Regex("((?<=([-*/+\\s]))|(?=([-*/+\\s])))")
    private val PATTERN_FOR_NUMBER = Pattern.compile("^[0-9]+$")
    override fun parse(text: String): List<Node> {
        return text
            .split(REGEX_FOR_NODE)
            .trimAll()
            .exceptEmpty()
            .convertAllToNode()
    }

    fun List<String>.trimAll() = map { it.trim() }

    fun List<String>.exceptEmpty() = filter { it.isNotEmpty() }

    fun String.convertToNode(): Node {
        this.takeIf { PATTERN_FOR_NUMBER.matcher(it).matches() }?.let {
            return Node.Number(it.toDouble())
        }

        this.takeIf {
            OperatorString.values().any { enum ->
                enum.string == this
            }
        }?.let {
            return OperatorString.values().find { op -> op.string == it }!!.operator
        }

        throw NodeParser.Error.InvalidCharacter(this)
    }

    fun List<String>.convertAllToNode() = map { it.convertToNode() }
}
