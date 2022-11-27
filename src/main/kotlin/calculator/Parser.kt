package calculator

import calculator.common.isNotNumber
import calculator.common.isNotOperator

class Parser(private val limit: Int = 0) {

    fun provideElementsIterator(expression: String?): ListIterator<String> {
        requireNotNull(expression) { "expression is null" }
        val elements = parse(expression)
        if (validate(elements).not()) throw IllegalArgumentException("element is not valid")
        return elements.listIterator()
    }

    fun parse(input: String): List<String> {
        return parse(input = input, delimiter = " ")
    }

    fun parse(input: String, delimiter: String): List<String> {
        if (input.isBlank()) {
            return emptyList()
        }
        return input.split(delimiter)
    }

    @Throws(IllegalArgumentException::class)
    fun validate(elements: List<String>): Boolean {
        require(elements.size >= limit) { "elements size less min size" }

        // 요소 중에서 연산자가 아니거나 숫자가 아닌 게 있는지 조사
        return elements.none { element ->
            element.isNotNumber() && element.isNotOperator()
        }
    }
}
