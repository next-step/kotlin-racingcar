package calculator

class Button {
    fun pressed(): String {
        val input: String? = readLine()

        if (input.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        return input
    }
}
