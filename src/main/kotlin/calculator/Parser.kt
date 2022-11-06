package calculator

import calculator.common.isNotNumber
import calculator.common.isNotOperator

class Parser(private val limit: Int) {

    fun parse(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            return emptyList()
        }
        return input.split(" ")
    }

    @Throws(IllegalArgumentException::class)
    fun validate(elements: List<String>): Boolean {
        if (elements.isEmpty()) throw IllegalArgumentException("elements is empty")
        if (elements.size < limit) throw IllegalArgumentException("elements size less than min size")

        // 요소 중에서 연산자가 아니거나 숫자가 아닌 게 있는지 조사
        elements.forEach { element ->
            if (element.isNotNumber() && element.isNotOperator()) {
                throw IllegalArgumentException("element is not valid")
            }
        }
        return true
    }
}
