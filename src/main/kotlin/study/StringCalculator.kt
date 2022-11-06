package study

enum class Operator(
    val symbol: Char,
    val calculate: (Int, Int) -> Int
) {
    PLUS(
        symbol = '+',
        calculate = { a, b -> a + b }
    ),
    MINUS(
        symbol = '-',
        calculate = { a, b -> a - b }
    ),
    MULTIPLY(
        symbol = '*',
        calculate = { a, b -> a * b }
    ),
    DIVIDE(
        symbol = '/',
        calculate = { a, b ->
            if (b != 0) a / b
            else throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
    );

    companion object {
        fun of(char: Char) = values()
            .find { it.symbol == char }
            ?: throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
    }
}

fun calculate(input: String?): Int {
    require(!input.isNullOrBlank()) { "input이 null이거나 공백입니다." }
    val (numbers, operators) = input.split(" ")
        .withIndex()
        .partition { it.index % 2 == 0 }

    val parsedNumbers = numbers
        .map { it.value.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닌 값이 숫자자리에 입력되었습니다.") }
        .takeIf { it.size > 1 }
        ?: throw IllegalArgumentException("하나 이상의 숫자가 입력되어야합니다.")

    return parsedNumbers
        .drop(1) // initial value drop
        .foldIndexed(parsedNumbers.first()) { index, acc, number ->
            operators[index]
                .value
                .first()
                .let(Operator::of)
                .calculate(acc, number)
        }
}