package calculator

object ExpressionParser {
    private const val SPACE = " "

    fun parse(input: String): List<String> = input.split(SPACE).filter { it.isNotBlank() }
}
