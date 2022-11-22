package stringcalculator.domain

private const val INDEX_OF_NUMBER = 0
private const val INDEX_OF_SIGN = 1

object Calculator {

    fun calculate(formula: List<String>): Int {
        validate(formula)
        val numbers = getNumbers(formula)
        val signs = getSigns(formula)

        return calculateInternal(numbers, signs)
    }

    private fun validate(formula: List<String>) {
        if (formula.isEmpty()) {
            throw IllegalArgumentException("빈 수식은 계산할 수 없습니다.")
        }

        if (formula.size % 2 == 0) {
            throw IllegalArgumentException("숫자와 연산기호의 수가 올바르지 않습니다. 수식: $formula")
        }
    }

    private fun getNumbers(stringFormula: List<String>) =
        stringFormula.filterIndexed { index, _ -> index % 2 == INDEX_OF_NUMBER }.map { it.toInt() }

    private fun getSigns(stringFormula: List<String>) =
        stringFormula.filterIndexed { index, _ -> index % 2 == INDEX_OF_SIGN }

    private fun calculateInternal(numbers: List<Int>, signs: List<String>): Int {
        var total = numbers[0]
        for (i in signs.indices) {
            val operator = Operator.of(signs[i])

            val left = total
            val right = numbers[i + 1]
            total = operator.calculate(left, right)
        }

        return total
    }
}
