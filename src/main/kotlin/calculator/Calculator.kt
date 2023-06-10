package calculator

object Calculator {
    @Throws(IllegalArgumentException::class)
    fun calculate(input: String): Int {
        ExpressionVerifier.verify(input)

        val elements = ExpressionFormatter.format(input)

        var result = elements[0].toInt()

        for (i in 1 until elements.size - 1) {
            if (i % 2 == 0) {
                continue
            }
            result = elements[i].toOperation().execute(result, elements[i + 1].toInt())
        }
        return result
    }
}
