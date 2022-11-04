package calculator

class Keypad {
    fun pressed(): String {
        val input: String? = readLine()

        if (input.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        return input
    }

    fun pressed(input: String?): String {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        return input
    }
}
