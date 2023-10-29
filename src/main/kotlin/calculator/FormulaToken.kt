package calculator

data class FormulaToken(private val input: String) {

    val operator: Operator = Operator.from(input.substring(0, 1))
    val operand: Int = input.substring(1).toInt()

    init {
        require(input.substring(1).all { it.isDigit() }) { "피연산자는 숫자만 입력할 수 있습니다." }
    }
}
