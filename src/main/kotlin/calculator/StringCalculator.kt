package calculator

import calculator.dto.ExtractDTO

class StringCalculator {

    fun extractNumbersAndOperators(input: String): ExtractDTO {

        val expression = input.replace("\\s".toRegex(), "")

        val numbers = mutableListOf<Double>()
        val operators = mutableListOf<Char>()

        var currentNumber = StringBuilder()
        for (char in expression) {
            if (char.isDigit()) {
                currentNumber.append(char)
            } else {
                if (currentNumber.isNotEmpty()) {
                    numbers.add(currentNumber.toString().toDouble())
                    currentNumber = StringBuilder()
                }

                operators.add(char)
            }
        }

        if (currentNumber.isNotEmpty()) {
            numbers.add(currentNumber.toString().toDouble())
        }

        return ExtractDTO(
            numbers = numbers,
            operators = operators
        )
    }
}
