package step2

import step2.number.Number
import step2.number.Numbers
import step2.operator.Operator
import step2.operator.Operators
import java.util.function.Function
import java.util.function.Predicate

class Expression(expression: String) {
    private val numbers: Numbers
    private val operators: Operators

    init {
        val split = expression.split(DELIMITER)
        numbers = Numbers(split.parse(Predicate { isOrderOfNumber(it) }, Function { Number.of(it) }))
        operators = Operators(split.parse(Predicate { isOrderOfOperator(it) }, Function { Operator.findBy(it) }))
    }

    private fun <T> Iterable<String>.parse(filter: Predicate<Int>, converter: Function<String, T>) = this.withIndex()
        .filter { filter.test(it.index) }
        .map { converter.apply(it.value) }
        .toList()

    private fun isOrderOfNumber(order: Int) = order % 2 == 0

    private fun isOrderOfOperator(order: Int) = !isOrderOfNumber(order)

    fun calculate(): Int {
        return operators.calculate(numbers)
    }

    companion object {
        private const val DELIMITER = " "
    }
}
