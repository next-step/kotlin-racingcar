package step2

class StringCalculatorInputParser {

    fun parse(input: String?): List<String> {
        require(!input.isNullOrBlank()) { "Invalid input : $input" }

        return input.split(" ").toList()
    }
}
