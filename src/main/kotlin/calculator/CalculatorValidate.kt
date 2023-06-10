package calculator

object CalculatorValidate {
    fun input(str: String?): String {
        require(!str.isNullOrEmpty()) {
            "입력값이 null이거나 빈 공백 문자일 경우"
        }
        return str
    }

    fun number(str: String): Int {
        require("[0-9]".toRegex().matches(str)) {
            "피연자가 숫자가 아닌 경우"
        }
        return str.toInt()
    }

    fun operator(operator: Operator?): Operator {
        require(operator != null) {
            "사칙연산 기호가 아닌 경우"
        }
        return operator
    }
}
