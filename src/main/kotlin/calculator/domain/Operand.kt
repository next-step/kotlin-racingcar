package calculator.domain

import java.util.regex.Pattern

class Operand {
    val value: Double

    constructor(value: String) {
        verify(value)
        this.value = value.toDouble()
    }

    private fun verify(value: String) {
        require((value.isNotEmpty() || REGEX.matcher(value).matches())) { "올바른 형식의 피연산자가 아닙니다." }
    }
    
    companion object {
        private val REGEX = Pattern.compile("-?\\d+(\\.\\d+)?")
    }
}
