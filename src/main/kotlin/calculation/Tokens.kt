package calculation

class Tokens(expression: String, private val tokens: List<String> = expression.split(" ")) {
    val leftHandSide: String
        get() = tokens[0]
    val operator: String
        get() = tokens[1]
    val rightHandSide: String
        get() = tokens[2]
    val exhausted: Boolean
        get() = tokens.size == 3
    val nextExpression: String
        get() = tokens.slice(3 until tokens.size).joinToString(" ")
}
