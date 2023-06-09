package calculator

object Calculator {
    fun add(num1: Int, num2: Int): Int = num1 + num2

    fun subtract(num1: Int, num2: Int): Int = num1 - num2

    fun multiply(num1: Int, num2: Int): Int = num1 * num2

    @Throws(IllegalArgumentException::class)
    fun divide(num1: Int, num2: Int): Int {
        if (num2 == 0) {
            throw IllegalArgumentException("Not divisible by zero")
        }
        return num1 / num2
    }

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

            result = when (elements[i].toOperation()) {
                Operation.ADD -> add(result, elements[i + 1].toInt())
                Operation.SUBTRACT -> subtract(result, elements[i + 1].toInt())
                Operation.MULTIPLY -> multiply(result, elements[i + 1].toInt())
                Operation.DIVIDE -> divide(result, elements[i + 1].toInt())
            }
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

enum class Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}
