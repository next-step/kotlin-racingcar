class CalculatorParser {

    fun parse(input: String): List<String> {

        val split = input.trim()
            .split(" ")
            .toList()

        return split
    }

}