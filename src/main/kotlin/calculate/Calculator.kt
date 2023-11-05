package calculate

object Calculator {

    fun calculate(input: String): Int {
        val inputs = input.split(" ")
        return accumulativeOperation(numbersBy(inputs), operatorsBy(inputs))
    }

    private fun numbersBy(strings: List<String>): List<Int> {
        try {
            return strings.filterIndexed { index, _ -> index % 2 == 0 }.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw NumberFormatException("유효한 정수 형식이 아닙니다.")
        }
    }

    private fun operatorsBy(strings: List<String>): List<Operator> {
        try {
            return strings.filterIndexed { index, _ -> index % 2 != 0 }.map { Operator.from(it) }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("올바른 사칙연산자 형식이 아닙니다.")
        }
    }

    private fun accumulativeOperation(numbers: List<Int>, operators: List<Operator>): Int {
        validateCalculate(numbers, operators)
        return pairsOf(numbers, operators).fold(numbers.first()) { acc, (number, operator) ->
            operator.operate(acc, number)
        }
    }

    private fun validateCalculate(numbers: List<Int>, operators: List<Operator>) {
        require(numbers.isNotEmpty()) { "숫자가 없습니다." }
        require(operators.size == numbers.size - 1) { "연산자와 숫자의 수가 일치하지 않습니다." }
    }

    private fun pairsOf(numbers: List<Int>, operators: List<Operator>): ArrayDeque<Pair<Int, Operator>> {
        val sliceNumbers = ArrayDeque(numbers.drop(1))
        return sliceNumbers.zip(operators).toCollection(ArrayDeque())
    }
}

enum class Operator(
    val symbol: String,
    val operate: (Int, Int) -> Int
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun from(input: String): Operator {
            return values().find { it.symbol == input } ?: throw IllegalArgumentException()
        }
    }
}
