package calculator

import calculator.common.isNotNumber
import calculator.common.isNotOperator

class Parser(private val limit: Int) {

    fun parse(input: String): List<String> {
        if (input.isBlank()) {
            return emptyList()
        }
        return input.split(" ")
    }

    @Throws(IllegalArgumentException::class)
    fun validate(elements: List<String>): Boolean {
        require(elements.size >= limit) { "elements size less min size" }

        // 요소 중에서 연산자가 아니거나 숫자가 아닌 게 있는지 조사
        elements.forEach { element ->
            if (element.isNotNumber() && element.isNotOperator()) {
                throw IllegalArgumentException("element is not valid")
            }
        }
        return true
    }
}
