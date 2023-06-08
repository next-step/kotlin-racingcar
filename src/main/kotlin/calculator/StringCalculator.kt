package calculator

import calculator.dto.ExtractDTO
import calculator.enums.OperatorsEnum

class StringCalculator {

    fun run(input: String?): Double {

        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자일 수 없습니다")
        }

        val extractResult = extractNumbersAndOperators(input)

        val numbers = extractResult.numbers
        val operators = extractResult.operators

        return calculate(numbers, operators)
    }

    fun extractNumbersAndOperators(input: String): ExtractDTO {

        val expression = input.replace("\\s".toRegex(), "")

        val numbers = mutableListOf<Double>()
        val operators = mutableListOf<Char>()

        val seperatedNumbersAndOperators = expression.replace(Regex("(\\d+)"), " $1 ")
            .replace(Regex("([-+*/])"), " $1 ")
            .trim()
            .split("\\s+".toRegex())

        seperatedNumbersAndOperators.forEach {
            when {
                it.matches(Regex("\\d+")) -> numbers.add(it.toDouble())
                else -> operators.add(it.first())
            }
        }

        valid(numbers, operators)

        return ExtractDTO(
            numbers = numbers,
            operators = operators
        )
    }

    fun calculate(
        numbers: MutableList<Double>,
        operators: MutableList<Char>
    ): Double {
        var currentNum = 0.0

        for (i in 0 until numbers.size - 1) {

            if (i == 0) {
                currentNum = numbers[i]
            }

            val operator = OperatorsEnum.fromChar(operators[i])
            currentNum = operator?.calculate(currentNum, numbers[i + 1])
                ?: throw throw IllegalArgumentException("연산 기호의 맞지 않는 기호가 존재합니다")
        }
        return currentNum
    }

    private fun valid(numbers: MutableList<Double>, operators: MutableList<Char>) {

        require(numbers.size == operators.size + 1) {
            "연산 기호의 수는 연산 숫자의 수보다 무조건 1개 적어야 합니다"
        }
    }
}
