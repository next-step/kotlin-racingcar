package calculator

class StringFormatter {
    fun eraseWhiteSpace(expression: String?) = expression?.replace("\\s".toRegex(), "")
}
