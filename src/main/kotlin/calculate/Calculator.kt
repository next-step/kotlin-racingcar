package calculate

object Calculator {

    private const val DELIMITER = " "

    fun calculate(input: String): Int {
        val inputs = input.split(DELIMITER)
        return accumulativeOperation(Numbers.parse(inputs), Operator.parse(inputs))
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

object Numbers {
    fun parse(strings: List<String>): List<Int> {
        return runCatching {
            strings.filterIndexed { index, _ -> index % 2 == 0 }.map { it.toInt() }
        }.onFailure { e ->
            if (e is NumberFormatException) {
                throw NumberFormatException("유효한 정수 형식이 아닙니다.")
            }
        }.getOrThrow()
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
        private val stores by lazy {
            values().associateBy { it.symbol }
        }

        fun parse(strings: List<String>): List<Operator> {
            return runCatching {
                strings.filterIndexed { index, _ -> index % 2 != 0 }.map { Operator.from(it) }
            }.onFailure { e ->
                if (e is IllegalArgumentException) {
                    throw IllegalArgumentException("올바른 사칙연산자 형식이 아닙니다.")
                }
            }.getOrThrow()
        }

        private fun from(input: String): Operator {
            return stores[input] ?: throw IllegalArgumentException()
        }
    }
}
