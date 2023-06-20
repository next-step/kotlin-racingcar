package calculator

import java.math.BigDecimal


class Expression(private val operators: List<Operator>, private val numbers: List<BigDecimal>) {

    fun getResult(): BigDecimal {
        val operatorQueue = ArrayDeque(operators)

        return numbers.reduce { acc, i -> operatorQueue.removeFirst().apply(acc, i) }
    }

    companion object {
        private const val DEFAULT_DELIMITER = " "

        fun from(expression: String): Expression {
            require(expression.isNotEmpty()) { "입력값이 없습니다." }

            val values = expression.split(DEFAULT_DELIMITER)
            require(validLength(values.size)) { "잘못된 식입니다" }

            val operators = values.filterIndexed { index, _ -> index % 2 == 1 }
                .map { v -> Operator.from(v) }

            val numbers = values.filterIndexed { index, _ -> index % 2 == 0 }
                .map { number -> toNumber(number) }

            return Expression(operators, numbers)
        }

        private fun toNumber(number: String): BigDecimal {
            require(number.toBigDecimalOrNull() != null) { "숫자가 아닙니다. [$number]" }
            return number.toBigDecimal()
        }

        private fun validLength(size: Int) = size >= 3 || size % 2 == 1
    }
}
