package calculator

class InfixExpressionFormatter {
    fun eraseWhiteSpace(expression: String?) = expression?.replace("\\s".toRegex(), "")!!
}
