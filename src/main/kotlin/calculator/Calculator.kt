package calculator

object Calculator {
    @Throws(IllegalArgumentException::class)
    fun calculate(input: String): Int {
        if (input.isBlank()) {
            throw IllegalArgumentException("Input is blank")
        }

        val elements = input.split(" ").filter { it != "" }

        if (!isInputCorrect(elements)) {
            throw IllegalArgumentException("Input is incorrect")
        }

        var result = elements[0].toInt()

        for (i in 1 until elements.size - 1) {
            if (i % 2 == 0) {
                continue
            }

            result = elements[i].toOperation().execute(result, elements[i + 1].toInt())
        }
        return result
    }

    private fun isInputCorrect(elements: List<String>): Boolean {
        for (i in elements.indices) {
            if (i % 2 == 0) {
                try {
                    elements[i].toInt()
                } catch (e: NumberFormatException) {
                    return false
                }
            } else {
                when (elements[i]) {
                    "+", "-", "*", "/" -> continue
                    else -> return false
                }
            }
        }
        return true
    }

    private fun String.toOperation(): Operation = when (this) {
        "+" -> Operation.ADD
        "-" -> Operation.SUBTRACT
        "*" -> Operation.MULTIPLY
        "/" -> Operation.DIVIDE
        else -> throw IllegalArgumentException("$this cannot convert to Operation")
    }
}
