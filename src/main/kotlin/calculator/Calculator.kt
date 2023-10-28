package calculator

fun execute(input: String?): Int {
    validateInput(input)

    val numbers: List<Int> = extractNumbers(input!!)
    val operators: List<Char> = extractOperators(input)

    return calculate(numbers, operators)
}

private fun validateInput(input: String?) {
    require(!input.isNullOrBlank()) { "입력값을 제대로 기입해주세요." }
    require(input[0].isDigit()) { "입력값의 첫 문자는 숫자여야 합니다." }
}

private fun extractNumbers(input: String) = input.split("[+\\-*/]".toRegex())
    .filter { it.isNotBlank() }
    .map {
        it.trim().toIntOrNull()
            ?: throw IllegalArgumentException("입력값은 숫자와 사칙연산('+', '-', '*', '/')만 기입해주세요.")
    }

private fun extractOperators(input: String) = input.filter { it in "+-*/" }
    .toList()

private fun calculate(
    numbers: List<Int>,
    operators: List<Char>
): Int {
    var result: Int = numbers[0]

    for (i in 1 until numbers.size) {
        when (operators[i - 1]) {
            '+' -> result = add(result, numbers[i])
            '-' -> result = subtract(result, numbers[i])
            '*' -> result = multiply(result, numbers[i])
            '/' -> result = divide(result, numbers[i])
        }
    }

    return result
}
