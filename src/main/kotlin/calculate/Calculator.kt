package calculate

class Calculator(
    private val numbers: List<Int>,
    private val operators: List<Operator>
) {

    fun calculate(): Int {
        validateCalculate()
        return accumulativeOperation(numbers, operators)
    }

    private fun validateCalculate() {
        require(numbers.isNotEmpty()) { "숫자가 없습니다." }
        require(operators.size == numbers.size - 1) { "연산자와 숫자의 수가 일치하지 않습니다." }
    }

    private fun accumulativeOperation(numbers: List<Int>, operators: List<Operator>): Int {
        return pairsOf(numbers, operators).fold(numbers.first()) { acc, (number, operator) ->
            operator.operate(acc, number)
        }
    }

    private fun pairsOf(numbers: List<Int>, operators: List<Operator>): List<Pair<Int, Operator>> {
        val sliceNumbers = numbers.toMutableList()
        sliceNumbers.removeFirst()
        return sliceNumbers.zip(operators)
    }

    companion object {
        fun from(input: String): Calculator {
            val inputs = input.split(" ")
            return Calculator(numbers = numbersBy(inputs), operators = operatorsBy(inputs))
        }

        private fun numbersBy(strings: List<String>): List<Int> {
            try {
                return strings.filterIndexed { index, _ -> index % 2 == 0 }.map { it.toInt() }
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("유효한 정수 형식이 아닙니다.")
            }
        }

        private fun operatorsBy(strings: List<String>): List<Operator> {
            try {
                return strings.filterIndexed { index, _ -> index % 2 != 0 }.map { Operator.from(it) }
            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException("올바른 사칙연산자 형식이 아닙니다.")
            }
        }
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
