package calculator

private const val CALCULATOR_REGEX = "^[+\\-*/\\d]*$"
private const val OPERATOR_REGEX = "^[+\\-*/]*\$"
private const val NUMBER_REGEX = "^\\d*\$"

class StringCalculator private constructor(
    private val numbers: MutableList<Int>,
    private val operators: List<Operator>
) {
    private fun calculate(): Int {
        var result = numbers.removeAt(0)
        numbers.zip(operators) { number, operator ->
            result = operator.calculate(result, number)
        }
        return result
    }

    companion object {
        fun calculate(input: String?): Int {
            val pair = validate(input)
            return StringCalculator(pair.first, pair.second).calculate()
        }

        private fun validate(input: String?): Pair<MutableList<Int>, List<Operator>> {
            if (input.isNullOrBlank()) throw IllegalArgumentException("입력 값이 null 이거나 빈 공백 문자입니다.")
            val splits = input.split(" ").map {
                if (!it.matches(Regex(CALCULATOR_REGEX))) throw IllegalArgumentException("입력 값에 사칙 연산이 아닌 기호가 포함되었습니다.")
                it
            }
            val numbers = splits.filter { it.matches(Regex(NUMBER_REGEX)) }.mapTo(mutableListOf()) { it.toInt() }
            val operators = splits.filter { it.matches(Regex(OPERATOR_REGEX)) }.mapNotNull { Operator.from(it) }
            if (numbers.size != operators.size + 1) throw IllegalArgumentException("올바른 계산식이 아닙니다.")
            return numbers to operators
        }
    }
}
