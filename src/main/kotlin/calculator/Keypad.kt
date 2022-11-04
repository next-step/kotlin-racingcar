package calculator

class Keypad {
    fun pressed(input: String? = readLine()): String {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        return input
    }
}
