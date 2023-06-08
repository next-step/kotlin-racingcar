package step2

class StringCalculatorInputParser {

    private val parserDelimiters: Array<String> = arrayOf(" ")

    fun parse(input: String?): List<String> {
        require(!input.isNullOrBlank()) { "Invalid input : $input" }

        return input.split(delimiters = parserDelimiters).toList()
    }
}
