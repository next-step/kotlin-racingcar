package calculator

class Keypad {
    fun pressed(input: String? = readLine()): List<String> {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        return parse(input)
    }

    private fun parse(expression: String): List<String> {
        return expression.split(" ")
    }
}
