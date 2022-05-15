package calculator

import java.lang.IllegalArgumentException

class Calculator(value: String?) {

    private val numbers: List<Number>
    private val operators: List<Operator>

    init {
        require(!value.isNullOrBlank())
        val pair = partitionValue(value = value)
        this.numbers = pair.first.map { Number.from(value = it.value) }
        this.operators = pair.second.map { Operator.findBySign(sign = it.value) }
        validateSize(numbers = this.numbers, operators = this.operators)
    }

    private fun partitionValue(value: String) = value.split(REGEX)
        .withIndex()
        .partition { isNumberIndex(it.index) }

    private fun isNumberIndex(value: Int) = value % 2 == 0

    private fun validateSize(numbers: List<Number>, operators: List<Operator>) {
        if (numbers.size - 1 != operators.size) {
            throw IllegalArgumentException("입력된 수식이 올바르지 않습니다.")
        }
    }

    fun calculate(): Number {
        var calculateValue = numbers[0]

        for (i in 1 until numbers.size) {
            calculateValue = operators[i - 1].calculate(calculateValue, numbers[i])
        }

        return calculateValue
    }

    companion object {
        private const val REGEX = " "
    }
}
