package step2.parser

import step2.calculator.Node
import java.util.regex.Pattern

const val PLUS = "+"
const val MINUS = "-"
const val MULTIPLY = "*"
const val DIVIDE = "/"

class NodeParserImpl : NodeParser {
    private val regexForNode = Regex("((?<=([-*/+\\s]))|(?=([-*/+\\s])))")
    private val patternForNumber = Pattern.compile("^[0-9]+$")
    override fun parse(text: String): List<Node> {
        return text
            .split(regexForNode)
            .trimAll()
            .exceptEmpty()
            .convertAllToNode()
    }

    fun List<String>.trimAll() = map { it.trim() }

    fun List<String>.exceptEmpty() = filter { it != "" }

    fun String.convertToNode() = when {
        patternForNumber.matcher(this).matches() -> Node.Number(this.toDouble())
        this == PLUS -> Node.Operator.Plus
        this == MINUS -> Node.Operator.Minus
        this == MULTIPLY -> Node.Operator.Multiply
        this == DIVIDE -> Node.Operator.Divide
        else -> throw NodeParser.Error.InvalidCharacter(this)
    }

    fun List<String>.convertAllToNode() = map { it.convertToNode() }
}
