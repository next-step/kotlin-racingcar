package calculator

object ExpressionVerifier {
    @Throws(IllegalArgumentException::class)
    fun verify(input: String) {
        require(input.isNotBlank()) { "Input is blank" }

        val elements = ExpressionParser.parse(input)
        for (i in elements.indices) {
            if (i % 2 == 0) {
                try {
                    elements[i].toInt()
                } catch (e: NumberFormatException) {
                    throw IllegalArgumentException("Input is incorrect")
                }
            } else {
                when (elements[i]) {
                    "+", "-", "*", "/" -> continue
                    else -> throw IllegalArgumentException("Input is incorrect")
                }
            }
        }
    }
}
