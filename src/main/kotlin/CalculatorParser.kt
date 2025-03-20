class CalculatorParser {

    fun parse(input: String): List<String> {
        validateBlank(input)

        val split = input.trim()
            .split(" ")
            .toList()

        return split
    }

    private fun validateBlank(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException("Input is blank")
        }
    }

}