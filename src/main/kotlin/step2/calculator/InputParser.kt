package step2.calculator

object InputParser {
    fun parse(input: String?): List<String> {
        val validatedInput = validate(input)

        return split(validatedInput)
    }

    private fun validate(input: String?): String {
        if (input.isNullOrBlank()) throw IllegalArgumentException("Input value cannot be null or blank.")

        return input
    }

    private fun split(input: String): List<String> {
        return input.split(" ")
    }
}
