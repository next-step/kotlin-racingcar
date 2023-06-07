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

        valid(numbers, operators)

        return ExtractDTO(
            numbers = numbers,
            operators = operators
        )
    }

    private fun valid(numbers: MutableList<Double>, operators: MutableList<Char>) {
        if (numbers.size != operators.size + 1) {
            throw IllegalArgumentException("연산 기호의 수는 연산 숫자의 수보다 무조건 1개 적어야 합니다")
        }

        if (operators.any { it != '+' && it != '-' && it != '*' && it != '/' }) {
            throw IllegalArgumentException("연산 기호의 맞지 않는 기호가 존재합니다")
        }
    }
}
