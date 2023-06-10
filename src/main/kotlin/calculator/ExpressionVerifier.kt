package calculator

object ExpressionVerifier {
    @Throws(IllegalArgumentException::class)
    fun verify(input: String) {
        require(input.isNotBlank()) { "Input is blank" }

        val elements = ExpressionParser.parse(input)
        for (i in elements.indices) {
            if (i % 2 == 0) {
                elements[i].toBigDecimalOrNull() ?: throw IllegalArgumentException("Input is incorrect")
            } else {
                if (elements[i] in setOf("+", "-", "*", "/")) {
                    continue
                }
                throw IllegalArgumentException("Input is incorrect")
            }
        }
    }
}
