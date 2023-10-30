package calculator

import calculator.util.regexForNumberAndOperator

data class UserInput(val inputString: String) {

    fun validate() {
        require(this.inputString.isNotBlank()) {
            throw IllegalArgumentException("계산식이 비어있습니다")
        }
        require(this.inputString.matches(regexForNumberAndOperator)) {
            throw IllegalArgumentException("계산식에 숫자와 사칙연산 기호 이외의 값이 포함되어 있습니다")
        }
    }
}
