package calculator

import calculator.common.isNotNumber
import calculator.common.isNotOperator

class Parser {

    fun parse(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            return emptyList()
        }
        return input.split(" ")
    }

    fun validate(elements: List<String>): Boolean {
        if (elements.isEmpty()) return false

        // 요소 중에서 연산자가 아니거나 숫자가 아닌 게 있는지 조사
        elements.forEach { element ->
            if (element.isNotNumber() && element.isNotOperator()) {
                return false
            }
        }
        return true
    }
}
