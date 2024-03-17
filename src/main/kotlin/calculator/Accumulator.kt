package calculator

class Accumulator(
    private var result: Number
) {
    private var operator: Operator? = null

    fun accumulate(input: String) {
        if (Number.isNumeric(input)) {
            val num: Number = Number.fromString(input)

            requireNotNull(operator) { "Operator is not set." }

            result = operator!!.calculate(result, num)
            operator = null
            return
        }

        require(operator == null) { "Operator is already set." }

        val operator = Operator.fromString(input)
        this.operator = operator
    }

    fun getResult(): Double {
        return result.number
    }

    companion object {
        fun startAccumulate(firstNumber: String): Accumulator {
            val number = Number.fromString(firstNumber)
            return Accumulator(number)
        }
    }
}