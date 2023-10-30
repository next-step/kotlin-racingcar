package calculator

data class Expression(
    val left: Long?,
    val operator: Operator,
    val right: Long,
) {
    fun calculate(): Long {
        require(left != null) { throw IllegalArgumentException("left 값이 없습니다. 앞선 계산식의 결과를 매개변수로 포함해주세요.") }

        return operator.operate(left, right)
    }

    fun calculate(expressionResult: Long): Long = operator.operate(expressionResult, right)
}
