package calculator

object ExpressionFormatter {
    private const val SPACE = " "
    private const val BLANK = ""

    fun format(input: String): List<String> = input.split(SPACE).filter { it != BLANK }
}
