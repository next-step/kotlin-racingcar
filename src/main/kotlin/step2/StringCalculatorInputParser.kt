package step2

class StringCalculatorInputParser {

    fun parse(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("Invalid input : $input")
        }

        return input.split(" ").toList()
    }
}
