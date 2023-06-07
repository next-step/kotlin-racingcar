package calculator.utils

class CalculatorParser {

    companion object {
        fun extract(text: String): List<String> {
            return text.split(" ")
        }
    }


}