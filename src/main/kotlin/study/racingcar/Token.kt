package study.racingcar

/**
 * Token 은
 *    1. 연산자와 피연산자를 갖는다.
 *    2. 연산자는 1개의 문자로 이루어져 있으며, 연산자는 ENUM 에 정의 되어 있어야 한다.
 *    3. 피연산자는 Int 범위의 양의 정수로 이루어져 있으며, 연산 가능한 숫자여야 한다.
 * */
class Token(
    private var operator: String = "",
    private var operand: String = ""
) {

    fun getOperator(): String {
        return operator
    }

    fun getOperand(): String {
        return operand
    }

    fun setOperator(newOperator: String) {
        operator = newOperator
    }

    fun setOperand(newOperand: String) {
        operand = newOperand
    }

    /**
     * 주어진 문자가 연산 가능한(Int) 범위인지 확인합니다.
     * @param 확인할 문자
     * @return 문자가 숫자인 경우 true, 숫자가 아닌 경우 false를 반환합니다.
     */
    fun isInterpretableNumber(): Boolean {
        return try {
            operand.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    /**
     * 주어진 문자가 연산 가능한 연산자인지 확인합니다.
     * @param op 확인할 연산자 문자
     * @return 연산 가능한 연산자인 경우 true, 그렇지 않은 경우 false를 반환합니다.
     */
    fun isInterpretableOperator(): Boolean {
        return Operator.TOATAL.symbol.contains(operator) && (operator.length == 1)
    }

    override fun toString(): String {
        return "Token(operator='$operator', operand='$operand')"
    }
}
