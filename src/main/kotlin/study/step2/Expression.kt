package study.step2

private const val EMPTY_SPACE = " "

object Expression {

    fun valid(str: String) {
        validEmpty(str)
        validRule(str.split(EMPTY_SPACE))
    }

    fun parse(str: String): List<String> = str.split(EMPTY_SPACE)

    private fun validEmpty(str: String) {
        require(str.trim().isNotEmpty()) { "입력값이 null이거나 빈 공백 문자가 될 수 없습니다" }
    }

    private fun validRule(splitStr: List<String>) {
        require(splitStr.last().isInt()) { "계산식이 올바르지 않습니다" }

        splitStr.forEachIndexed { index, s ->
            val isInt = s.isInt()
            val existOperator = OperatorEnum.exist(s)
            if (!isInt && !existOperator) {
                throw IllegalArgumentException("올바르지 않은 사칙연산 기호입니다")
            }

            val numberRule = index.mod(2) == 0 && isInt
            val operatorRule = index.mod(2) == 1 && existOperator
            if (!numberRule && !operatorRule) {
                throw IllegalArgumentException("계산식의 순서가 맞지 않습니다")
            }
        }
    }
}
